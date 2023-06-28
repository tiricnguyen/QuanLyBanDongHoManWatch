/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.KhachHang;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.KhachHangRepository;
import service.KhachHangService;
import service.NhanVienService;
import viewModel.KhachHangResponse;
import viewModel.NhanVienResponse;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository khRepo = new KhachHangRepository();

    @Override
    public List<KhachHangResponse> getAllResponse() {
        return khRepo.getAllResponse();
    }

    @Override
    public String insert(KhachHang kh) {
        if (kh.getMa().trim().isEmpty() || kh.getHoVaTen().trim().isEmpty()
                || kh.getDiaChi().trim().isEmpty() || kh.getSdt().trim().isEmpty()
                || kh.getNgaySinh().isEmpty()) {
            return "Không để trống";
        }
        try {
            Long.parseLong(kh.getSdt());
        } catch (Exception e) {
            return "Nhập số điện thoai";
        }
        if (kh.getSdt().length() != 10) {
            return "Số điện thoại phải 10";
        }
        if (!kh.getSdt().startsWith("0")) {
            return "Số điện thoại bắt đầu bằng số 0";
        }
        KhachHang khMa = khRepo.findByMa(kh.getMa());
        if (khMa != null) {
            return "Mã không được trùng";
        }
        kh.setTrangThai(1);
        kh = khRepo.saveOrUpdate(kh);
        if (kh != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHang kh) {
        double ranDomMa = Math.random() * 10000;
        int ma = (int) ranDomMa;
        String MaMoi = "NV00" + ma;
        kh.setMa(MaMoi);
        if (kh.getMa().trim().isEmpty() || kh.getHoVaTen().trim().isEmpty()
                || kh.getDiaChi().trim().isEmpty() || kh.getSdt().trim().isEmpty()
                || kh.getNgaySinh().trim().isEmpty()) {
            return "Không để trống";
        }

        try {
            Long.parseLong(kh.getSdt());
        } catch (Exception e) {
            return "Nhập số điện thoai";
        }
        if (kh.getSdt().length() != 10) {
            return "Số điện thoại phải 10";
        }
        if (!kh.getSdt().startsWith("0")) {
            return "Số điện thoại bắt đầu bằng số 0";
        }

        kh = khRepo.saveOrUpdate(kh);
        if (kh != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<KhachHangResponse> getAllByTrangThai(int trangThai) {
        return khRepo.getAllByTrangThai(trangThai);
    }

    @Override
    public List<KhachHangResponse> getAllByTenOrTrangThai(String ten, int trangThai) {
        return khRepo.getAllByNameAndTrangThai(ten, trangThai);
    }

    @Override
    public List<KhachHang> getAll() {
        return khRepo.getAll();
    }

    @Override
    public String printExcel() {
        KhachHangService nvsv = new KhachHangServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<KhachHangResponse> listExPort = nvsv.getAllResponse();
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                KhachHangResponse nv = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(nv.getMa());

                cell = row.createCell(1);
                cell.setCellValue(nv.getHoVaTen());

                cell = row.createCell(2);
                cell.setCellValue(nv.getNgaySinh());

                cell = row.createCell(3);
                cell.setCellValue(nv.getDiaChi());

                cell = row.createCell(4);
                cell.setCellValue(nv.getSdt());
            }
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter fileName = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(fileName);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String path = chooser.getSelectedFile().getPath();
                if (!path.contains(".xlsx")) {
                    path += ".xlsx";
                }
                FileOutputStream fos = new FileOutputStream(path);
                workbook.write(fos);
                fos.flush();
                fos.close();

            }

            return "Thành công";

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "Thất bại";
    }

    @Override
    public KhachHang findId(UUID id) {
        return khRepo.findById(id);
    }

    @Override
    public KhachHang findBySDT(String SDT) {
        return khRepo.findBySdt(SDT);
    }

    @Override
    public KhachHang SaveOrUpdate(KhachHang kh) {
        return khRepo.saveOrUpdate(kh);
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangServiceImpl().findBySDT("0654875215").toString());
    }

    @Override
    public List<KhachHangResponse> sreachSdt(String sdt, int tt) {
        return khRepo.sreachSdt(sdt, tt);
    }
}

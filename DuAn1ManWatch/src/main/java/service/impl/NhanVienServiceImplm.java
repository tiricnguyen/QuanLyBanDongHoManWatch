/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainModel.NhanVien;
import viewModel.NhanVienResponse;
import jakarta.mail.MessagingException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.NhanVienRepository;
import service.NhanVienService;

/**
 *
 * @author congh
 */
public class NhanVienServiceImplm implements NhanVienService {

    private NhanVienRepository nhanVienRes = new NhanVienRepository();

    public NhanVien saveOne(NhanVien nv) {
        return nhanVienRes.saveOrUpdate(nv);
    }

    public boolean UpdateTrangThai(NhanVien nv) {

        NhanVien nvs = nhanVienRes.saveOrUpdate(nv);
        if (nvs != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String insert(NhanVien nv) {
        double id = Math.random() * 1000;
        int i = (int) id;
        String ma = "NV00" + i;
        nv.setMa(ma);
        if (nv.getMa().trim().isEmpty() || nv.getHoVaTen().trim().isEmpty()
                || nv.getNgaySinh().trim().isEmpty() || nv.getSdt().trim().isEmpty()
                || nv.getEmail().trim().isEmpty()
                || String.valueOf(nv.getGioiTinh()).trim().isEmpty()
                || String.valueOf(nv.getTrangThai()).trim().isEmpty()
                || nv.getSdt().trim().isEmpty()
                || nv.getDiaChi().trim().isEmpty()) {
            return "Không để trống";
        }
        try {
            Long.parseLong(nv.getSdt());
        } catch (Exception e) {
            return "Nhập số điện thoại";
        }
        if (nv.getSdt().length() != 10 || !nv.getSdt().startsWith("0")) {
            return "Số điện thoại phải 10 số và bắt đầu = 0";
        }

        if (!nv.getEmail().matches("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$")) {
            return "Vui lòng nhập đúng định dạng email";
        }
        if (nhanVienRes.timGmail(nv.getEmail()) != null) {
            return "Email đã tồn tại";
        }

        NhanVien nvMs = nhanVienRes.findByMa(nv.getMa());
        if (nvMs != null) {
            return "Mã nvông được trùng";
        }

        int cuoi = nv.getHoVaTen().lastIndexOf(" ");
        String name = nv.getHoVaTen().substring(cuoi);
        String notHoa = name.toLowerCase();
        String matKhau = notHoa + "@123";
        nv.setMatKhau(matKhau);
        nv = nhanVienRes.saveOrUpdate(nv);
        if (nv != null) {
            String email = nv.getEmail();
            new NhanVienServiceImplm().guiMail(email, "Đăng kí nhân viên thành công",
                    "Mat khẩu của bạn là:" + notHoa);
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String update(NhanVien nv) {
        double id = Math.random() * 1000;
        int i = (int) id;
        String ma = "NV00" + i;
        nv.setMa(ma);
        NhanVien nvID = nhanVienRes.findById(nv.getId());
        if (nvID == null) {
            return "Không tìm thấy";
        }
        if (nv.getMa().trim().isEmpty() || nv.getHoVaTen().trim().isEmpty()
                || nv.getNgaySinh().trim().isEmpty() || nv.getSdt().trim().isEmpty()
                || nv.getEmail().trim().isEmpty()
                || String.valueOf(nv.getGioiTinh()).trim().isEmpty()
                || String.valueOf(nv.getTrangThai()).trim().isEmpty()
                || nv.getEmail().trim().isEmpty()
                || nv.getSdt().trim().isEmpty()
                || nv.getDiaChi().trim().isEmpty()) {
            return "Không để trống";
        }
        try {
            Long.parseLong(nv.getSdt());
        } catch (Exception e) {
            return "Nhập số điện thoại";
        }
        if (nv.getSdt().length() != 10 || !nv.getSdt().startsWith("0")) {
            return "Số điện thoại phải 10 số và bắt đầu = 0";
        }

        NhanVien nvMs = nhanVienRes.findByMa(nv.getMa());

        if (nvMs != null && !nvMs.getMa().equals(nv.getMa())) {
            return "Mã nvông được trùng";
        }

        nv = nhanVienRes.saveOrUpdate(nv);
        if (nv != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thành công";
        }
    }

    @Override
    public int guiMail(String emailNhan, String tieuDe, String noiDung) {
        if (emailNhan.trim().isEmpty()) {
            return 0;
        }
        if (nhanVienRes.timGmail(emailNhan) != null) {
            double ranDomDouble = Math.random() * 100000;
            int thongDiep = (int) ranDomDouble;
            String maXacNhan;
            try {
                maXacNhan = nhanVienRes.guiMail(emailNhan, "Mã xác nhận mật khẩu", String.valueOf(thongDiep));
                return Integer.parseInt(maXacNhan);
            } catch (MessagingException ex) {
                Logger.getLogger(NhanVienServiceImplm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return 1;
        }
        return 2;
    }

    @Override
    public List<NhanVien> getALL() {
        return nhanVienRes.getAll();
    }

    @Override
    public List<NhanVienResponse> getAllResponse() {
        return nhanVienRes.getAllResponse();
    }

    @Override
    public NhanVien getLoGin(String Gmail, String MK) {
        NhanVien nv = nhanVienRes.findByGmailAndMK(Gmail, MK);
        if (nv == null) {
            return nv;
        } else {
            return nv;
        }
    }

    public String timGmail(String gmail) {
        if (nhanVienRes.timGmail(gmail) == null) {
            return "Chịu";
        } else {
            return "Ok";
        }
    }

    public static void main(String[] args) {
    }

    @Override
    public NhanVien SaveOrUpdate(NhanVien nv) {
        return nhanVienRes.saveOrUpdate(nv);
    }

    public List<NhanVienResponse> getAllByTrangThai(int trangThai) {
        return nhanVienRes.getAllByTrangThai(trangThai);
    }

    @Override
    public List<NhanVienResponse> getAllByNameAndtrangThai(String name, int trangThai) {
        return nhanVienRes.getAllByNameAndTrangThai(name, trangThai);
    }

    public NhanVien findId(UUID id) {
        return nhanVienRes.findById(id);
    }

    public NhanVien finByMa(String ma) {
        return nhanVienRes.findByMa(ma);
    }

    public String printExcel() {
        NhanVienService nvsv = new NhanVienServiceImplm();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<NhanVienResponse> listExPort = nvsv.getAllResponse();
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                NhanVienResponse nv = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(nv.getMa());

                cell = row.createCell(1);
                cell.setCellValue(nv.getHoVaTen());

                cell = row.createCell(2);
                cell.setCellValue(nv.getGioiTinh() == 1 ? "Nam" : "Nữ");

                cell = row.createCell(3);
                cell.setCellValue(nv.getNgaySinh());

                cell = row.createCell(4);
                cell.setCellValue(nv.getEmail());

                cell = row.createCell(5);
                cell.setCellValue(nv.getHinhAnh());

                cell = row.createCell(6);
                cell.setCellValue(nv.getChucVu() == 1 ? "Trưởng phòng" : "Nhân Viên");

                cell = row.createCell(7);
                cell.setCellValue(nv.getDiaChi());

                cell = row.createCell(8);
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

    public void chonAnh() {

    }

    @Override
    public NhanVien findByMa(String ma) {
        return nhanVienRes.findByMa(ma);
    }

}

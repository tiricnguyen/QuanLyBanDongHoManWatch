/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuDay;
import domainModel.SanPham;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.ChatLieuDayRepository;
import repository.impl.SanPhamRepository;
import service.ChatLieuDayService;
import service.SanPhamService;
import viewModel.ChatLieuDayRepsonse;
import viewModel.SanPhamResponse;

/**
 *
 * @author Admin
 */
public class SanPhamServiceImpl implements SanPhamService {

    SanPhamRepository spRepo = new SanPhamRepository();

    @Override
    public List<SanPhamResponse> getAllRespone() {
        return spRepo.getAllResponse();
    }

    @Override
    public List<SanPham> getAll() {
        return spRepo.getAll();
    }

    @Override
    public SanPham findIdCbx(String ten) {
        return spRepo.findIdCbx(ten);
    }

    @Override
    public String insert(SanPham sp) {
        if (spRepo.findByMa(sp.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (sp.getMa().trim().isEmpty() || sp.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (spRepo.saveOrUpdate(sp) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(SanPham sp) {
        if (spRepo.findById(sp.getId()) == null) {
            return "ID không tồn tại";
        }

        if (sp.getMa().trim().isEmpty() || sp.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (spRepo.saveOrUpdate(sp) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }

    }

    @Override
    public List<SanPhamResponse> getAllByTrangThai(int tt) {
        return spRepo.getAllByTrangThai(tt);
    }

    @Override
    public SanPham findById(UUID id) {
        return spRepo.findById(id);
    }

    @Override
    public String printExcel() {
        SanPhamService nvsv = new SanPhamServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<SanPhamResponse> listExPort = nvsv.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                SanPhamResponse nv = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(nv.getMa());

                cell = row.createCell(1);
                cell.setCellValue(nv.getTen());
                
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
    public List<SanPhamResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return spRepo.getAllByTenOrTrangThai(Ten, tt);
    }
}

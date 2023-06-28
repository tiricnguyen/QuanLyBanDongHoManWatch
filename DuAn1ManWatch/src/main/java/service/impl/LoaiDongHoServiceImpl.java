 /*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.LoaiDongHo;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.LoaiDongHoRepository;
import service.LoaiDongHoService;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public class LoaiDongHoServiceImpl implements LoaiDongHoService {

    LoaiDongHoRepository ldhRepo = new LoaiDongHoRepository();

    @Override
    public List<LoaiDongHoResponse> getAllRespone() {
        return ldhRepo.getAllResponse();
    }

    @Override
    public List<LoaiDongHo> getAll() {
        return ldhRepo.getAll();
    }

    @Override
    public LoaiDongHo findIdCbx(String ten) {
        return ldhRepo.findIdCbx(ten);
    }

    @Override
    public String insert(LoaiDongHo ldh) {
        if (ldhRepo.findByMa(ldh.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (ldh.getMa().trim().isEmpty() || ldh.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (ldhRepo.saveOrUpdate(ldh) != null) {
            return "thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public String update(LoaiDongHo ldh) {
        if (ldhRepo.findById(ldh.getId()) == null) {
            return "ID không tồn tại";
        }
        if (ldh.getMa().trim().isEmpty() || ldh.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (ldhRepo.saveOrUpdate(ldh) != null) {
            return "Thành công";
        } else {
            return "Thất bại";
        }
    }

    @Override
    public List<LoaiDongHoResponse> getAllByTrangThai(int tt) {
        return ldhRepo.getAllByTrangThai(tt);
    }

    @Override
    public LoaiDongHo findById(UUID id) {
        return ldhRepo.findById(id);
    }

    @Override
    public String printExcel() {
        LoaiDongHoService nvsv = new LoaiDongHoServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<LoaiDongHoResponse> listExPort = nvsv.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                LoaiDongHoResponse nv = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(nv.getMa());

                cell = row.createCell(1);
                cell.setCellValue(nv.getTen());
//
//                cell = row.createCell(2);
//                cell.setCellValue(nv.getTrangThai() == 1 ? "Active" : "InActive");

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
    public List<LoaiDongHoResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return ldhRepo.getAllByTenOrTrangThai(Ten, tt);
    }
}

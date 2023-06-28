/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.HangDongHo;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.HangDongHoRepository;
import service.HangDongHoService;
import viewModel.HangDongHoResponse;

/**
 *
 * @author Admin
 */
public class HangDongHoServiceImpl implements HangDongHoService {

    HangDongHoRepository hdhRepo = new HangDongHoRepository();

    @Override
    public List<HangDongHoResponse> getAllRespone() {
        return hdhRepo.getAllResponse();
    }

    @Override
    public List<HangDongHo> getAll() {
        return hdhRepo.getAll();
    }

    @Override
    public HangDongHo findIdCbx(String ten) {
        return hdhRepo.findIdCbx(ten);
    }

    @Override
    public String insert(HangDongHo hdh) {
        if (hdhRepo.findByMa(hdh.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (hdh.getMa().trim().isEmpty() || hdh.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (hdhRepo.saveOrUpdate(hdh) != null) {
            return "thêm thành công";
        } else {
            return "thêm thất bại";
        }
    }

    @Override
    public String update(HangDongHo hdh) {
        if (hdhRepo.findById(hdh.getId()) == null) {
            return "ID không tồn tại";
        }
        if (hdh.getMa().trim().isEmpty() || hdh.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (hdhRepo.saveOrUpdate(hdh) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }

    }

    @Override
    public List<HangDongHoResponse> getAllByTrangThai(int tt) {
        return hdhRepo.getAllByTrangThai(tt);
    }

    @Override
    public HangDongHo findById(UUID id) {
        return hdhRepo.findById(id);
    }

    @Override
    public String printExcel() {
        HangDongHoService nvsv = new HangDongHoServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<HangDongHoResponse> listExPort = nvsv.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                HangDongHoResponse nv = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(nv.getMa());

                cell = row.createCell(1);
                cell.setCellValue(nv.getTen());

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
    public List<HangDongHoResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return hdhRepo.getAllByTenOrTrangThai(Ten, tt);
    }
}

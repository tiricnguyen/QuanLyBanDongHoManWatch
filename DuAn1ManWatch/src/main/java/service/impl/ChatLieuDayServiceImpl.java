/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuDay;
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
import service.ChatLieuDayService;
import viewModel.ChatLieuDayRepsonse;

/**
 *
 * @author Admin
 */
public class ChatLieuDayServiceImpl implements ChatLieuDayService {

    ChatLieuDayRepository cldRepo = new ChatLieuDayRepository();

    @Override
    public List<ChatLieuDayRepsonse> getAllRespone() {
        return cldRepo.getAllResponse();
    }

    @Override
    public List<ChatLieuDay> getAll() {
        return cldRepo.getAll();
    }

    @Override
    public ChatLieuDay findIdCbx(String ten) {
        return cldRepo.findIdCbx(ten);
    }
    
      @Override
    public String insert(ChatLieuDay cld) {
        if (cldRepo.findByMa(cld.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (cld.getMa().trim().isEmpty() || cld.getTen().trim().isEmpty()
                || cld.getMauSac().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (cldRepo.saveOrUpdate(cld) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChatLieuDay cld) {
        if (cldRepo.findById(cld.getId()) == null) {
            return "ID không tồn tại";
        }

        if (cld.getMa().trim().isEmpty() || cld.getTen().trim().isEmpty()
                || cld.getMauSac().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (cldRepo.saveOrUpdate(cld) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public List<ChatLieuDayRepsonse> getAllByTrangThai(int tt) {
        return cldRepo.getAllByTrangThai(tt);
    }

    @Override
    public ChatLieuDay findById(UUID id) {
        return cldRepo.findById(id);
    }

    @Override
    public String printExcel() {
        ChatLieuDayService cld = new ChatLieuDayServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<ChatLieuDayRepsonse> listExPort = cld.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                ChatLieuDayRepsonse cldr = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(cldr.getMa());

                cell = row.createCell(1);
                cell.setCellValue(cldr.getTen());

//                cell = row.createCell(2);
//                cell.setCellValue(clvr.getTrangThai() == 1 ? "Active" : "InActive");
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
    public List<ChatLieuDayRepsonse> getAllByTenOrTrangThai(String Ten, int tt) {
        return cldRepo.getAllByTenOrTrangThai(Ten, tt);
    }
}

/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuVo;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.ChatLieuVoRepository;
import service.ChatLieuVoService;
import viewModel.ChatLieuVoResponse;

/**
 *
 * @author Admin
 */
public class ChatLieuVoServiceImpl implements ChatLieuVoService {

    ChatLieuVoRepository clvRepo = new ChatLieuVoRepository();

    @Override
    public List<ChatLieuVoResponse> getAllRespone() {
        return clvRepo.getAllResponse();
    }

    @Override
    public List<ChatLieuVo> getAll() {
        return clvRepo.getAll();
    }

    @Override
    public ChatLieuVo findIdCbx(String ten) {
        return clvRepo.findIdCbx(ten);
    }
    
     @Override
    public String insert(ChatLieuVo clv) {
        if (clvRepo.findByMa(clv.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (clv.getMa().trim().isEmpty() || clv.getTen().trim().isEmpty()
                || clv.getMauSac().trim().isEmpty() || clv.getMoTa().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (clvRepo.saveOrUpdate(clv) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChatLieuVo clv) {
        if (clvRepo.findById(clv.getId()) == null) {
            return "ID không tồn tại";
        }

        if (clv.getMa().trim().isEmpty() || clv.getTen().trim().isEmpty()
                || clv.getMauSac().trim().isEmpty() || clv.getMoTa().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (clvRepo.saveOrUpdate(clv) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public List<ChatLieuVoResponse> getAllByTrangThai(int tt) {
        return clvRepo.getAllByTrangThai(tt);
    }

    @Override
    public ChatLieuVo findById(UUID id) {
        return clvRepo.findById(id);
    }

    @Override
    public String printExcel() {
        ChatLieuVoService clv = new ChatLieuVoServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<ChatLieuVoResponse> listExPort = clv.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                ChatLieuVoResponse clvr = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(clvr.getMa());

                cell = row.createCell(1);
                cell.setCellValue(clvr.getTen());

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
    public List<ChatLieuVoResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return clvRepo.getAllByTenOrTrangThai(Ten, tt);
    }
}

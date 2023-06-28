/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuMatKinh;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.ChatLieuMatKinhRepository;
import service.ChatLieuMatKinhService;
import viewModel.ChatLieuMatKinhResponse;


/**
 *
 * @author Admin
 */
public class ChatLieuMatKinhServiceImpl implements ChatLieuMatKinhService {

    ChatLieuMatKinhRepository clmkRepo = new ChatLieuMatKinhRepository();

    @Override
    public List<ChatLieuMatKinhResponse> getAllRespone() {
        return clmkRepo.getAllResponse();
    }

    @Override
    public List<ChatLieuMatKinh> getAll() {
        return clmkRepo.getAll();
    }

    @Override
    public ChatLieuMatKinh findIdCbx(String ten) {
        return clmkRepo.findIdCbx(ten);
    }
    
     @Override
    public String insert(ChatLieuMatKinh clmk) {
        if (clmkRepo.findByMa(clmk.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (clmk.getMa().trim().isEmpty() || clmk.getTen().trim().isEmpty()
                || clmk.getSizeMatKinh().trim().isEmpty() || clmk.getDoDay().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (clmkRepo.saveOrUpdate(clmk) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChatLieuMatKinh clmk) {
        if (clmkRepo.findById(clmk.getId()) == null) {
            return "ID không tồn tại";
        }

        if (clmk.getMa().trim().isEmpty() || clmk.getTen().trim().isEmpty()
                || clmk.getSizeMatKinh().trim().isEmpty() || clmk.getDoDay().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (clmkRepo.saveOrUpdate(clmk) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public List<ChatLieuMatKinhResponse> getAllByTrangThai(int tt) {
        return clmkRepo.getAllByTrangThai(tt);
    }

    @Override
    public ChatLieuMatKinh findById(UUID id) {
        return clmkRepo.findById(id);
    }

    @Override
    public String printExcel() {
        ChatLieuMatKinhService clmk = new ChatLieuMatKinhServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<ChatLieuMatKinhResponse> listExPort = clmk.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                ChatLieuMatKinhResponse clmkr = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(clmkr.getMa());

                cell = row.createCell(1);
                cell.setCellValue(clmkr.getTen());
                
                cell = row.createCell(2);
                cell.setCellValue(clmkr.getSizeMatKinh());

                cell = row.createCell(3);
                cell.setCellValue(clmkr.getDoDay());
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
    public List<ChatLieuMatKinhResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return clmkRepo.getAllByTenOrTrangThai(Ten, tt);
    }
}

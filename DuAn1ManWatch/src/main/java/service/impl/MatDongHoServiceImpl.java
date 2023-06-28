/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.MatDongHo;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.MatDongHoRepository;
import service.MatDongHoService;
import viewModel.MatDongHoResponse;

/**
 *
 * @author Admin
 */
public class MatDongHoServiceImpl implements MatDongHoService {

    MatDongHoRepository mdhRepo = new MatDongHoRepository();

    @Override
    public List<MatDongHoResponse> getAllRespone() {
        return mdhRepo.getAllResponse();
    }

    @Override
    public List<MatDongHo> getAll() {
        return mdhRepo.getAll();
    }

    @Override
    public MatDongHo findIdCbx(String ten) {
        return mdhRepo.findIdCbx(ten);
    }
    
      @Override
    public String insert(MatDongHo mdh) {
        if (mdhRepo.findByMa(mdh.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (mdh.getMa().trim().isEmpty() || mdh.getHinhDangMat().trim().isEmpty()
                || mdh.getMauSac().trim().isEmpty() || mdh.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (mdhRepo.saveOrUpdate(mdh) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(MatDongHo mdh) {
        if (mdhRepo.findById(mdh.getId()) == null) {
            return "ID không tồn tại";
        }

        if (mdh.getMa().trim().isEmpty() || mdh.getHinhDangMat().trim().isEmpty()
                || mdh.getMauSac().trim().isEmpty() || mdh.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }
        if (mdhRepo.saveOrUpdate(mdh) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public List<MatDongHoResponse> getAllByTrangThai(int tt) {
        return mdhRepo.getAllByTrangThai(tt);
    }

    @Override
    public MatDongHo findById(UUID id) {
        return mdhRepo.findById(id);
    }

    @Override
    public String printExcel() {
        MatDongHoService mdh = new MatDongHoServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<MatDongHoResponse> listExPort = mdh.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                MatDongHoResponse mdhr = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(mdhr.getMa());

                cell = row.createCell(1);
                cell.setCellValue(mdhr.getMauSac());

                cell = row.createCell(1);
                cell.setCellValue(mdhr.getHinhDangMat());

                cell = row.createCell(1);
                cell.setCellValue(mdhr.getTen());

                cell = row.createCell(1);
                cell.setCellValue(mdhr.getKichThuocMat());
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
    public List<MatDongHoResponse> getAllByKieuMat(String kieuMat, int tt) {
        return mdhRepo.getAllByTenOrTrangThai(kieuMat, tt);
    }
    
    
}

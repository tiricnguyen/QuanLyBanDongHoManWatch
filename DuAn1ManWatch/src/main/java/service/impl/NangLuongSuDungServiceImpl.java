/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.NangLuongSuDung;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.NangLuongSuDungRepository;
import service.NangLuongSuDungService;
import viewModel.NangLuongSuDungResponse;

/**
 *
 * @author Admin
 */
public class NangLuongSuDungServiceImpl implements NangLuongSuDungService {

    NangLuongSuDungRepository nlsdRepo = new NangLuongSuDungRepository();

    @Override
    public List<NangLuongSuDungResponse> getAllRespone() {
        return nlsdRepo.getAllResponse();
    }

    @Override
    public List<NangLuongSuDung> getAll() {
        return nlsdRepo.getAll();
    }

    @Override
    public NangLuongSuDung findIdCbx(String ten) {
        return nlsdRepo.findIdCbx(ten);
    }

    @Override
    public String insert(NangLuongSuDung nlsd) {

        if (nlsdRepo.findByMa(nlsd.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (nlsd.getMa().trim().isEmpty() || nlsd.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }

        if (nlsdRepo.saveOrUpdate(nlsd) != null) {
            return "Thêm thành công";
        } else {
            return "thêm thất bại";
        }

    }

    @Override
    public String update(NangLuongSuDung nlsd) {
        if (nlsdRepo.findById(nlsd.getId()) == null) {
            return "ID không tồn tại";
        }

        if (nlsd.getMa().trim().isEmpty() || nlsd.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }

        if (nlsdRepo.saveOrUpdate(nlsd) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public List<NangLuongSuDungResponse> getAllByTrangThai(int tt) {
        return nlsdRepo.getAllByTrangThai(tt);
    }

    @Override
    public NangLuongSuDung findById(UUID id) {
        return nlsdRepo.findById(id);
    }

    @Override
    public String printExcel() {
        NangLuongSuDungService nvsv = new NangLuongSuDungServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<NangLuongSuDungResponse> listExPort = nvsv.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                NangLuongSuDungResponse nv = listExPort.get(i);

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
    public List<NangLuongSuDungResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return nlsdRepo.getAllByTenOrTrangThai(Ten, tt);
    }

    public static void main(String[] args) {
        List<NangLuongSuDungResponse> listNV = new NangLuongSuDungServiceImpl().getAllByTrangThai(1);
        for (NangLuongSuDungResponse x : listNV) {
            System.out.println(x.toString());
        }
    }
}

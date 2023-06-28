/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainModel.VoucherSanPham;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.impl.VoucherRepository;
import service.VoucherService;
import viewModel.VoucherResponse;

/**
 *
 * @author Oanh Xinh
 */
public class VoucherServiceImpl implements VoucherService {

    private VoucherRepository vc = new VoucherRepository();

    @Override
    public List<VoucherResponse> getAllRespone() {
        return vc.getAllResponse();
    }

    @Override
    public List<VoucherSanPham> getAll() {
        return vc.getAll();
    }

    @Override
    public String insert(VoucherSanPham vcsp) {
        if (vc.findByMa(vcsp.getMa()) != null) {
            return "Mã đã tồn tại";
        }
        if (vcsp.getMa().trim().isEmpty() || vcsp.getTen().trim().isEmpty()
                || vcsp.getNgayBatDau().trim().isEmpty()
                || vcsp.getNgayKetThuc().trim().isEmpty()) {
            return "Bạn không được để trống";
        }

//        try {
//            if (vcsp.getPhamTram() < 0) {
//                return "Phần trăm lớn 0";
//            }
//        } catch (Exception e) {
//            return "Nhập số";
//        }
//        
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
//
//        LocalDate ngayBt = LocalDate.parse(vcsp.getNgayBatDau(), df);
//         
//        LocalDate ngayKt = LocalDate.parse(vcsp.getNgayKetThuc(), df);
//        LocalDate toDay = LocalDate.now();
//
//        if (ngayBt.isBefore(toDay)) {
//            return "Ngày bắt đầu phải lớn hơn ngày hiện tại (" + toDay + ") !!";
//
//        }
//        if (ngayKt.isBefore(ngayBt)) {
//            return "Ngày kết thúc phải lớn hơn ngày bắt đầu !!";
//        }

        if (vc.saveOrUpdate(vcsp) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(VoucherSanPham vcsp) {
        if (vc.findById(vcsp.getId()) == null) {
            return "ID không tồn tại";
        }
        if (vcsp.getMa().trim().isEmpty() || vcsp.getTen().trim().isEmpty()) {
            return "Bạn không được để trống";
        }

        if (vc.saveOrUpdate(vcsp) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }

    }

    @Override
    public List<VoucherResponse> getAllByTrangThai(int tt) {
        return vc.getAllByTrangThai(tt);
    }

    @Override
    public VoucherSanPham findById(UUID id) {
        return vc.findById(id);
    }

    @Override
    public String printExcel() {
        VoucherService nvsv = new VoucherServiceImpl();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach_new");
            XSSFRow row = null;
            Cell cell = null;
            List<VoucherResponse> listExPort = nvsv.getAllByTrangThai(1);
            for (int i = 0; i < listExPort.size(); i++) {

                row = sheet.createRow(i);
                VoucherResponse nv = listExPort.get(i);

                cell = row.createCell(0);
                cell.setCellValue(nv.getMa());

                cell = row.createCell(1);
                cell.setCellValue(nv.getTen());

                cell = row.createCell(2);
                cell.setCellValue(nv.getPhamTram());

                cell = row.createCell(3);
                cell.setCellValue(nv.getNgayBatDau());

                cell = row.createCell(4);
                cell.setCellValue(nv.getNgayKetThuc());

                cell = row.createCell(5);
                cell.setCellValue(nv.getTrangThai() == 1 ? "Active" : "InActive");

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
    public List<VoucherResponse> getAllByTenOrTrangThai(String Ten, int tt) {
        return vc.getAllByTenOrTrangThai(Ten, tt);
    }

    @Override
    public VoucherSanPham findIdCbx(String ten) {
        return vc.findIdCbx(ten);
    }

    public static void main(String[] args) {
        List<VoucherResponse> list = new VoucherRepository().getAllByTenOrTrangThai("giảm giá 2 sản phẩm", 1);
        for (VoucherResponse x : list) {
            System.out.println(x.toString());
        }
    }

    @Override
    public VoucherSanPham findIdByMa(String ma) {
        return vc.findByMa(ma);
    }

    @Override
    public String updateTrangThai(UUID id, int trangThai) {
        if (vc.findById(id) == null) {
            return "ID không tồn tại";
        }

        if (vc.updateTrangThai(id, trangThai)) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }
}

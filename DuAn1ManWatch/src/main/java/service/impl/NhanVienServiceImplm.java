/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainModel.NhanVien;
import viewModel.NhanVienResponse;
import jakarta.mail.MessagingException;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }

    }

    @Override
    public String update(NhanVien nv) {
        NhanVien nvID = nhanVienRes.findById(nv.getId());
        if (nvID == null) {
            return "Không tìm thấy";
        }
        if (nv.getMa().trim().isEmpty() || nv.getHoVaTen().trim().isEmpty()
                || nv.getNgaySinh().trim().isEmpty() || nv.getSdt().trim().isEmpty()
                || nv.getEmail().trim().isEmpty()
                || String.valueOf(nv.getGioiTinh()).trim().isEmpty()
                || nv.getMatKhau().trim().isEmpty()
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
        if (!nv.getMa().equals(nvID.getMa())) {
            NhanVien nvMa = nhanVienRes.findByMa(nv.getMa());
            if (nvMa != null) {
                return "Mã nvông trùng";
            } else {
                nvID.setMa(nv.getMa());
            }
        }
        nvID.setMa(nv.getMa());
        nvID.setHoVaTen(nv.getHoVaTen());
        nvID.setDiaChi(nv.getDiaChi());
        nvID.setEmail(nv.getEmail());
        nvID.setNgaySinh(nv.getNgaySinh());
        nvID.setSdt(nv.getSdt());
        nvID.setHinhAnh(nv.getHinhAnh());
        nvID.setGioiTinh(nv.getGioiTinh());
        nvID.setChucVu(nv.getChucVu());
        nvID.setMatKhau(nv.getMatKhau());
        nvID.setTrangThai(nv.getTrangThai());
        nv = nhanVienRes.saveOrUpdate(nvID);
        if (nv != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thành công";
        }
    }

    @Override
    public String guiMail(String emailNhan, String tieuDe, String noiDung) {
        try {
            return nhanVienRes.guiMail(emailNhan, tieuDe, noiDung);
        } catch (MessagingException ex) {
            Logger.getLogger(NhanVienServiceImplm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public String getLoGin(String Gmail, String MK) {
        if (Gmail.trim().isEmpty()) {
            return "Không để trống gmail";
        } else if (MK.trim().isEmpty()) {
            return "Không để mật khẩu";
        } else {

        }
        if (nhanVienRes.findByGmailAndMK(Gmail, MK) == null) {
            return "Tài khoản hoặc mật khẩu không đúng";
        } else {
            return "Đăng nhập thành công";
        }
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

    public static void main(String[] args) {
        NhanVienService nvsv = new NhanVienServiceImplm();
        List<NhanVienResponse> listnvrp = new ArrayList<>();
        listnvrp = nvsv.getAllByTrangThai(0);
        for (NhanVienResponse nhanVienResponse : listnvrp) {
            System.out.println(nhanVienResponse.toString());
        }

    }

//    public String UpdateTrangThaiNew(NhanVien nv, int tt) {
//        nv.setTrangThai(tt);
//        if (nhanVienRes.UpdateTrangThai(nv) != null) {
//            return "Thành công";
//        } else {
//            return "Thất bại";
//        }
//    }
    public NhanVien findId(UUID id){
        return nhanVienRes.findById(id);
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
}

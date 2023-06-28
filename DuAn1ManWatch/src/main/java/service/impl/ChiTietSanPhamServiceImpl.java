/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChiTietSanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import repository.impl.ChiTietSanPhamRepository;
import service.ChiTietSanPhamService;
import viewModel.ChiTietSanPhamResponse;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    ChiTietSanPhamRepository ctSpRepo = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPhamResponse> getAllChiTietSanPham(int tt) {
        return ctSpRepo.getAllByTrangThai(tt);
    }

    @Override
    public List<ChiTietSanPham> getAll(int trangThai) {
        return ctSpRepo.getAllTrangThai(trangThai);
    }

    @Override
    public ChiTietSanPham insert(ChiTietSanPham ctsp) {
        ChiTietSanPham ctspChek = new ChiTietSanPham();
        if (String.valueOf(ctsp.getSizeDay()).trim().equals("")
                || String.valueOf(ctsp.getGiaBan()).trim().equals("")
                || String.valueOf(ctsp.getGiaNhap()).trim().equals("")
                || ctsp.getChongNuoc().trim().isEmpty()
                || ctsp.getMoTa().trim().isEmpty()
                || ctsp.getXuatXu().trim().isEmpty()) {
            ctspChek.setMoTa("Không được để trống!!!");
            return ctspChek;
        }
        try {
            ctsp.getGiaBan();
        } catch (NumberFormatException ex) {
            ctspChek.setMoTa("Gia ban phai la so!!!");
            return ctspChek;
        }
        try {
            ctsp.getGiaNhap();
        } catch (NumberFormatException ex) {
            ctspChek.setMoTa("Gia Nhap phai la so!!!");
            return ctspChek;
        }
        try {
            ctsp.getSizeDay();
        } catch (NumberFormatException ex) {
            ctspChek.setMoTa("Kich thuoc phai la so!!!");
            return ctspChek;
        }
        if (ctsp.getSizeDay() <= 0) {
            ctspChek.setMoTa("Kich thuoc day phai lon hon 0!!!");
            return ctspChek;
        }
        if (ctsp.getGiaBan().compareTo(BigDecimal.ONE) == -1) {
            ctspChek.setMoTa("Gia ban phai la so nguyen duong!!!");
            return ctspChek;
        }
        if (ctsp.getGiaNhap().compareTo(BigDecimal.ZERO) == -1) {
            ctspChek.setMoTa("Gia nhap phai la so nguyen duong!!!");
            return ctspChek;
        }
        ctsp = ctSpRepo.saveOrUpdate(ctsp);

        if (ctsp != null) {
            return ctsp;
        } else {
            ctspChek.setMoTa("Loi roi, nhap lai di!!!");
            return ctspChek;
        }

    }

    @Override
    public String update(ChiTietSanPham ctsp) {
        ChiTietSanPham chiTietSPFindId = ctSpRepo.findById(ctsp.getId());
        if (chiTietSPFindId == null) {
            return "Không tìm thấy !!";
        }
        if (String.valueOf(ctsp.getSizeDay()).trim().equals("")
                || String.valueOf(ctsp.getGiaBan()).trim().equals("")
                || String.valueOf(ctsp.getGiaNhap()).trim().equals("")
                || ctsp.getChongNuoc().trim().isEmpty()
                || ctsp.getMoTa().trim().isEmpty()
                || ctsp.getXuatXu().trim().isEmpty()) {
            return "Không được để trống!!!";
        }

        try {
            ctsp.getGiaBan();
        } catch (NumberFormatException ex) {
            return "GiaBan phải là số!!";
        }
        try {
            ctsp.getGiaNhap();
        } catch (NumberFormatException ex) {
            return "GiaNhap phải là số!!";
        }
        try {
            ctsp.getSizeDay();
        } catch (NumberFormatException ex) {
            return "Kích thước dây phải là số!!";
        }
        if (ctsp.getSizeDay() <= 0) {
            return "Kích thước dây phải lớn hơn 0";
        }
        if (ctsp.getGiaBan().compareTo(BigDecimal.ONE) == -1) {
            return "Giá bán phải là số nguyên dương";
        }
        if (ctsp.getGiaNhap().compareTo(BigDecimal.ZERO) == -1) {
            return "Giá nhập phải là số nguyên dương";
        }
        chiTietSPFindId.setChatLieuDay(ctsp.getChatLieuDay());
        chiTietSPFindId.setChatLieuMatKinh(ctsp.getChatLieuMatKinh());
        chiTietSPFindId.setChatLieuVo(ctsp.getChatLieuVo());
        chiTietSPFindId.setHangDongHo(ctsp.getHangDongHo());
        chiTietSPFindId.setLoaiDongHo(ctsp.getLoaiDongHo());
        chiTietSPFindId.setMatDongHo(ctsp.getMatDongHo());
        chiTietSPFindId.setNangLuongSD(ctsp.getNangLuongSD());
        chiTietSPFindId.setSanPham(ctsp.getSanPham());
        chiTietSPFindId.setBarCode(ctsp.getBarCode());
        chiTietSPFindId.setChongNuoc(ctsp.getChongNuoc());
        chiTietSPFindId.setSizeDay(ctsp.getSizeDay());
        chiTietSPFindId.setGiaBan(ctsp.getGiaBan());
        chiTietSPFindId.setSoLuong(ctsp.getSoLuong());
        chiTietSPFindId.setGiaNhap(ctsp.getGiaNhap());
        chiTietSPFindId.setMoTa(ctsp.getMoTa());
        chiTietSPFindId.setHinhAnh(ctsp.getHinhAnh());
        chiTietSPFindId.setXuatXu(ctsp.getXuatXu());
        chiTietSPFindId.setTrangThai(ctsp.getTrangThai());
        ctsp = ctSpRepo.saveOrUpdate(ctsp);
        if (ctsp != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }

    }

    @Override
    public List<ChiTietSanPhamResponse> search(String ten, int tt) {
        return ctSpRepo.getAllByTenOrTrangThai(ten, tt);
    }

    @Override
    public boolean updateSoLuong(UUID id, int SoLuong) {
        return ctSpRepo.updateSoLuong(id, SoLuong);
    }

    @Override
    public ChiTietSanPham findById(UUID id) {
        return ctSpRepo.findById(id);
    }

    @Override
    public boolean updateTrangThai(UUID id, int trangThai) {
        return ctSpRepo.updateTrangThai(id, trangThai);
    }

    @Override
    public ChiTietSanPham findByBarCode(String barCode) {
        return ctSpRepo.findByBarCode(barCode);
    }

}

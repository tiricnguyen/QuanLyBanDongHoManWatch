package service.impl;

import domainModel.ChiTietSanPham;
import java.awt.TextField;
import java.util.List;
import javax.swing.JOptionPane;
import repository.impl.ChiTietSanPhamRepository;
import service.ChiTietSanPhamService;
import viewModel.ChiTietSanPhamResponse;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    ChiTietSanPhamRepository ctspRepo = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPhamResponse> getAllResponse() {
        return ctspRepo.getAllResponse();
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        return ctspRepo.getAll();
    }

    @Override
    public String insert(ChiTietSanPham chiTietSanPham) {
        ctspRepo.saveOrUpdate(chiTietSanPham);
        if (chiTietSanPham != null) {
            return "Thêm Thành Công !!";
        } else {
            return "Thêm Thât Bai !!";
        }
    }

    @Override
    public String update(ChiTietSanPham chiTietSanPham) {
        ChiTietSanPham chiTietSPFind = ctspRepo.findById(chiTietSanPham.getId());
        chiTietSPFind.setChatLieuDay(chiTietSanPham.getChatLieuDay());
        chiTietSPFind.setChatLieuMatKinh(chiTietSanPham.getChatLieuMatKinh());
        chiTietSPFind.setChatLieuVo(chiTietSanPham.getChatLieuVo());
        chiTietSPFind.setHangDongHo(chiTietSanPham.getHangDongHo());
        chiTietSPFind.setLoaiDongHo(chiTietSanPham.getLoaiDongHo());
        chiTietSPFind.setMatDongHo(chiTietSanPham.getMatDongHo());
        chiTietSPFind.setNangLuongSD(chiTietSanPham.getNangLuongSD());
        chiTietSPFind.setSanPham(chiTietSanPham.getSanPham());
        chiTietSPFind.setChongNuoc(chiTietSanPham.getChongNuoc());
        chiTietSPFind.setSizeDay(chiTietSanPham.getSizeDay());
        chiTietSPFind.setSoLuong(chiTietSanPham.getSoLuong());
        chiTietSPFind.setGiaBan(chiTietSanPham.getGiaBan());
        chiTietSPFind.setGiaNhap(chiTietSanPham.getGiaNhap());
        chiTietSPFind.setMoTa(chiTietSanPham.getMoTa());
        chiTietSPFind.setXuatXu(chiTietSanPham.getXuatXu());
        chiTietSPFind.setHinhAnh(chiTietSanPham.getHinhAnh());
        chiTietSPFind.setTrangThai(chiTietSanPham.getTrangThai());

        chiTietSanPham = ctspRepo.saveOrUpdate(chiTietSPFind);

        if (chiTietSanPham != null) {
            return "Sửa thành công";
        } else {
            return "Lỗi. Sửa thất bại";
        }
    }

    public boolean ckRong(TextField txt, String mss) {
        if (txt.getText().equals("")) {
            JOptionPane.showMessageDialog(txt, mss);
            txt.requestFocus();
            return true;
        }
        return false;
    }
}

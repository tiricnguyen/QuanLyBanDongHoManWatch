package service.impl;

import domainModel.ChatLieuDay;
import domainModel.ChiTietSanPham;
import domainModel.LoaiDongHo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.impl.ChiTietSanPhamRepository;
import repository.impl.LoaiDongHoRepository;
import service.ChiTietSanPhamService;
import viewModel.ChiTietSanPhamResponse;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    ChiTietSanPhamRepository ctspRepo = new ChiTietSanPhamRepository();

    LoaiDongHoRepository ldh = new LoaiDongHoRepository();

    @Override
    public List<ChiTietSanPhamResponse> getAllResponse() {
        return ctspRepo.getAllResponse();
    }

    @Override
    public LoaiDongHo findIdCbx(String cbx) {
        LoaiDongHo loaidonho = ldh.findByMa(cbx);
        return loaidonho;
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

        if (chiTietSanPham != null) {
            return "Sửa thành công";
        } else {
            return "Lỗi. Sửa thất bại";
        }
    }

}

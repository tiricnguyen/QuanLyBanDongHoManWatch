package service.impl;

import domainModel.ChiTietSanPham;
import java.util.List;
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

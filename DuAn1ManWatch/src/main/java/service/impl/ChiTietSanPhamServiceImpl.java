package service.impl;

import domainModel.ChiTietSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import repository.impl.ChiTietSanPhamRepository;
import service.ChiTietSanPhamService;
import viewModel.ChiTietSanPhamResponse;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    ChiTietSanPhamRepository ctspRepo = new ChiTietSanPhamRepository();

    @Override
    public List<ChiTietSanPhamResponse> getAllResponse() {
        return ctspRepo.getAllResponse();
    }

    public static void main(String[] args) {
        List<ChiTietSanPhamResponse> list = new ArrayList<>();
        list = new ChiTietSanPhamServiceImpl().getAllResponse();
        for (ChiTietSanPhamResponse x : list) {
            System.out.println(x.getId());
        }

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

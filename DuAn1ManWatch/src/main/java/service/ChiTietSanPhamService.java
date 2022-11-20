package service;

import domainModel.ChiTietSanPham;
import domainModel.LoaiDongHo;
import java.util.List;
import java.util.UUID;
import viewModel.ChiTietSanPhamResponse;

public interface ChiTietSanPhamService {

    List<ChiTietSanPhamResponse> getAllResponse();

    String insert(ChiTietSanPham chiTietSanPham);

    String update(ChiTietSanPham chiTietSanPham);

}

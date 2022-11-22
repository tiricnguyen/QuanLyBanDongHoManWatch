
package repository.impl;



import repository.CrudRepository;
import domainModel.ChiTietSanPham;
import java.util.UUID;
import viewModel.ChiTietSanPhamResponse;


public class ChiTietSanPhamRepository extends CrudRepository<UUID, ChiTietSanPham, ChiTietSanPhamResponse>{

    public ChiTietSanPhamRepository() {
        className = ChiTietSanPham.class.getName();
        res = "new viewModel.ChiTietSanPhamResponse(a.id , a.sanPham.ten, a.hangDongHo.ten , a.loaiDongHo.ten , "
                + "a.chongNuoc , a.sizeDay ,a.soLuong ,a.giaNhap , a.giaBan ,a.moTa ,a.hinhAnh ,a.xuatXu ,a.trangThai )";
    }
        
    
}

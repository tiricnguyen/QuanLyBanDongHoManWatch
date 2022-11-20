/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.ChiTietSanPham;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.ChiTietSanPhamResponse;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamRepository extends CrudRepository<UUID, ChiTietSanPham, ChiTietSanPhamResponse> {

    public ChiTietSanPhamRepository() {
        
        className = ChiTietSanPham.class.getName();
        res = "new viewModel.ChiTietSanPhamResponse(a.id , a.hangDongHo.ten, a.loaiDongHo.ten, a.sanPham.ten ,a.chongNuoc , a.sizeDay ,a.soLuong , a.giaBan ,a.moTa,a.xuatXu)";

    }

}

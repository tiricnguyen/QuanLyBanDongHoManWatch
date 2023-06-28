/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.ChiTietSanPham;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import repository.impl.ChiTietSanPhamRepository;
import viewModel.ChiTietSanPhamResponse;

/**
 *
 * @author Admin
 */
public interface ChiTietSanPhamService {

    List<ChiTietSanPhamResponse> getAllChiTietSanPham(int tt);

    List<ChiTietSanPham> getAll(int trangThai);

    ChiTietSanPham insert(ChiTietSanPham ctsp);

    ChiTietSanPham findById(UUID id);

    String update(ChiTietSanPham ctsp);

    ChiTietSanPham findByBarCode(String barCode);

    List<ChiTietSanPhamResponse> search(String ten, int tt);

    boolean updateSoLuong(UUID id, int SoLuong);

    boolean updateTrangThai(UUID id, int trangThai);

}

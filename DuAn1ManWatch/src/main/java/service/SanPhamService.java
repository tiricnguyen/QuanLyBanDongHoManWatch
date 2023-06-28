/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.SanPham;
import java.util.List;
import java.util.UUID;
import viewModel.SanPhamResponse;

/**
 *
 * @author Admin
 */
public interface SanPhamService {

    List<SanPhamResponse> getAllRespone();

    List<SanPham> getAll();

    String insert(SanPham sp);

    String update(SanPham sp);

    List<SanPhamResponse> getAllByTrangThai(int tt);

    SanPham findById(UUID id);

    String printExcel();

    List<SanPhamResponse> getAllByTenOrTrangThai(String Ten, int tt);
    
    SanPham findIdCbx(String ten);
}

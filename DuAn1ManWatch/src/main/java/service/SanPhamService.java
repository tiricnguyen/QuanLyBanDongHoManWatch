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
import viewModel.SanPhamResponse;

/**
 *
 * @author Admin
 */
public interface SanPhamService {

    List<SanPhamResponse> getAllRespone();

    List<SanPham> getAll();
}

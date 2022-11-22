/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.KhachHang;
import java.util.List;
import java.util.UUID;
import viewModel.KhachHangResponse;

/**
 *
 * @author Admin
 */
public interface KhachHangService {

    List<KhachHangResponse> getAllResponse();

    List<KhachHang> getAll();

    List<KhachHangResponse> getAllByTrangThai(int trangThai);

    List<KhachHangResponse> getAllByTenOrTrangThai(String ten, int trangThai);

    String insert(KhachHang kh);

    String update(KhachHang kh);
    
}

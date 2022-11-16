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

    String insert(KhachHang kh);

    String update(KhachHang kh);

    String delete(UUID id);

}

/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.NhanVien;
import java.util.List;
import viewModel.NhanVienResponse;

/**
 *
 * @author Admin
 */
public interface NhanVienService {

    List<NhanVienResponse> getAllResponse();

    String insert(NhanVien kh);

    String update(NhanVien kh);

}

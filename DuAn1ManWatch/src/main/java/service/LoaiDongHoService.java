/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.LoaiDongHo;
import java.util.List;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public interface LoaiDongHoService {

    List<LoaiDongHoResponse> getAllRespone();

    List<LoaiDongHo> getAll();
}

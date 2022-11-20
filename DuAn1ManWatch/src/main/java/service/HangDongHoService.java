/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.HangDongHo;
import java.util.List;
import viewModel.HangDongHoResponse;

/**
 *
 * @author Admin
 */
public interface HangDongHoService {

    List<HangDongHoResponse> getAllRespone();

    List<HangDongHo> getAll();
}

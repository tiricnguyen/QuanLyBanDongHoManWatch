/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.MatDongHo;
import java.util.List;
import viewModel.MatDongHoResponse;

/**
 *
 * @author Admin
 */
public interface MatDongHoService {

    List<MatDongHoResponse> getAllRespone();

    List<MatDongHo> getAll();
}

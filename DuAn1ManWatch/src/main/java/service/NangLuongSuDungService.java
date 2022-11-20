/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.NangLuongSuDung;
import java.util.List;
import viewModel.NangLuongSuDungResponse;

/**
 *
 * @author Admin
 */
public interface NangLuongSuDungService {

    List<NangLuongSuDungResponse> getAllRespone();

    List<NangLuongSuDung> getAll();
}

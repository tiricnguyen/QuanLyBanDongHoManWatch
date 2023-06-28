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
import java.util.UUID;
import viewModel.NangLuongSuDungResponse;

/**
 *
 * @author Admin
 */
public interface NangLuongSuDungService {

    List<NangLuongSuDungResponse> getAllRespone();

    List<NangLuongSuDung> getAll();

    String insert(NangLuongSuDung nlsd);

    String update(NangLuongSuDung nlsd);

    List<NangLuongSuDungResponse> getAllByTrangThai(int tt);

    NangLuongSuDung findById(UUID id);

    String printExcel();

    List<NangLuongSuDungResponse> getAllByTenOrTrangThai(String Ten, int tt);

    NangLuongSuDung findIdCbx(String ten);
}

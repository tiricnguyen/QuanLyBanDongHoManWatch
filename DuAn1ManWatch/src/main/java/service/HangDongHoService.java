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
import java.util.UUID;
import viewModel.HangDongHoResponse;

/**
 *
 * @author Admin
 */
public interface HangDongHoService {

    List<HangDongHoResponse> getAllRespone();

    List<HangDongHo> getAll();

    String insert(HangDongHo hdh);

    String update(HangDongHo hdh);

    List<HangDongHoResponse> getAllByTrangThai(int tt);

    HangDongHo findById(UUID id);

    String printExcel();

    List<HangDongHoResponse> getAllByTenOrTrangThai(String Ten, int tt);

    HangDongHo findIdCbx(String ten);
}

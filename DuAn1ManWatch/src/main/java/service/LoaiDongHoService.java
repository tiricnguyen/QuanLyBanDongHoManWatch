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
import java.util.UUID;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public interface LoaiDongHoService {

    List<LoaiDongHoResponse> getAllRespone();

    List<LoaiDongHo> getAll();

    String insert(LoaiDongHo ldh);

    String update(LoaiDongHo ldh);

    List<LoaiDongHoResponse> getAllByTrangThai(int tt);

    LoaiDongHo findById(UUID id);

    String printExcel();

    List<LoaiDongHoResponse> getAllByTenOrTrangThai(String Ten, int tt);

    LoaiDongHo findIdCbx(String ten);
}

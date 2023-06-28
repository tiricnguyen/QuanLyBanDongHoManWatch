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
import java.util.UUID;
import viewModel.MatDongHoResponse;

/**
 *
 * @author Admin
 */
public interface MatDongHoService {

    List<MatDongHoResponse> getAllRespone();

    List<MatDongHo> getAll();

    MatDongHo findIdCbx(String ten);
    
     String insert(MatDongHo mdh);

    String update(MatDongHo mdh);

    List<MatDongHoResponse> getAllByTrangThai(int tt);

    MatDongHo findById(UUID id);

    String printExcel();

    List<MatDongHoResponse> getAllByKieuMat(String kieuMat, int tt);
}

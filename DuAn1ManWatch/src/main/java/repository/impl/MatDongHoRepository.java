/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.MatDongHo;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.MatDongHoResponse;

/**
 *
 * @author Admin
 */
public class MatDongHoRepository extends CrudRepository<UUID, MatDongHo, MatDongHoResponse> {

    public MatDongHoRepository() {

        className = MatDongHo.class.getName();
        res = "new viewModel.MatDongHoResponse(a.id, a.ma , a.mauSac, a.hinhDangMat , a.kieuMat, a.kichThuocMat)";
        ten = "hinhDangMat";
        
    }

}

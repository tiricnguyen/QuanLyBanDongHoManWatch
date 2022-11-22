/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.LoaiDongHo;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public class LoaiDongHoRepository extends CrudRepository<UUID, LoaiDongHo, LoaiDongHoResponse> {

    public LoaiDongHoRepository() {

        className = LoaiDongHo.class.getName();

        res = "new viewModel.LoaiDongHoResponse(a.id, a.ma , a.ten)";
        ten = "ten";
    }

}

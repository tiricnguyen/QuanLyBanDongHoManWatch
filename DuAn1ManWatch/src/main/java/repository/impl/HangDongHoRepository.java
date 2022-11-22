/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.HangDongHo;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.HangDongHoResponse;

/**
 *
 * @author Admin
 */
public class HangDongHoRepository extends CrudRepository<UUID, HangDongHo, HangDongHoResponse> {

    public HangDongHoRepository() {

        className = HangDongHo.class.getName();
        res = "new viewModel.HangDongHoResponse(a.id, a.ma , a.ten)";
        ten = "ten";
    }

}

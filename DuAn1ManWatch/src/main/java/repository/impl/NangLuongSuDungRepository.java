/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.NangLuongSuDung;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.NangLuongSuDungResponse;

/**
 *
 * @author Admin
 */
public class NangLuongSuDungRepository extends CrudRepository<UUID, NangLuongSuDung, NangLuongSuDungResponse> {

    public NangLuongSuDungRepository() {

        className = NangLuongSuDung.class.getName();
        res = "new viewModel.NangLuongSuDungResponse(a.id, a.ma , a.ten)";
        ten = "ten";
    }

}

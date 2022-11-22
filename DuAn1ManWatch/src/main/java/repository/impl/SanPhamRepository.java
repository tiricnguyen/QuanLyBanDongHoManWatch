/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.SanPham;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.SanPhamResponse;

/**
 *
 * @author Admin
 */
public class SanPhamRepository extends CrudRepository<UUID, SanPham, SanPhamResponse> {

    public SanPhamRepository() {

        className = SanPham.class.getName();
        res = "new viewModel.SanPhamResponse(a.id, a.ma , a.ten)";
        ten = "ten";
    }

}

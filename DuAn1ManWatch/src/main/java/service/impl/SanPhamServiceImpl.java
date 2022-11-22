/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.SanPham;
import java.util.List;
import repository.impl.SanPhamRepository;
import service.SanPhamService;
import viewModel.SanPhamResponse;

/**
 *
 * @author Admin
 */
public class SanPhamServiceImpl implements SanPhamService {

    SanPhamRepository spRepo = new SanPhamRepository();

    @Override
    public List<SanPhamResponse> getAllRespone() {
        return spRepo.getAllResponse();
    }

    @Override
    public List<SanPham> getAll() {
        return spRepo.getAll();
    }
}

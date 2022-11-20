/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuDay;
import domainModel.SanPham;
import java.util.List;
import repository.impl.ChatLieuDayRepository;
import repository.impl.SanPhamRepository;
import service.ChatLieuDayService;
import service.SanPhamService;
import viewModel.ChatLieuDayRepsonse;
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

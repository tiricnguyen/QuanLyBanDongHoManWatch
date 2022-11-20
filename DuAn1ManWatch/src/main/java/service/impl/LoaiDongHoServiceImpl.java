/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.LoaiDongHo;
import java.util.ArrayList;
import java.util.List;
import repository.impl.LoaiDongHoRepository;
import service.LoaiDongHoService;
import viewModel.LoaiDongHoResponse;

/**
 *
 * @author Admin
 */
public class LoaiDongHoServiceImpl implements LoaiDongHoService {

    LoaiDongHoRepository ldhRepo = new LoaiDongHoRepository();

    @Override
    public List<LoaiDongHoResponse> getAllRespone() {
        return ldhRepo.getAllResponse();
    }

    @Override
    public List<LoaiDongHo> getAll() {
        return ldhRepo.getAll();
    }
}

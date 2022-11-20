/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.HangDongHo;
import java.util.List;
import repository.impl.HangDongHoRepository;
import service.HangDongHoService;
import viewModel.HangDongHoResponse;

/**
 *
 * @author Admin
 */
public class HangDongHoServiceImpl implements HangDongHoService {

    HangDongHoRepository hdhRepo = new HangDongHoRepository();

    @Override
    public List<HangDongHoResponse> getAllRespone() {
        return hdhRepo.getAllResponse();
    }

    @Override
    public List<HangDongHo> getAll() {
        return hdhRepo.getAll();
    }
}

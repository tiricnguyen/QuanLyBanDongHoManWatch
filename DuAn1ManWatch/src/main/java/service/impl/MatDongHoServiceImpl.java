/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuDay;
import domainModel.MatDongHo;
import java.util.List;
import repository.impl.ChatLieuDayRepository;
import repository.impl.MatDongHoRepository;
import service.ChatLieuDayService;
import service.MatDongHoService;
import viewModel.ChatLieuDayRepsonse;
import viewModel.MatDongHoResponse;

/**
 *
 * @author Admin
 */
public class MatDongHoServiceImpl implements MatDongHoService {

    MatDongHoRepository mdhRepo = new MatDongHoRepository();

    @Override
    public List<MatDongHoResponse> getAllRespone() {
        return mdhRepo.getAllResponse();
    }

    @Override
    public List<MatDongHo> getAll() {
        return mdhRepo.getAll();
    }
}

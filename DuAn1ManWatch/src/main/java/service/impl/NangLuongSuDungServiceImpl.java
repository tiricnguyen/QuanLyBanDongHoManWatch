/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.NangLuongSuDung;
import java.util.List;
import repository.impl.NangLuongSuDungRepository;
import service.NangLuongSuDungService;
import viewModel.NangLuongSuDungResponse;

/**
 *
 * @author Admin
 */
public class NangLuongSuDungServiceImpl implements NangLuongSuDungService {

    NangLuongSuDungRepository nlsdRepo = new NangLuongSuDungRepository();

    @Override
    public List<NangLuongSuDungResponse> getAllRespone() {
        return nlsdRepo.getAllResponse();
    }

    @Override
    public List<NangLuongSuDung> getAll() {
        return nlsdRepo.getAll();
    }
}

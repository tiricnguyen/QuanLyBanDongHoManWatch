/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuDay;
import java.util.List;
import repository.impl.ChatLieuDayRepository;
import service.ChatLieuDayService;
import viewModel.ChatLieuDayRepsonse;

/**
 *
 * @author Admin
 */
public class ChatLieuDayServiceImpl implements ChatLieuDayService {

    ChatLieuDayRepository cldRepo = new ChatLieuDayRepository();

    @Override
    public List<ChatLieuDayRepsonse> getAllRespone() {
        return cldRepo.getAllResponse();
    }

    @Override
    public List<ChatLieuDay> getAll() {
        return cldRepo.getAll();
    }
}

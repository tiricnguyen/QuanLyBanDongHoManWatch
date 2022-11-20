/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuMatKinh;
import java.util.List;
import repository.impl.ChatLieuMatKinhRepository;
import service.ChatLieuMatKinhService;
import viewModel.ChatLieuMatKinhResponse;

/**
 *
 * @author Admin
 */
public class ChatLieuMatKinhServiceImpl implements ChatLieuMatKinhService {

    ChatLieuMatKinhRepository clmkRepo = new ChatLieuMatKinhRepository();

    @Override
    public List<ChatLieuMatKinhResponse> getAllRespone() {
        return clmkRepo.getAllResponse();
    }

    @Override
    public List<ChatLieuMatKinh> getAll() {
        return clmkRepo.getAll();
    }
}

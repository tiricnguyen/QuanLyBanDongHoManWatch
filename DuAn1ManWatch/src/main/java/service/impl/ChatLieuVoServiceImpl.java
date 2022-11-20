/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.ChatLieuVo;
import java.util.List;
import repository.impl.ChatLieuVoRepository;
import service.ChatLieuVoService;
import viewModel.ChatLieuVoResponse;

/**
 *
 * @author Admin
 */
public class ChatLieuVoServiceImpl implements ChatLieuVoService {

    ChatLieuVoRepository clvRepo = new ChatLieuVoRepository();

    @Override
    public List<ChatLieuVoResponse> getAllRespone() {
        return clvRepo.getAllResponse();
    }

    @Override
    public List<ChatLieuVo> getAll() {
        return clvRepo.getAll();
    }
}

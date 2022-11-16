
package service.impl;

import domainModel.ChatLieuVo;
import java.util.List;
import repository.impl.ChatLieuVoRepository;
import service.ChatLieuVoService;

public class ChatLieuVoServiceImpl implements ChatLieuVoService{

    private ChatLieuVoRepository chatLieuVoRepository;

    public ChatLieuVoServiceImpl() {
        chatLieuVoRepository = new ChatLieuVoRepository();
    }
    
    
    @Override
    public List<ChatLieuVo> getAll() {
        return chatLieuVoRepository.getAll();
    }
    
}


package repository.impl;


import repository.CrudRepository;
import domainModel.ChatLieuVo;
import java.util.UUID;
import viewModel.ChatLieuVoResponse;


public class ChatLieuVoRepository extends CrudRepository<UUID, ChatLieuVo, ChatLieuVoResponse>{

    public ChatLieuVoRepository() {
        className = ChatLieuVo.class.getName();

    }
    
    
    
}

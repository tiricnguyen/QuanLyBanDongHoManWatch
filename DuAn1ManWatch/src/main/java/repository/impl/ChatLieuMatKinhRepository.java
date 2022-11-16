
package repository.impl;

import repository.CrudRepository;
import domainModel.ChatLieuMatKinh;
import java.util.UUID;
import viewModel.ChatLieuMatKinhResponse;

public class ChatLieuMatKinhRepository extends CrudRepository<UUID, ChatLieuMatKinh, ChatLieuMatKinhResponse>{
    
    public ChatLieuMatKinhRepository() {
        className = ChatLieuMatKinh.class.getName();

    }
    
    
    
}

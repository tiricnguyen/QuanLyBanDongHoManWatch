
package repository.impl;


import repository.CrudRepository;
import domainModel.ChatLieuDay;
import java.util.UUID;
import viewModel.ChatLieuDayRepsonse;


public class ChatLieuDayRepository extends CrudRepository<UUID, ChatLieuDay, ChatLieuDayRepsonse>{
    
    public ChatLieuDayRepository() {
        className = ChatLieuDay.class.getName();
    }
    
    
}

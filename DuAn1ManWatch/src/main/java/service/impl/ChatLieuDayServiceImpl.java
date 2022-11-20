
package service.impl;

import domainModel.ChatLieuDay;
import java.util.List;
import repository.impl.ChatLieuDayRepository;
import service.ChatLieuDayService;

public class ChatLieuDayServiceImpl implements ChatLieuDayService{

    private ChatLieuDayRepository chatLieuDayRepository ;

    public ChatLieuDayServiceImpl() {
        chatLieuDayRepository = new ChatLieuDayRepository();
    }
    
    
    @Override
    public List<ChatLieuDay> getAll() {
        return chatLieuDayRepository.getAll();
    }


    @Override
    public ChatLieuDay findIdCbx(String ten) {
        return chatLieuDayRepository.findIdCbx(ten);
    }
    
}

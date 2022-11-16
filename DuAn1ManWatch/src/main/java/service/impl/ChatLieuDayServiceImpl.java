
package service.impl;

import domainModel.ChatLieuDay;
import java.util.List;
import repository.impl.ChatLieuDayRepository;
import service.ChatLieuDayService;

public class ChatLieuDayServiceImpl implements ChatLieuDayService{

    private ChatLieuDayRepository chatLieuDayService ;

    public ChatLieuDayServiceImpl() {
        chatLieuDayService = new ChatLieuDayRepository();
    }
    
    
    @Override
    public List<ChatLieuDay> getAll() {
        return chatLieuDayService.getAll();
    }
    
    public static void main(String[] args) {
        ChatLieuDayRepository chatLieuDayService = new ChatLieuDayRepository();
        
        for (ChatLieuDay x : chatLieuDayService.getAll()) {
            System.out.println(x.toString());
        }
    }
    
}

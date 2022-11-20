package service.impl;


import domainModel.ChatLieuMatKinh;
import java.util.List;
import repository.impl.ChatLieuMatKinhRepository;

import service.ChatLieuMatKinhService;

public class ChatLieuMatKinhServiceImpl implements ChatLieuMatKinhService {

    private ChatLieuMatKinhRepository chatLieuMatKinhRepository;

    public ChatLieuMatKinhServiceImpl() {
        chatLieuMatKinhRepository = new ChatLieuMatKinhRepository();
    }

    @Override
    public List<ChatLieuMatKinh> getAll() {
        return chatLieuMatKinhRepository.getAll();
    }


    @Override
    public ChatLieuMatKinh findIdCbx(String ten) {
        return chatLieuMatKinhRepository.findIdCbx(ten);
    }
}

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

    public static void main(String[] args) {
        ChatLieuMatKinhRepository chatLieuMatKinhRepository = new ChatLieuMatKinhRepository();
        for (ChatLieuMatKinh x : chatLieuMatKinhRepository.getAll()) {
            System.out.println(x.toString());
        }
    }
}

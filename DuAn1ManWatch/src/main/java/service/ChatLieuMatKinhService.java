
package service;


import domainModel.ChatLieuMatKinh;
import java.util.List;

public interface ChatLieuMatKinhService {
    
    List<ChatLieuMatKinh> getAll();
    
    ChatLieuMatKinh findIdCbx(String ten);
}

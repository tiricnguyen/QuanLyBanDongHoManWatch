/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.ChatLieuMatKinh;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.ChatLieuMatKinhResponse;

/**
 *
 * @author Admin
 */
public class ChatLieuMatKinhRepository extends CrudRepository<UUID, ChatLieuMatKinh, ChatLieuMatKinhResponse> {

    public ChatLieuMatKinhRepository() {

        className = ChatLieuMatKinh.class.getName();
        res = "new viewModel.ChatLieuMatKinhResponse(a.id, a.ma , a.ten, a.sizeMatKinh , a.doDay)";
        ten = "ten";
        
    }

}

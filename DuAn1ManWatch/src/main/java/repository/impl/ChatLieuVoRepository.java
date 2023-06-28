/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.ChatLieuVo;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.ChatLieuVoResponse;

/**
 *
 * @author Admin
 */
public class ChatLieuVoRepository extends CrudRepository<UUID, ChatLieuVo, ChatLieuVoResponse> {

    public ChatLieuVoRepository() {

        className = ChatLieuVo.class.getName();
        res = "new viewModel.ChatLieuVoResponse(a.id, a.ma , a.ten, a.mauSac , a.moTa , a.trangThai)";
        ten = "ten";
        
    }

}

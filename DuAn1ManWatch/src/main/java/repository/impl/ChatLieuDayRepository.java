/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.ChatLieuDay;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.ChatLieuDayRepsonse;

/**
 *
 * @author Admin
 */
public class ChatLieuDayRepository extends CrudRepository<UUID, ChatLieuDay, ChatLieuDayRepsonse> {

    public ChatLieuDayRepository() {

        className = ChatLieuDay.class.getName();
        res = "new viewModel.ChatLieuDayRepsonse(a.id, a.ma , a.ten)";
        ten = "ten";
    }

}

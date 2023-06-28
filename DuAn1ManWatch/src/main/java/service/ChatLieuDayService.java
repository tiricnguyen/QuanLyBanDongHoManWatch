/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.ChatLieuDay;
import java.util.List;
import java.util.UUID;
import viewModel.ChatLieuDayRepsonse;

/**
 *
 * @author Admin
 */
public interface ChatLieuDayService {

    List<ChatLieuDayRepsonse> getAllRespone();

    List<ChatLieuDay> getAll();
    
    ChatLieuDay findIdCbx(String ten);
    
    String insert(ChatLieuDay cld);

    String update(ChatLieuDay cld);

    List<ChatLieuDayRepsonse> getAllByTrangThai(int tt);

    ChatLieuDay findById(UUID id);

    String printExcel();

    List<ChatLieuDayRepsonse> getAllByTenOrTrangThai(String Ten, int tt);
}

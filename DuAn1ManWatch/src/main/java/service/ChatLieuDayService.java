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
import viewModel.ChatLieuDayRepsonse;

/**
 *
 * @author Admin
 */
public interface ChatLieuDayService {

    List<ChatLieuDayRepsonse> getAllRespone();

    List<ChatLieuDay> getAll();
}

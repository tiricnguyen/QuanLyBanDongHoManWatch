/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.ChatLieuMatKinh;
import java.util.List;
import viewModel.ChatLieuMatKinhResponse;

/**
 *
 * @author Admin
 */
public interface ChatLieuMatKinhService {

    List<ChatLieuMatKinhResponse> getAllRespone();

    List<ChatLieuMatKinh> getAll();
}

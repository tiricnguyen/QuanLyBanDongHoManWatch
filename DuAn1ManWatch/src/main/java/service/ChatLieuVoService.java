/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.ChatLieuVo;
import java.util.List;
import viewModel.ChatLieuVoResponse;

/**
 *
 * @author Admin
 */
public interface ChatLieuVoService {

    List<ChatLieuVoResponse> getAllRespone();

    List<ChatLieuVo> getAll();
}

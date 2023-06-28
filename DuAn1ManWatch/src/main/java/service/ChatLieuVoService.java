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
import java.util.UUID;
import viewModel.ChatLieuVoResponse;

/**
 *
 * @author Admin
 */
public interface ChatLieuVoService {

    List<ChatLieuVoResponse> getAllRespone();

    List<ChatLieuVo> getAll();

    ChatLieuVo findIdCbx(String ten);

    String insert(ChatLieuVo clv);

    String update(ChatLieuVo clv);

    List<ChatLieuVoResponse> getAllByTrangThai(int tt);

    ChatLieuVo findById(UUID id);

    String printExcel();

    List<ChatLieuVoResponse> getAllByTenOrTrangThai(String Ten, int tt);
}

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
import java.util.UUID;
import viewModel.ChatLieuMatKinhResponse;

/**
 *
 * @author Admin
 */
public interface ChatLieuMatKinhService {

    List<ChatLieuMatKinhResponse> getAllRespone();

    List<ChatLieuMatKinh> getAll();

    ChatLieuMatKinh findIdCbx(String ten);

    String insert(ChatLieuMatKinh clmk);

    String update(ChatLieuMatKinh clmk);

    List<ChatLieuMatKinhResponse> getAllByTrangThai(int tt);

    ChatLieuMatKinh findById(UUID id);

    String printExcel();

    List<ChatLieuMatKinhResponse> getAllByTenOrTrangThai(String Ten, int tt);
}

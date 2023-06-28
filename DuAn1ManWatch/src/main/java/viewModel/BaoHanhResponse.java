/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package viewModel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaoHanhResponse {

    private UUID id;
    private String nhanVien;
    private String khachHang;
    private String serialBanHang;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String loaiBaoHanh;
    private int trangThai;
}

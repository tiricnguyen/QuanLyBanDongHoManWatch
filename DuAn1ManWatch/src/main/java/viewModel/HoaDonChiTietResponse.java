/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package viewModel;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTietResponse {

    private UUID id;
    private UUID hoaDon;
    private UUID chiTietSP;
    private String maDongHo;
    private String tenDongHo;
    private int soLuong;
    private BigDecimal donGia;
    private int trangThai;
}

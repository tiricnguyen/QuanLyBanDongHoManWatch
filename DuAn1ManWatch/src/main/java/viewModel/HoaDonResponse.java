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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonResponse {

    private UUID id;
    private String nhanVien;
    private String khachHang;
    private String vouCher;
    private String ma;
    private String ngayTao;
    private String ngayThanhToan;
    private String ngayHen;
    private String ngayGiaoHang;
    private String ngayNhan;
    private int giamGia;
    private BigDecimal phiVanChuyen;
    private String tenNguoiNhan;
    private String sdt;
    private String diaChi;
    private String ghiChu;
    private int trangThai;

    public Object[] toDataRowHoaDonCho(int index) {
        return new Object[]{index, ma};
    }
   
}

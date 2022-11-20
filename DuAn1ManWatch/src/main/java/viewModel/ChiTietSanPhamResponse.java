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
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChiTietSanPhamResponse {

    private UUID id;

    private String tenDongHo;

    private String tenHang;

    private String tenLoai;

    private String chongNuoc;

    private Double sizeDay;

    private Integer soLuong;

    private BigDecimal giaNhap;

    private BigDecimal giaBan;

    private String moTa;

    private String hinhAnh;

    private String xuatXu;

    private Integer trangThai;

    public Object[] toDataRow(int index) {
        return new Object[]{index, tenDongHo, tenHang, tenLoai, chongNuoc,sizeDay, soLuong, giaBan, moTa};
    }
}

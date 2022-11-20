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

    private  String tenHang;

    private String tenLoai;

    private String tenDongHo;

    private String chongNuoc;

    private Double sizeDay;

    private Integer soLuong;

    private BigDecimal giaBan;

    private String moTa;

    private String xuatXu;
    
    public Object[] toDataRow(int index) {
        return new Object[]{index, tenDongHo, tenHang, tenLoai, chongNuoc, sizeDay, soLuong, giaBan, moTa, xuatXu};
    }
}

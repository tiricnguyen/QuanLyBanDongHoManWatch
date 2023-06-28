/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package viewModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GiaoCaResponse {

    private UUID id;

    private String ma;

    private Date thoiGianNhanCa;

    private Date thoiGianGiaoCa;

    private String nhanVienTrongCa;

    private String nhanVienCaTiepTheo;

    private BigDecimal tienMatDauCa;

    private BigDecimal tongTienMatCuoiCa;

    private BigDecimal tongTienMat;

    private BigDecimal tongTienChuyenKhoan;

    private BigDecimal tienPhatSinh;

    private String ghiChuPhatSinh;

    private BigDecimal tongTienTrongCa;

    private Date thoiGianReset;

    private Integer tongSoHoaDon;

    private BigDecimal tongTienMatRut;

    private Integer trangThai;

}

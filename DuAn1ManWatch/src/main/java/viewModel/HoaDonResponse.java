/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package viewModel;

import domainModel.KhachHang;
import domainModel.NhanVien;
import domainModel.VoucherSanPham;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonResponse {

    private UUID id;
    private String nhanVien;
    private String khachHang;
    private String voucher;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayHen;
    private Integer giamGia;
    private String tenNguoiNhan;
    private String sdt;
    private BigDecimal tienMat;
    private BigDecimal chuyenKhoan;
    private BigDecimal thanhTien;
    private String ghiChu;
    private Integer trangThai;

   

    public String getTrangThai(int trangThai) {
        if (trangThai == 0) {
            return "Chờ  Thanh Toán";
        } else if (trangThai == 1) {
            return "Đã Thanh Toán";
        }
        return "Đã Hủy";
    }

    public Object[] toDaTaRow() {
        return new Object[]{
            ma == null ? "" : ma,
            nhanVien == null ? "" : nhanVien,
            khachHang == null ? "" : khachHang,
            voucher == null ? "" : voucher,
            ngayTao == null ? "" : ngayTao,
            ngayThanhToan == null ? "" : ngayThanhToan,
            ngayHen == null ? "" : ngayHen,
            giamGia == null ? "" : giamGia,
            tenNguoiNhan == null ? "" : tenNguoiNhan,
            sdt == null ? "" : sdt,
            tienMat == null ? "" : tienMat,
            chuyenKhoan == null ? "" : chuyenKhoan,
            thanhTien == null ? "" : thanhTien,
            ghiChu == null ? "''" : ghiChu,
            getTrangThai(trangThai)
        };
    }
}

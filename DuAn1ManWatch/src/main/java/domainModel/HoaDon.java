/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package domainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Admin
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "HoaDon")
public class HoaDon implements Serializable{
     
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdVouCher")
    private Voucher voucher;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "NgayTao")
    private String ngayTao;
    
    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;
    
    @Column(name = "NgayHen")
    private String ngayHen;
    
    @Column(name = "NgayGiaoHang")
    private String ngayGiaoHang;
    
    @Column(name = "NgayNhan")
    private String ngayNhan;
    
    @Column(name = "GiamGia")
    private Integer giamGia;
    
    @Column(name = "PhiVanChuyen")
    private BigDecimal phiVanChuyen;
    
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    
    @Column(name = "SDT")
    private String sdt;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "GhiChu")
    private String ghiChu;
    
    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", voucher=" + voucher + ", ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", ngayHen=" + ngayHen + ", ngayGiaoHang=" + ngayGiaoHang + ", ngayNhan=" + ngayNhan + ", giamGia=" + giamGia + ", phiVanChuyen=" + phiVanChuyen + ", tenNguoiNhan=" + tenNguoiNhan + ", sdt=" + sdt + ", diaChi=" + diaChi + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + '}';
    }
    
    
}

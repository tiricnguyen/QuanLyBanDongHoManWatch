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
import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name = "GiaoCa")
public class GiaoCa implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "ThoiGianNhanCa")
    private Date thoiGianNhanCa;
    
    @Column(name = "ThoiGianGiaoCa")
    private Date thoiGianGiaoCa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVienTrongCa")
    private NhanVien nhanVienTrongCa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNhanVienCaTiepTheo")
    private NhanVien nhanVienCaTiepTheo;

    @Column(name = "TienMatDauCa")
    private BigDecimal tienMatDauCa;

    @Column(name = "TongTienMatCuoiCa")
    private BigDecimal tongTienMatCuoiCa;

    @Column(name = "TongTienMat")
    private BigDecimal tongTienMat;

    @Column(name = "TongTienChuyenKhoan")
    private BigDecimal tongTienChuyenKhoan;

    @Column(name = "TienPhatSinh")
    private BigDecimal tienPhatSinh;

    @Column(name = "GhiChuPhatSinh")
    private String ghiChuPhatSinh;

    @Column(name = "TongTienTrongCa")
    private BigDecimal tongTienTrongCa;
    
    @Column(name = "ThoiGianReset")
    private Date thoiGianReset;
    
    @Column(name = "TongSoHoaDon")
    private Integer tongSoHoaDon;
    
    @Column(name = "TongTienMatRut")
    private BigDecimal tongTienMatRut;

    @Column(name = "TrangThai")
    private Integer trangThai;

}

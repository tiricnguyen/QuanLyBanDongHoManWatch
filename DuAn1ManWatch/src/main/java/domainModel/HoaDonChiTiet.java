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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham chiTietSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", hoaDon=" + hoaDon + ", chiTietSP=" + chiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThai=" + trangThai + '}';
    }

}

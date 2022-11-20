/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package domainModel;

import java.io.Serializable;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SerialBanHang")
public class SerialBanHang implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHoaDonChiTiet")
    private HoaDonChiTiet hoaDonChiTiet;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "SerialBanHang{" + "id=" + id + ", hoaDonChiTiet=" + hoaDonChiTiet + ", ma=" + ma + ", trangThai=" + trangThai + '}';
    }
    
    
}

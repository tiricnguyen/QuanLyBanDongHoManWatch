package domainModel;

import domainModel.ChatLieuDay;
import domainModel.ChatLieuMatKinh;
import domainModel.ChatLieuVo;
import domainModel.HangDongHo;
import domainModel.LoaiDongHo;
import domainModel.MatDongHo;
import domainModel.NangLuongSuDung;
import domainModel.SanPham;
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ChiTietSanPham")

public class ChiTietSanPham implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdHangDongHo" )
    private HangDongHo hangDongHo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdLoaiDongHo" )
    private LoaiDongHo loaiDongHo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNangLuongSD" )
    private NangLuongSuDung nangLuongSD;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "IdSanPham" )
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMatDongHo")
    private MatDongHo matDongHo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChatLieuDay")
    private ChatLieuDay chatLieuDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChatLieuVo")
    private ChatLieuVo chatLieuVo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChatLieuMatKinh")
    private ChatLieuMatKinh chatLieuMatKinh;

    @Column(name = "ChongNuoc")
    private String chongNuoc;

    @Column(name = "SizeDay")              
    private Double sizeDay;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "XuatXu")
    private String xuatXu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "id=" + id + ", hangDongHo=" + hangDongHo + ", loaiDongHo=" + loaiDongHo + ", nangLuongSD=" + nangLuongSD + ", sanPham=" + sanPham + ", matDongHo=" + matDongHo + ", chatLieuDay=" + chatLieuDay + ", chatLieuVo=" + chatLieuVo + ", chatLieuMatKinh=" + chatLieuMatKinh + ", chongNuoc=" + chongNuoc + ", sizeDay=" + sizeDay + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", moTa=" + moTa + ", hinhAnh=" + hinhAnh + ", xuatXu=" + xuatXu + ", trangThai=" + trangThai + '}';
    }
    
    
}

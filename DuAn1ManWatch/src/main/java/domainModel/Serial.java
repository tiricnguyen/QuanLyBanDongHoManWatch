/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import domainModel.ChiTietSanPham;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author congh
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Serial implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdChiTietSanPham")
    private ChiTietSanPham chiTietSanPham;
    
    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "Serial{" + "id=" + id + ", ma=" + ma + ", chiTietSanPham=" + chiTietSanPham + ", trangThai=" + trangThai + '}';
    }

}

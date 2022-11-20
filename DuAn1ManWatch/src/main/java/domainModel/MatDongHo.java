/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "MatDongHo")
public class MatDongHo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "MauSac")
    private String mauSac;
    
    @Column(name = "HinhDangMat")
    private String hinhDangMat;

    @Column(name = "KieuMat")
    private String kieuMat;

    @Column(name = "KichThuocMat")
    private Float kichThuocMat;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Override
    public String toString() {
        return "MatDongHo{" + "id=" + id + ", ma=" + ma + ", hinhDangMat=" + hinhDangMat + ", kieuMat=" + kieuMat + ", kichThuocMat=" + kichThuocMat + ", trangThai=" + trangThai + '}';
    }

}

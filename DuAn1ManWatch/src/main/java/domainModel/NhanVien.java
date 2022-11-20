/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


/**
 *
 * @author congh
 */
@Entity 
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "NhanVien")
public class NhanVien implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private UUID id;
    
    @Column(name = "Ma")
    private String ma;
    
    @Column(name = "HoVaTen")
    private String hoVaTen;
    
    @Column(name = "GioiTinh")
    private int gioiTinh;
    
    @Column(name = "NgaySinh")
    private String ngaySinh;
    
    @Column(name = "Email")   
    private String email;
    
    @Column(name = "HinhAnh")
    private String hinhAnh;
    
    @Column(name = "ChucVu")
    private int chucVu;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "SDT")
    private String sdt;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @Column(name = "TrangThai")
    private int trangThai;

    
    
    
}

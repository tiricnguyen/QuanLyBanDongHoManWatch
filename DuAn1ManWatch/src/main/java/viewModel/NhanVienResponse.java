/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author congh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienResponse {

  private UUID id;
    private String ma;
    private String hoVaTen;
    private Integer gioiTinh;
    private String ngaySinh;
    private String email;
    private String hinhAnh;
    private Integer chucVu;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private Integer trangThai;
    

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, hoVaTen, gioiTinh == 1? "Nam":"Nữ", ngaySinh, chucVu == 1? "Trưởng Phòng":"Nhân Viên", diaChi, sdt};
    }

}

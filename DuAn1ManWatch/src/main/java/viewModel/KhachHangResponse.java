/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class KhachHangResponse {

    private UUID id;
    private String ma;
    private String hoVaTen;
    private String ngaySinh;
    private String sdt;
    private String diaChi;

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, hoVaTen, ngaySinh, sdt, diaChi};
    }
}

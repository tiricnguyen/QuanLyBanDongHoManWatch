/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

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
public class MatDongHoResponse {

    private UUID id;
    private String ma;
    private String mauSac;
    private String hinhDangMat;
    private String ten;
    private Float kichThuocMat;
    private int trangThai;

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, mauSac, hinhDangMat, ten, kichThuocMat};
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.Date;
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
public class VoucherResponse {

    private UUID id;
    private String ma;
    private String ten;
    private Integer phamTram;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int trangThai;

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, ten, phamTram, ngayBatDau, ngayKetThuc};
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author congh
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatLieuMatKinhResponse {
    
    private UUID id;
    private String ma;
    private String ten;
    private String sizeMatKinh;
    private String doDay;
    private Integer trangThai;
    
    public Object[] toDataRow(int index){
        return new Object[]{index,ma,ten,sizeMatKinh,doDay,trangThai};
    }
}

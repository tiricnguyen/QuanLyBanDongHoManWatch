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
public class ChatLieuVoResponse {
    private UUID id;
    private String ma;
    private String ten;
    private String mauSac;
    private String moTa;
    
    
    public Object[] toDataRow(int index){
        return new Object[]{index,ma,ten,mauSac,moTa};
    }
}

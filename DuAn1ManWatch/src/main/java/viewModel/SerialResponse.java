/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package viewModel;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SerialResponse {

    private UUID id;
    private String ma;
    private int trangThai;
    private String chiTietSanPham;

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, trangThai, chiTietSanPham};
    }
}

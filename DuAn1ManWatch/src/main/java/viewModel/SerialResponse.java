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
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SerialResponse {

    private UUID id;
    private String ma;
    private int trangThai;
    private String chiTietSanPham;

    public Object[] toDataRow(int index) {
        return new Object[]{index, ma, trangThai, chiTietSanPham};
    }
}

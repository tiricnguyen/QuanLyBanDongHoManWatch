/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.NhanVien;
import java.util.UUID;
import repository.CrudRepository;
import viewModel.NhanVienResponse;

/**
 *
 * @author Admin
 */
public class NhanVienRepository extends CrudRepository<UUID, NhanVien, NhanVienResponse> {

    public NhanVienRepository() {

        className = NhanVien.class.getName();
        res = "new viewModel.NhanVienResponse(a.id, a.ma , a.hoVaTen, a.gioiTinh, a.ngaySinh, a.chucVu, a.diaChi,a.sdt)";
    
    }
}

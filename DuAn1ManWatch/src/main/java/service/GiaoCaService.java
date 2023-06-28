/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service;

import domainModel.GiaoCa;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import viewModel.GiaoCaResponse;

/**
 *
 * @author Admin
 */
public interface GiaoCaService {

    List<GiaoCaResponse> getAllVM();

    String insert(GiaoCa gc);

    String update(GiaoCa gc);

    GiaoCa findByMa(String ma);

    List<GiaoCa> findByIdNhanVien(UUID id);

    List<GiaoCa> getAll();

    GiaoCa findById(UUID id);

    GiaoCa giaoCaByThoiGian(Date thoiGianNhanCa, Date thoiGianGiaoCa);
}

/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.GiaoCa;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import repository.impl.GiaoCaRepository;
import service.GiaoCaService;
import viewModel.GiaoCaResponse;

/**
 *
 * @author Admin
 */
public class GiaoCaServiceImpl implements GiaoCaService {

    private GiaoCaRepository gcRepon = new GiaoCaRepository();

    @Override
    public List<GiaoCaResponse> getAllVM() {
        return gcRepon.getAllVM();
    }

    @Override
    public String insert(GiaoCa gc) {
        if (gcRepon.saveOrUpdate(gc) != null) {
            return "Giao Ca thành công";
        } else {
            return "Giao Ca thất bại";
        }
    }

    @Override
    public String update(GiaoCa gc) {
        if (gcRepon.findById(gc.getId()) == null) {
            return "ID không tồn tại";
        }

        if (gcRepon.saveOrUpdate(gc) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public GiaoCa findByMa(String ma) {
        return gcRepon.findByMa(ma);
    }

    @Override
    public GiaoCa findById(UUID id) {
        return gcRepon.findById(id);
    }

    @Override
    public List<GiaoCa> findByIdNhanVien(UUID id) {
        return gcRepon.findByIdNhanVien(id);
    }

    @Override
    public GiaoCa giaoCaByThoiGian(Date thoiGianNhanCa, Date thoiGianGiaoCa) {
        return gcRepon.giaoCaByThoiGian(thoiGianNhanCa, thoiGianGiaoCa);
    }

    @Override
    public List<GiaoCa> getAll() {
        return gcRepon.getAll();
    }

}

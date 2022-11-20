/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.NhanVien;
import java.util.List;
import repository.impl.NhanVienRepository;
import service.NhanVienService;
import viewModel.NhanVienResponse;

/**
 *
 * @author Admin
 */
public class NhanVienServiceImpl implements NhanVienService {

    NhanVienRepository nvRepo = new NhanVienRepository();

    @Override
    public List<NhanVienResponse> getAllResponse() {
        return nvRepo.getAllResponse();
    }

    @Override
    public String insert(NhanVien nv) {
//        if (nv.getMa().trim().isEmpty() || nv.getHoVaTen().trim().isEmpty()
//                || nv.getDiaChi().trim().isEmpty() || nv.getSdt().trim().isEmpty()
//                || nv.getNgaySinh().toString().isEmpty()) {
//            return "Không để trống";
//        }
//        try {
//            Long.parseLong(nv.getSdt());
//        } catch (Exception e) {
//            return "Nhập số điện thoai";
//        }
//        if (nv.getSdt().length() != 10) {
//            return "Số điện thoại phải 10";
//        }
//        if (!nv.getSdt().startsWith("0")) {
//            return "Số điện thoại bắt đầu bằng số 0";
//        }
//        NhanVien nvMa = nvRepo.findByMa(nv.getMa());
//        if (nvMa != null) {
//            return "Mã nvông được trùng";
//        }
        nv = nvRepo.saveOrUpdate(nv);
        if (nv != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(NhanVien nv) {
        return "";
//        NhanVien nvId = nvRepo.findById(nv.getId());
//        if (nvId == null) {
//            return "Id nvông tồn tại";
//        }
//        if (nv.getMa().trim().isEmpty() || nv.getHoVaTen().trim().isEmpty()
//                || nv.getDiaChi().trim().isEmpty() || nv.getSdt().trim().isEmpty()
//                || nv.getNgaySinh().toString().isEmpty()) {
//            return "Không để trống";
//        }
//
//        try {
//            Long.parseLong(nv.getSdt());
//        } catch (Exception e) {
//            return "Nhập số điện thoai";
//        }
//        if (nv.getSdt().length() != 10) {
//            return "Số điện thoại phải 10";
//        }
//        if (!nv.getSdt().startsWith("0")) {
//            return "Số điện thoại bắt đầu bằng số 0";
//        }
//
//        if (!nv.getMa().equals(nvId.getMa())) {
//            NhanVien nvMa = nvRepo.findByMa(nv.getMa());
//            if (nvMa != null) {
//                return "Mã nvông được trùng";
//            } else {
//                nvId.setMa(nv.getMa());
//            }
//        }
//
//        nvId.setHoVaTen(nv.getHoVaTen());
//        nvId.setDiaChi(nv.getDiaChi());
//        nvId.setSdt(nv.getSdt());
//        nvId.setNgaySinh(nv.getNgaySinh());
//        nvId.setTrangThai(nv.getTrangThai());
//
//        nv = nvRepo.saveOrUpdate(nvId);
//        if (nv != null) {
//            return "Sửa thành công";
//        } else {
//            return "Sửa thất bại";
//        }
//    }
//
//   
    }
}

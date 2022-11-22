/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package service.impl;

import domainModel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import repository.impl.KhachHangRepository;
import service.KhachHangService;
import viewModel.KhachHangResponse;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService {

    KhachHangRepository khRepo = new KhachHangRepository();

    @Override
    public List<KhachHangResponse> getAllResponse() {
        return khRepo.getAllResponse();
    }

    @Override
    public String insert(KhachHang kh) {
        if (kh.getMa().trim().isEmpty() || kh.getHoVaTen().trim().isEmpty()
                || kh.getDiaChi().trim().isEmpty() || kh.getSdt().trim().isEmpty()
                || kh.getNgaySinh().toString().isEmpty()) {
            return "Không để trống";
        }
        try {
            Long.parseLong(kh.getSdt());
        } catch (Exception e) {
            return "Nhập số điện thoai";
        }
        if (kh.getSdt().length() != 10) {
            return "Số điện thoại phải 10";
        }
        if (!kh.getSdt().startsWith("0")) {
            return "Số điện thoại bắt đầu bằng số 0";
        }
        KhachHang khMa = khRepo.findByMa(kh.getMa());
        if (khMa != null) {
            return "Mã không được trùng";
        }
        kh.setTrangThai(1);
        kh = khRepo.saveOrUpdate(kh);
        if (kh != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhachHang kh) {
        KhachHang khId = khRepo.findById(kh.getId());

        if (khId == null) {
            return "Id không tồn tại";
        }

        if (kh.getMa().trim().isEmpty() || kh.getHoVaTen().trim().isEmpty()
                || kh.getDiaChi().trim().isEmpty() || kh.getSdt().trim().isEmpty()
                || kh.getNgaySinh().trim().isEmpty()) {
            return "Không để trống";
        }

        try {
            Long.parseLong(kh.getSdt());
        } catch (Exception e) {
            return "Nhập số điện thoai";
        }
        if (kh.getSdt().length() != 10) {
            return "Số điện thoại phải 10";
        }
        if (!kh.getSdt().startsWith("0")) {
            return "Số điện thoại bắt đầu bằng số 0";
        }

        KhachHang khMa = khRepo.findByMa(kh.getMa());

        if (khMa != null && khMa.getMa().equals(kh.getMa())) {
            return "Mã không được trùng";
        }
        if (!kh.getMa().equals(khId.getId())) {
            KhachHang khByMa = khRepo.findByMa(kh.getMa());
            if (khByMa != null) {
                return "Mã Không Trùng";
            } else {
                khId.setMa(kh.getMa());
            }
        }

        khId.setMa(kh.getMa());
        khId.setHoVaTen(kh.getHoVaTen());
        khId.setDiaChi(kh.getDiaChi());
        khId.setSdt(kh.getSdt());
        khId.setNgaySinh(kh.getNgaySinh());
        khId.setTrangThai(kh.getTrangThai());
        kh = khRepo.saveOrUpdate(khId);
        if (kh != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public List<KhachHangResponse> getAllByTrangThai(int trangThai) {
        return khRepo.getAllByTrangThai(trangThai);
    }

    @Override
    public List<KhachHangResponse> getAllByTenOrTrangThai(String ten, int trangThai) {
        return khRepo.getAllByNameAndTrangThai(ten, trangThai);
    }

    @Override
    public List<KhachHang> getAll() {
        return khRepo.getAll();
    }

  

}

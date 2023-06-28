package service.impl;

import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;
import repository.impl.HoaDonRepository;
import service.HoaDonService;
import viewModel.HoaDonResponse;

public class HoaDonServiceIplm implements HoaDonService {

    HoaDonRepository hoaDonRes = new HoaDonRepository();

    @Override
    public List<HoaDonResponse> getAllByTrangThai(int i) {
        return hoaDonRes.getAllByTrangThai(i);
    }

    @Override
    public List<HoaDonResponse> getAllResponse() {
        return hoaDonRes.getAllVM();
    }

    public HoaDon insert(HoaDon hd) {
        HoaDon hdrt = hoaDonRes.save(hd);
        if (hdrt != null) {
            return hdrt;
        } else {
            return hdrt;
        }
    }

    public String update(HoaDon hd) {
        if (hoaDonRes.saveOrUpdate(hd) != null) {
            return " thành công";
        } else {
            return " thất bại";
        }
    }

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRes.getAll();
    }

    @Override
    public List<HoaDon> getAll(int tt) {
        return hoaDonRes.getAllHoaDon(tt);
    }

    @Override
    public List<HoaDonResponse> getHoaDonCho(UUID id, int trangThai) {
        return hoaDonRes.getAllCho(id, trangThai);
    }

    @Override
    public HoaDon findId(UUID id) {
        return hoaDonRes.findById(id);
    }

    @Override
    public List<HoaDonResponse> locTrangThai(int trangThai) {
        return hoaDonRes.locTrangThai(trangThai);
    }

    @Override
    public List<HoaDon> findByIdVoucher(UUID id) {
        return hoaDonRes.findByIdVoucher(id);
    }

}

package service.impl;

import domainModel.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import repository.impl.HoaDonChiTietRepository;
import service.HoaDonChiTietService;
import viewModel.HoaDonChiTietResponse;

public class HoaDonChiTietServiceIplm implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonRes = new HoaDonChiTietRepository();

    @Override
    public List<HoaDonChiTietResponse> getAllByTrangThai(int i) {
        return hoaDonRes.getAllByTrangThai(i);
    }

    @Override
    public List<HoaDonChiTietResponse> getAllReponse() {
        return hoaDonRes.getAllResponse();
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonRes.getAll();
    }

    @Override
    public String save(HoaDonChiTiet hdct) {
        if (hoaDonRes.save(hdct) != null) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(HoaDonChiTiet hdct) {
        if (hoaDonRes.saveOrUpdate(hdct) != null) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public HoaDonChiTiet findByMa(String ma) {
        return hoaDonRes.findByMa(ma);
    }

    @Override
    public HoaDonChiTiet findById(UUID id) {
        return hoaDonRes.findById(id);
    }

    @Override
    public List<HoaDonChiTietResponse> getAllByNameAndTrangThai(String name, int i) {
        return hoaDonRes.getAllByNameAndTrangThai(name, i);
    }

    @Override
    public List<HoaDonChiTietResponse> getGioHang(UUID idHoaDon) {

        return hoaDonRes.getGioHang(idHoaDon);

    }

    @Override
    public boolean updateSoLuong(UUID idSP, UUID idHD, int SoLuong) {
        return hoaDonRes.updateSoLuong(idSP, idHD, SoLuong);
    }

    @Override
    public Map<String, HoaDonChiTietResponse> convertHdct(List<HoaDonChiTietResponse> list) {
        Map<String, HoaDonChiTietResponse> mapHoaDonChiTietResponse = new HashMap<>();
        for (HoaDonChiTietResponse x : list) {
            HoaDonChiTietResponse hdctRespon = new HoaDonChiTietResponse();
            hdctRespon.setId(x.getId());
            hdctRespon.setChiTietSP(x.getChiTietSP());
            hdctRespon.setHoaDon(x.getHoaDon());
            hdctRespon.setTenDongHo(x.getTenDongHo());
            hdctRespon.setMaDongHo(x.getMaDongHo());
            hdctRespon.setSoLuong(x.getSoLuong());
            hdctRespon.setDonGia(x.getDonGia());
            hdctRespon.setTrangThai(x.getTrangThai());
            mapHoaDonChiTietResponse.put(String.valueOf(hdctRespon.getId()), hdctRespon);
        }
        return mapHoaDonChiTietResponse;
    }

    @Override
    public boolean delete(UUID id) {
        if (hoaDonRes.delete(id)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteALL(UUID id) {
        if (hoaDonRes.deleteAll(id)) {
            return true;
        }
        return false;
    }

    public boolean checkCTSP(UUID id, List<HoaDonChiTietResponse> list) {
        for (HoaDonChiTietResponse x : list) {
            if (x.getChiTietSP().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<HoaDonChiTiet> findByIdHD(UUID id) {
        return hoaDonRes.findByIdHD(id);
    }

}

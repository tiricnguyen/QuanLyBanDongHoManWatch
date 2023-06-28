/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.HoaDonChiTiet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import viewModel.HoaDonChiTietResponse;

/**
 *
 * @author congh
 */
public interface HoaDonChiTietService {

    List<HoaDonChiTietResponse> getAllByTrangThai(int i);

    List<HoaDonChiTietResponse> getAllReponse();

    List<HoaDonChiTietResponse> getAllByNameAndTrangThai(String name, int i);

    List<HoaDonChiTiet> getAll();

    String save(HoaDonChiTiet hdct);

    String update(HoaDonChiTiet hdct);

    boolean delete(UUID id);

    boolean deleteALL(UUID id);

    HoaDonChiTiet findByMa(String ma);

    HoaDonChiTiet findById(UUID id);

    List<HoaDonChiTiet> findByIdHD(UUID id);

    Map<String, HoaDonChiTietResponse> convertHdct(List<HoaDonChiTietResponse> list);

    List<HoaDonChiTietResponse> getGioHang(UUID idHoaDon);

    boolean updateSoLuong(UUID idSP, UUID idHD, int SoLuong);

    boolean checkCTSP(UUID id, List<HoaDonChiTietResponse> list);
}

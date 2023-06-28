/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.HoaDon;
import domainModel.HoaDonChiTiet;
import domainModel.KhachHang;
import java.util.List;
import java.util.UUID;
import viewModel.HoaDonResponse;

/**
 *
 * @author congh
 */
public interface HoaDonService {

    List<HoaDonResponse> getAllByTrangThai(int i);

    List<HoaDon> getAll(int tt);

    HoaDon insert(HoaDon hd);

    String update(HoaDon hd);

    HoaDon findId(UUID id);

    List<HoaDon> findByIdVoucher(UUID id);

    List<HoaDonResponse> getAllResponse();

    List<HoaDonResponse> getHoaDonCho(UUID id, int trangThai);

    List<HoaDonResponse> locTrangThai(int trangThai);

    List<HoaDon> getAll();

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.VoucherSanPham;
import java.util.List;
import java.util.UUID;
import viewModel.VoucherResponse;

/**
 *
 * @author Oanh Xinh
 */
public interface VoucherService {

    List<VoucherResponse> getAllRespone();

    List<VoucherSanPham> getAll();

    String insert(VoucherSanPham ldh);

    String update(VoucherSanPham ldh);

    String updateTrangThai(UUID id, int trangThai);

    List<VoucherResponse> getAllByTrangThai (int tt);

    VoucherSanPham findById(UUID id);

    VoucherSanPham findIdByMa(String ma);

    String printExcel();

    List<VoucherResponse> getAllByTenOrTrangThai(String Ten, int tt);

    VoucherSanPham findIdCbx(String ten);
}

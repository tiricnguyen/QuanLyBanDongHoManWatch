/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModel.NhanVien;
import java.util.List;
import java.util.UUID;
import viewModel.NhanVienResponse;

/**
 *
 * @author congh
 */
public interface NhanVienService {

    List<NhanVien> getALL();

    List<NhanVienResponse> getAllResponse();

    String getLoGin(String Gmail, String MK);

    String insert(NhanVien nv);

    String update(NhanVien nv);

    String guiMail(String emailNhan,
            String tieuDe, String noiDung);

    NhanVien SaveOrUpdate(NhanVien nv);

    List<NhanVienResponse> getAllByNameAndtrangThai(String name, int trangThai);

    List<NhanVienResponse> getAllByTrangThai(int trangThai);

    boolean UpdateTrangThai(NhanVien nv);

    String printExcel();

    NhanVien findId(UUID id);
}

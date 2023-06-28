package service;

import domainModel.SerialBanHang;
import java.util.List;
import java.util.UUID;
import viewModel.SerialBanHangResponse;

public interface SerialBanHangService {

    List<SerialBanHangResponse> getAllById(UUID id, int trangThai);

    List<SerialBanHang> getAllTrangThai(int trangThai);
    
    String insert(SerialBanHang serialBanHang);

    String update(SerialBanHang serialBanHang);

    boolean delete(UUID id);
    
    boolean deleteHdct(UUID id);

    SerialBanHang findIdByMa(String ma);
}

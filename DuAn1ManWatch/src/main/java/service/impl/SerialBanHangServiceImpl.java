package service.impl;

import domainModel.SerialBanHang;
import java.util.List;
import java.util.UUID;
import repository.impl.SerialBanHangRepository;
import service.SerialBanHangService;
import viewModel.SerialBanHangResponse;

public class SerialBanHangServiceImpl implements SerialBanHangService {

    private SerialBanHangRepository serialBanHangRepository = new SerialBanHangRepository();

    @Override
    public List<SerialBanHangResponse> getAllById(UUID id, int trangThai) {
        return serialBanHangRepository.getAllById(id, trangThai);
    }

    @Override
    public String insert(SerialBanHang serialBanHang) {
        if (serialBanHangRepository.save(serialBanHang) != null) {
            return "Thanh Cong";
        }
        return "That Bai";

    }

    @Override
    public String update(SerialBanHang serialBanHang) {
        if (serialBanHangRepository.findById(serialBanHang.getId()) == null) {
            return "Id Khong Ton Tai";
        }
        if (serialBanHangRepository.saveOrUpdate(serialBanHang) != null) {
            return "Thanh Cong";
        }
        return "That Bai";
    }

    @Override
    public SerialBanHang findIdByMa(String ma) {
        return serialBanHangRepository.findByMa(ma);
    }

    @Override
    public boolean delete(UUID id) {

        if (serialBanHangRepository.delete(id)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteHdct(UUID id) {
        if (serialBanHangRepository.deleteHdct(id)) {
            return true;
        }
        return false;
    }

    @Override
    public List<SerialBanHang> getAllTrangThai(int trangThai) {
        return serialBanHangRepository.getAllTrangThai(trangThai);
    }

}

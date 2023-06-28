package service.impl;

import domainModel.Serial;
import java.util.List;
import java.util.UUID;
import repository.impl.SerialRepository;
import service.SerialService;
import viewModel.SerialResponse;

public class SerialServiceImpl implements SerialService {

    private SerialRepository serialRepository = new SerialRepository();

    @Override
    public String insert(List<Serial> listSerial) {
        return serialRepository.saveAll(listSerial);
    }

    @Override
    public String update(Serial serial) {
        if (serialRepository.saveOrUpdate(serial) != null) {
            return "Thanh Cong";
        }

        return "that bai";
    }

    @Override
    public List<SerialResponse> getAllById(UUID id, int trangThai) {
        return serialRepository.getAllById(id, trangThai);

    }

    @Override
    public List<SerialResponse> searchSerial(String ma, int trangThai) {
        return serialRepository.searchSerial(ma, trangThai);
    }

    @Override
    public Serial findIdByMa(String ma) {
        return serialRepository.findByMa(ma);
    }

    @Override
    public String updateTrangThai(String ma, int trangThai) {
        if (serialRepository.updateTrangThai(ma, trangThai)) {
            return "Thanh Cong";
        }
        return "that bai";
    }

}

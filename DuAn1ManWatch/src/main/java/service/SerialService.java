package service;

import domainModel.Serial;
import java.util.List;
import java.util.UUID;
import viewModel.SerialResponse;

public interface SerialService {

    List<SerialResponse> getAllById(UUID id, int trangThai);

    String insert(List<Serial> listSerial);

    String update(Serial serial);

    String updateTrangThai(String ma, int trangThai);
    
    List<SerialResponse> searchSerial(String ma, int trangThai);

    Serial findIdByMa(String ma);
    
    

}

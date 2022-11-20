package service;

import domainModel.MatDongHo;
import java.util.List;

public interface MatDongHoService {

    List<MatDongHo> getAll();
    
    MatDongHo findIdCbx(String ten);
}

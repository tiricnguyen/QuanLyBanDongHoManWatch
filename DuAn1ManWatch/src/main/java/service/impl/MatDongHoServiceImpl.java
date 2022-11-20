package service.impl;


import domainModel.MatDongHo;
import java.util.List;
import repository.impl.MatDongHoRepository;
import service.MatDongHoService;

public class MatDongHoServiceImpl implements MatDongHoService {

    private MatDongHoRepository matDongHoRepository;

    public MatDongHoServiceImpl() {
        matDongHoRepository = new MatDongHoRepository();
    }

    @Override
    public List<MatDongHo> getAll() {
        return matDongHoRepository.getAll();
    }

    @Override
    public MatDongHo findIdCbx(String ten) {
        return matDongHoRepository.findIdCbx(ten);
    }

}

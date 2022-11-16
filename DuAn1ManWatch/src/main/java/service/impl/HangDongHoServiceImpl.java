package service.impl;


import domainModel.HangDongHo;
import java.util.List;
import repository.impl.HangDongHoRepository;
import service.HangDongHoService;

public class HangDongHoServiceImpl implements HangDongHoService{
    private HangDongHoRepository hangDongHoRepository;

    public HangDongHoServiceImpl() {
        hangDongHoRepository = new HangDongHoRepository();
    }
    
    

    @Override
    public List<HangDongHo> getAll() {
        return hangDongHoRepository.getAll();
    }
}

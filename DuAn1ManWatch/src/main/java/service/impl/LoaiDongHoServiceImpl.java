package service.impl;

import domainModel.LoaiDongHo;
import java.util.List;
import repository.impl.LoaiDongHoRepository;
import service.LoaiDongHoService;

public class LoaiDongHoServiceImpl implements LoaiDongHoService {

    private LoaiDongHoRepository loaiDongHoRepository;

    public LoaiDongHoServiceImpl() {
        loaiDongHoRepository = new LoaiDongHoRepository();
    }

    @Override
    public List<LoaiDongHo> getAll() {
        return loaiDongHoRepository.getAll();

    }

    @Override
    public LoaiDongHo findIdCbx(String ten) {
        return loaiDongHoRepository.findIdCbx(ten);
    }

}

package service.impl;


import domainModel.NangLuongSuDung;
import java.util.List;
import repository.impl.NangLuongSuDungRepository;
import service.NangLuongSuDungService;

public class NangLuongSuDungServiceImpl implements NangLuongSuDungService {

    private NangLuongSuDungRepository nangLuongSuDungRepository;

    public NangLuongSuDungServiceImpl() {
        nangLuongSuDungRepository = new NangLuongSuDungRepository();
    }

    @Override
    public List<NangLuongSuDung> getAll() {
        return nangLuongSuDungRepository.getAll();
    }

}

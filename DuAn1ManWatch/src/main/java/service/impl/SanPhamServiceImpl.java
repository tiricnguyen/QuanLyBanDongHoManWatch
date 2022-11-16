package service.impl;

import domainModel.SanPham;
import java.util.List;
import repository.impl.SanPhamRepository;
import service.SanPhamService;

public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository;

    public SanPhamServiceImpl() {
        sanPhamRepository = new SanPhamRepository();
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }
}

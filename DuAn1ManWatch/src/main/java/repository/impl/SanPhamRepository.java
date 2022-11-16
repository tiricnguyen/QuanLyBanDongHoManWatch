package repository.impl;


import repository.CrudRepository;
import domainModel.SanPham;
import java.util.UUID;
import viewModel.SanPhamResponse;


public class SanPhamRepository extends CrudRepository<UUID, SanPham, SanPhamResponse> {

    public SanPhamRepository() {
        className = SanPham.class.getName();
        
    }

}

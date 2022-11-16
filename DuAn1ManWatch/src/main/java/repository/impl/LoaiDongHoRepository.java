package repository.impl;


import repository.CrudRepository;
import domainModel.LoaiDongHo;
import java.util.UUID;
import viewModel.LoaiDongHoResponse;


public class LoaiDongHoRepository extends CrudRepository<UUID, LoaiDongHo, LoaiDongHoResponse>{
    
    
    public LoaiDongHoRepository() {
        className = LoaiDongHo.class.getName();

    }

    
}

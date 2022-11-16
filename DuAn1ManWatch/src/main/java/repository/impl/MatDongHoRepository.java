package repository.impl;


import repository.CrudRepository;
import domainModel.MatDongHo;
import java.util.UUID;
import viewModel.MatDongHoResponse;


public class MatDongHoRepository extends CrudRepository<UUID, MatDongHo, MatDongHoResponse>{
    
    
    public MatDongHoRepository() {
        className = MatDongHo.class.getName();
       }
    
    
}

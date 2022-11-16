
package repository.impl;


import repository.CrudRepository;
import domainModel.HangDongHo;
import java.util.UUID;
import viewModel.HangDongHoResponse;


public class HangDongHoRepository extends CrudRepository<UUID, HangDongHo, HangDongHoResponse>{
    
    public HangDongHoRepository() {
        className = HangDongHo.class.getName();

    }
    
    
    
}

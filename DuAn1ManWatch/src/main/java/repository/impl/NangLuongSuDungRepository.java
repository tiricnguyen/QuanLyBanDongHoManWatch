package repository.impl;


import repository.CrudRepository;
import domainModel.NangLuongSuDung;
import java.util.UUID;
import viewModel.NangLuongSuDungResponse;


public class NangLuongSuDungRepository extends CrudRepository<UUID, NangLuongSuDung, NangLuongSuDungResponse> {

    public NangLuongSuDungRepository() {
        className = NangLuongSuDung.class.getName();
      
    }

}

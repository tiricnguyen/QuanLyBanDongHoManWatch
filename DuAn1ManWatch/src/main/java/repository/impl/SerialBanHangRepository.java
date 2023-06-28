
package repository.impl;

import domainModel.SerialBanHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.SerialBanHangResponse;
import viewModel.SerialResponse;

public class SerialBanHangRepository extends CrudRepository<UUID, SerialBanHang, SerialResponse>{

    public SerialBanHangRepository() {
        className = SerialBanHang.class.getName();
        res = "new viewModel.SerialBanHangResponse(a.id , a.hoaDonChiTiet.id ,a.ma , a.trangThai)";
    }
    
     public List<SerialBanHangResponse> getAllById(UUID id ,int trangThai) {
        List<SerialBanHangResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a where a.hoaDonChiTiet.id = :id and a.trangThai =:trangThai";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.setParameter("trangThai", trangThai);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }
     
     public boolean delete(UUID id) {

        boolean check = false;

        String sql = "DELETE FROM SerialBanHang a WHERE a.id = :id";
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            query.executeUpdate();

            check = true;
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }
        return check;
    }
     
     public boolean deleteHdct(UUID id) {

        boolean check = false;

        String sql = "DELETE FROM SerialBanHang a WHERE a.hoaDonChiTiet.id = :id";
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            query.executeUpdate();

            check = true;
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }
        return check;
    }
     
}

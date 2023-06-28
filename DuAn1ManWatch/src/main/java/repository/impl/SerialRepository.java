package repository.impl;

import domainModel.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.SerialResponse;

public class SerialRepository extends CrudRepository<UUID, Serial, SerialResponse> {

    public SerialRepository() {
        className = Serial.class.getName();
        res = " new viewModel.SerialResponse(a.id ,a.ma ,a.trangThai ,a.chiTietSanPham.id)";
    }

    public List<SerialResponse> getAllById(UUID id, int trangThai) {
        List<SerialResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a where a.chiTietSanPham.id = :id and a.trangThai =:trangThai";
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

    public List<SerialResponse> searchSerial(String ma, int trangThai) {
        List<SerialResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a where"
                    + " a.ma LIKE CONCAT('%',:ma,'%') and a.trangThai =: trangThai";
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            query.setParameter("trangThai", trangThai);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    public boolean updateTrangThai(String ma, int trangThai) {

        boolean check = false;

        String sql = "UPDATE Serial SET trangThai = :trangThai WHERE ma = :ma";
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("ma", ma);
            query.setParameter("trangThai", trangThai);
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

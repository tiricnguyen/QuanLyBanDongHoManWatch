package repository.impl;

import domainModel.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.HoaDonChiTietResponse;

public class HoaDonChiTietRepository extends CrudRepository<UUID, HoaDonChiTiet, HoaDonChiTietResponse> {

    public HoaDonChiTietRepository() {
        className = HoaDonChiTiet.class.getName();
        res = " new viewModel.HoaDonChiTietResponse(a.id, a.hoaDon.id, a.chiTietSP.id, a.chiTietSP.sanPham.ma,a.chiTietSP.sanPham.ten, a.soLuong, a.donGia, a.trangThai)";
    }

    public List<HoaDonChiTietResponse> getGioHang(UUID idHoaDon) {
        List<HoaDonChiTietResponse> list = new ArrayList<>();
        session = HibernateUtil.getSession();
        try {
            javax.persistence.Query query = session.createQuery("SELECT new viewModel.HoaDonChiTietResponse(a.id, a.hoaDon.id, a.chiTietSP.id, a.chiTietSP.sanPham.ma,a.chiTietSP.sanPham.ten, a.soLuong, a.donGia, a.trangThai)"
                    + " FROM HoaDonChiTiet a WHERE a.hoaDon.id = :id");
            query.setParameter("id", idHoaDon);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateSoLuong(UUID idSP, UUID idHD, int soLuong) {

        boolean check = false;

        String sql = "UPDATE HoaDonChiTiet a SET a.soLuong = :soLuong WHERE a.chiTietSP.id = :idSP and a.hoaDon.id = :idHD ";
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("idSP", idSP);
            query.setParameter("idHD", idHD);
            query.setParameter("soLuong", soLuong);
            query.executeUpdate();

            check = true;
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }
        return check;
    }

    public boolean delete(UUID id) {

        boolean check = false;

        String sql = "DELETE FROM HoaDonChiTiet a WHERE a.id = :id";
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

    public boolean deleteAll(UUID id) {

        boolean check = false;

        String sql = "DELETE FROM HoaDonChiTiet a  WHERE a.hoaDon.id = :id";
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

    public List<HoaDonChiTiet> findByIdHD(UUID id) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.hoaDon.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

}

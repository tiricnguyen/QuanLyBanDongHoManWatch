/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.ChiTietSanPham;
import java.util.Map;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.ChiTietSanPhamResponse;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamRepository extends CrudRepository<UUID, ChiTietSanPham, ChiTietSanPhamResponse> {

    public ChiTietSanPhamRepository() {

        className = ChiTietSanPham.class.getName();
        res = "new viewModel.ChiTietSanPhamResponse(a.id ,a.sanPham.ma, a.hangDongHo.ten, a.loaiDongHo.ten, a.sanPham.ten,a.barCode ,a.chongNuoc , a.sizeDay ,a.soLuong , a.giaBan ,a.moTa,a.xuatXu, a.trangThai)";

    }

    public boolean updateSoLuong(UUID id, int soLuong) {
        boolean check = false;
        String sql = "UPDATE ChiTietSanPham SET soLuong = :soLuong WHERE id = :id";
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
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

    public boolean updateTrangThai(UUID id, int trangThai) {
        boolean check = false;
        String sql = "UPDATE ChiTietSanPham a SET a.trangThai = :trangThai WHERE a.id = :id";
        try {
            session.clear();
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
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
    
    public ChiTietSanPham findByBarCode(String barCode) {
        ChiTietSanPham ctsp = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.barCode = :barCode";
            Query query = session.createQuery(hql);
            query.setParameter("barCode", barCode);
            if (query.getSingleResult() != null) {
                ctsp = (ChiTietSanPham) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return ctsp;
    }

}

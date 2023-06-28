/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.KhachHangResponse;

/**
 *
 * @author Admin
 */
public class KhachHangRepository extends CrudRepository<UUID, KhachHang, KhachHangResponse> {

    public KhachHangRepository() {
        className = KhachHang.class.getName();
        res = "new viewModel.KhachHangResponse(a.id,a.ma,a.hoVaTen,a.ngaySinh,a.sdt,a.diaChi)";
        ten = "hoVaTen";
    }

    public KhachHang findBySdt(String SDT) {
        KhachHang entity = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.sdt = :sdt";
            Query query = session.createQuery(hql);
            query.setParameter("sdt", SDT);
            if (query.getSingleResult() != null) {
                entity = (KhachHang) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return entity;
    }

    public List<KhachHangResponse> sreachSdt(String sdt, int tt) {
        List<KhachHangResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a where"
                    + " a.sdt LIKE CONCAT('%',:sdt,'%') and"
                    + " a.trangThai = :tt";
            Query query = session.createQuery(hql);
            query.setParameter("sdt", sdt);
            query.setParameter("tt", tt);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

}

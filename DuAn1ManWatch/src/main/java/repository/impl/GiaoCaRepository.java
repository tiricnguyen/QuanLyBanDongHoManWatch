/*                          
                            +====================+
                            |                    |
                            |     TIRICNGUYEN    |
                            |                    |
                            +====================+  
 */
package repository.impl;

import domainModel.GiaoCa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.GiaoCaResponse;

/**
 *
 * @author Admin
 */
public class GiaoCaRepository extends CrudRepository<UUID, GiaoCa, GiaoCaResponse> {

    public GiaoCaRepository() {
        className = GiaoCa.class.getName();
        res = "new viewModel.GiaoCaResponse(a.id ,a.ma, a.thoiGianNhanCa,a.thoiGianGiaoCa, b.nhanVienTrongCa, c.nhanVienCaTiepTheo,a.tienMatDauCa ,a.tongTienMatCuoiCa , a.tongTienMat ,a.tongTienChuyenKhoan , a.tienPhatSinh ,a.ghiChuPhatSinh,a.tongTienTrongCa,a.thoiGianReset,a.tongSoHoaDon,a.tongTienMatRut, a.trangThai)";
    }

    public List<GiaoCaResponse> getAllVM() {
        List<GiaoCaResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a LEFT JOIN a.nhanVienTrongCa b  LEFT JOIN a.nhanVienCaTiepTheo c ";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

   

    public List<GiaoCa> findByIdNhanVien(UUID id) {
        List<GiaoCa> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.nhanVienTrongCa.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public GiaoCa giaoCaByThoiGian(Date thoiGianNhanCa, Date thoiGianGiaoCa) {
        GiaoCa gc = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE between a.thoiGianNhanCa = :thoiGianNhanCa and a.thoiGianGiaoCa = :thoiGianGiaoCa";
            Query query = session.createQuery(hql);
            query.setParameter("thoiGianNhanCa", thoiGianNhanCa);
            query.setParameter("thoiGianGiaoCa", thoiGianGiaoCa);
            gc = (GiaoCa) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return gc;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainModel.VoucherSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.VoucherResponse;

/**
 *
 * @author Oanh Xinh
 */
public class VoucherRepository extends CrudRepository<UUID, VoucherSanPham, VoucherResponse> {

    public VoucherRepository() {
        className = VoucherSanPham.class.getName();
        res = "new viewModel.VoucherResponse(a.id, a.ma , a.ten , a.phamTram , a.ngayBatDau , a.ngayKetThuc , a.trangThai )";
        ten = "ten";
    }

    public boolean updateTrangThai(UUID id, int trangThai) {

        boolean check = false;

        String sql = "UPDATE VoucherSanPham SET trangThai = :trangThai WHERE id = :id";
        try {
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

}

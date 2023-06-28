/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainModel.HoaDon;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.query.Query;
import repository.CrudRepository;
import utillies.HibernateUtil;
import viewModel.HoaDonResponse;

/**
 *
 * @author congh
 */
public class HoaDonRepository extends CrudRepository<UUID, HoaDon, HoaDonResponse> {

    public HoaDonRepository() {
        className = HoaDon.class.getName();
        res = "new viewModel.HoaDonResponse(a.id , b.hoVaTen, c.hoVaTen, d.ten , a.ma, a.ngayTao, a.ngayThanhToan, a.ngayHen, a.giamGia, a.tenNguoiNhan , a.sdt,a.tienMat,a.chuyenKhoan,a.thanhTien, a.ghiChu , a.trangThai)";
    }

    public List<HoaDon> getAllHoaDon(int trangThai) {
        List<HoaDon> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE trangThai = :trangThai ORDER BY a.ma desc";
            Query query = session.createQuery(hql);
            query.setParameter("trangThai", trangThai);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<HoaDonResponse> getAllVM() {
        List<HoaDonResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a LEFT JOIN a.nhanVien b  LEFT JOIN a.khachHang c LEFT JOIN a.voucher d ";
            Query query = session.createQuery(hql);

            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    public List<HoaDonResponse> getAllCho(UUID id, int tt) {
        List<HoaDonResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a LEFT JOIN a.nhanVien b  LEFT JOIN a.khachHang c LEFT JOIN a.voucher d where a.nhanVien.id = : id and a.trangThai = :tt  ORDER BY a.ma desc";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            query.setParameter("tt", tt);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    public List<HoaDonResponse> locTrangThai(int trangThai) {
        List<HoaDonResponse> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a LEFT JOIN a.nhanVien b  LEFT JOIN a.khachHang c LEFT JOIN a.voucher d WHERE a.trangThai = :trangThai";
            Query query = session.createQuery(hql);
            query.setParameter("trangThai", trangThai);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    public HoaDon findBySdt(String SDT) {
        HoaDon entity = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.sdt = :sdt";
            Query query = session.createQuery(hql);
            query.setParameter("sdt", SDT);
            if (query.getSingleResult() != null) {
                entity = (HoaDon) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return entity;
    }

    public List<HoaDon> findByIdVoucher(UUID id) {
        List<HoaDon> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.voucher.id = :id";
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

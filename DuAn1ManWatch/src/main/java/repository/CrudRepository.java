package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utillies.HibernateUtil;

public abstract class CrudRepository<K, Entity, Response> {

    protected Session session;
    protected Transaction trans;
    protected String className;
    protected String res;
    protected String ten;

    public List<Response> getAllResponse() {
        List<Response> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    

    public List<Entity> getAllTrangThai(int trangThai) {
        List<Entity> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE trangThai = :trangThai";
            Query query = session.createQuery(hql);
            query.setParameter("trangThai", trangThai);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<Response> getAllByTrangThai(int tt) {
        List<Response> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a where"
                    + " a.trangThai = :tt";
            Query query = session.createQuery(hql);
            query.setParameter("tt", tt);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    public List<Response> getAllByTenOrTrangThai(String Ten, int tt) {
        List<Response> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a where"
                    + " a." + ten + " LIKE CONCAT('%',:Ten,'%') and"
                    + " a.trangThai = :tt";
            Query query = session.createQuery(hql);
            query.setParameter("Ten", Ten);
            query.setParameter("tt", tt);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    public List<Entity> getAll() {
        List<Entity> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public Entity saveOrUpdate(Entity entity) {
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(entity);
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }

    public Entity save(Entity entity) {
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            session.save(entity);
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }

    public String saveAll(List<Entity> list) {
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            for (Entity xx : list) {
                session.saveOrUpdate(xx);
            }
            trans.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Entity findById(K id) {
        Entity entity = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            entity = (Entity) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public Entity findByMa(String ma) {
        Entity entity = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.ma = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", ma);
            if (query.getSingleResult() != null) {
                entity = (Entity) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return entity;
    }

    public Entity findByGmailAndMK(String Gmail, String MK) {
        Entity entitys = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE email =: email and matKhau =: matKhau";
            Query query = session.createQuery(hql);
            query.setParameter("email", Gmail);
            query.setParameter("matKhau", MK);
            entitys = (Entity) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e);

        }
        return entitys;
    }

    public List<Response> getAllByNameAndTrangThai(String ten, int tt) {
        List<Response> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res
                    + " From " + className + " a Where a.hoVaTen like CONCAT('%', :ten,'%')"
                    + " and a.trangThai = :tt";
            Query query = session.createQuery(hql);
            query.setParameter("ten", ten);
            query.setParameter("tt", tt);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
        return list;
    }

    public Entity timGmail(String email) {
        Entity entitys = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE email =: email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            entitys = (Entity) query.getSingleResult();

        } catch (Exception e) {
            System.out.println(e);
        }
        return entitys;
    }

    public Entity findIdCbx(String ten) {
        Entity entity = null;
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT a FROM " + className + " a WHERE a.ten = :ten";
            Query query = session.createQuery(hql);
            query.setParameter("ten", ten);
            if (query.getSingleResult() != null) {
                entity = (Entity) query.getSingleResult();
            }
        } catch (Exception e) {
        }
        return entity;
    }

}

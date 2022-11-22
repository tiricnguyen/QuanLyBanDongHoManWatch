package repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utillies.HibernateUtil;

public abstract class CrudRepository<K, Entity, Response> {

    protected Session session;
    protected Transaction trans;
    protected String className;
    protected String res;

    public List<Response> getAllResponse() {
        List<Response> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSession();
            String hql = "SELECT " + res + " FROM " + className + " a";
            Query query = session.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean saveAll(List<Entity> list) {
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
            return false;
        }
        return true;
    }

    public boolean detele(Entity entity) {
        try {
            session = HibernateUtil.getSession();
            trans = session.beginTransaction();
            session.delete(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

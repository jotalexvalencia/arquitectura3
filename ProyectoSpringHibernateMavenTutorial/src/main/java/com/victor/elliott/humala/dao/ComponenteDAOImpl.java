package com.victor.elliott.humala.dao;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.victor.elliott.humala.formulario.ComponenteForm;
import com.victor.elliott.humala.util.HibernateUtil;
 
public class ComponenteDAOImpl implements ComponenteDAO{
    public void agregarComponente(ComponenteForm componente) {
 
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(componente);
 
        try {
            trns = session.beginTransaction();
            session.save(componente);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public List<ComponenteForm> mostrarComponentes() {
        List<ComponenteForm> componentes = new ArrayList<ComponenteForm>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            componentes = session.createQuery("from ComponenteForm").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
 
        return componentes;
    }
    public void eliminarComponente(Integer id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            ComponenteForm componente = (ComponenteForm) session.load(ComponenteForm.class, new Integer(id));
            session.delete(componente);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public void actualizarComponente(ComponenteForm componente) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(componente);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public ComponenteForm mostrarComponente(int id) {
        ComponenteForm componente = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from ComponenteForm where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            componente = (ComponenteForm) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return componente;
    }
}
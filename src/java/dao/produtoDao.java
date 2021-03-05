package dao;

import entidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class produtoDao {

    public static boolean persist(Produto pr) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pr);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static Produto getOne(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        return em.find(Produto.class, pId);
    }

    public static boolean excluir(Long pId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        Produto pr = em.find(Produto.class, pId);
        try {
            em.getTransaction().begin();
            em.remove(pr);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public static List<Produto> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Produto> tq = em.createQuery("select p  from Produto p", Produto.class);
        return tq.getResultList();
    }

    public static boolean editar(Produto pr) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pr);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

}

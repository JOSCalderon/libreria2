/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.exceptions.NonexistentEntityException;
import Entidades.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jose
 */
public class PruebaempleadoJpaController implements Serializable {

    public PruebaempleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pruebaempleado pruebaempleado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pruebaempleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPruebaempleado(pruebaempleado.getIdempleado()) != null) {
                throw new PreexistingEntityException("Pruebaempleado " + pruebaempleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pruebaempleado pruebaempleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pruebaempleado = em.merge(pruebaempleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = pruebaempleado.getIdempleado();
                if (findPruebaempleado(id) == null) {
                    throw new NonexistentEntityException("The pruebaempleado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigInteger id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pruebaempleado pruebaempleado;
            try {
                pruebaempleado = em.getReference(Pruebaempleado.class, id);
                pruebaempleado.getIdempleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pruebaempleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(pruebaempleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pruebaempleado> findPruebaempleadoEntities() {
        return findPruebaempleadoEntities(true, -1, -1);
    }

    public List<Pruebaempleado> findPruebaempleadoEntities(int maxResults, int firstResult) {
        return findPruebaempleadoEntities(false, maxResults, firstResult);
    }

    private List<Pruebaempleado> findPruebaempleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pruebaempleado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pruebaempleado findPruebaempleado(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pruebaempleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getPruebaempleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pruebaempleado> rt = cq.from(Pruebaempleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

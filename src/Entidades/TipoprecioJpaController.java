/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Entidades.exceptions.NonexistentEntityException;
import Entidades.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class TipoprecioJpaController implements Serializable {

    public TipoprecioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoprecio tipoprecio) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoprecio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoprecio(tipoprecio.getIdtipoprecio()) != null) {
                throw new PreexistingEntityException("Tipoprecio " + tipoprecio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoprecio tipoprecio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoprecio = em.merge(tipoprecio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = tipoprecio.getIdtipoprecio();
                if (findTipoprecio(id) == null) {
                    throw new NonexistentEntityException("The tipoprecio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoprecio tipoprecio;
            try {
                tipoprecio = em.getReference(Tipoprecio.class, id);
                tipoprecio.getIdtipoprecio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoprecio with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoprecio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoprecio> findTipoprecioEntities() {
        return findTipoprecioEntities(true, -1, -1);
    }

    public List<Tipoprecio> findTipoprecioEntities(int maxResults, int firstResult) {
        return findTipoprecioEntities(false, maxResults, firstResult);
    }

    private List<Tipoprecio> findTipoprecioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoprecio.class));
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

    public Tipoprecio findTipoprecio(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoprecio.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoprecioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoprecio> rt = cq.from(Tipoprecio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
public class TipoventaJpaController implements Serializable {

    public TipoventaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoventa tipoventa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoventa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoventa(tipoventa.getIdtipoventa()) != null) {
                throw new PreexistingEntityException("Tipoventa " + tipoventa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoventa tipoventa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoventa = em.merge(tipoventa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = tipoventa.getIdtipoventa();
                if (findTipoventa(id) == null) {
                    throw new NonexistentEntityException("The tipoventa with id " + id + " no longer exists.");
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
            Tipoventa tipoventa;
            try {
                tipoventa = em.getReference(Tipoventa.class, id);
                tipoventa.getIdtipoventa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoventa with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoventa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoventa> findTipoventaEntities() {
        return findTipoventaEntities(true, -1, -1);
    }

    public List<Tipoventa> findTipoventaEntities(int maxResults, int firstResult) {
        return findTipoventaEntities(false, maxResults, firstResult);
    }

    private List<Tipoventa> findTipoventaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoventa.class));
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

    public Tipoventa findTipoventa(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoventa.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoventaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoventa> rt = cq.from(Tipoventa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

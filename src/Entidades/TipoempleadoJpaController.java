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
public class TipoempleadoJpaController implements Serializable {

    public TipoempleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoempleado tipoempleado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoempleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoempleado(tipoempleado.getIdtipoempleado()) != null) {
                throw new PreexistingEntityException("Tipoempleado " + tipoempleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoempleado tipoempleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoempleado = em.merge(tipoempleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = tipoempleado.getIdtipoempleado();
                if (findTipoempleado(id) == null) {
                    throw new NonexistentEntityException("The tipoempleado with id " + id + " no longer exists.");
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
            Tipoempleado tipoempleado;
            try {
                tipoempleado = em.getReference(Tipoempleado.class, id);
                tipoempleado.getIdtipoempleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoempleado with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoempleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoempleado> findTipoempleadoEntities() {
        return findTipoempleadoEntities(true, -1, -1);
    }

    public List<Tipoempleado> findTipoempleadoEntities(int maxResults, int firstResult) {
        return findTipoempleadoEntities(false, maxResults, firstResult);
    }

    private List<Tipoempleado> findTipoempleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoempleado.class));
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

    public Tipoempleado findTipoempleado(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoempleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoempleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoempleado> rt = cq.from(Tipoempleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

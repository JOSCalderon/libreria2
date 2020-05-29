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
public class CargarproductosJpaController implements Serializable {

    public CargarproductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cargarproductos cargarproductos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cargarproductos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCargarproductos(cargarproductos.getIdproducto()) != null) {
                throw new PreexistingEntityException("Cargarproductos " + cargarproductos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cargarproductos cargarproductos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cargarproductos = em.merge(cargarproductos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigInteger id = cargarproductos.getIdproducto();
                if (findCargarproductos(id) == null) {
                    throw new NonexistentEntityException("The cargarproductos with id " + id + " no longer exists.");
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
            Cargarproductos cargarproductos;
            try {
                cargarproductos = em.getReference(Cargarproductos.class, id);
                cargarproductos.getIdproducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cargarproductos with id " + id + " no longer exists.", enfe);
            }
            em.remove(cargarproductos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargarproductos> findCargarproductosEntities() {
        return findCargarproductosEntities(true, -1, -1);
    }

    public List<Cargarproductos> findCargarproductosEntities(int maxResults, int firstResult) {
        return findCargarproductosEntities(false, maxResults, firstResult);
    }

    private List<Cargarproductos> findCargarproductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cargarproductos.class));
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

    public Cargarproductos findCargarproductos(BigInteger id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cargarproductos.class, id);
        } finally {
            em.close();
        }
    }

    public int getCargarproductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cargarproductos> rt = cq.from(Cargarproductos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

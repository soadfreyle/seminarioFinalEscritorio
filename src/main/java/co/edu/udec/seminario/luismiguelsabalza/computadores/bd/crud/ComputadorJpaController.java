/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udec.seminario.luismiguelsabalza.computadores.bd.crud;

import co.edu.udec.seminario.luismiguelsabalza.computadores.bd.crud.exceptions.NonexistentEntityException;
import co.edu.udec.seminario.luismiguelsabalza.computadores.bd.crud.exceptions.PreexistingEntityException;
import co.edu.udec.seminario.luismiguelsabalza.computadores.bd.entidades.Computador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author EQUIPO
 */
public class ComputadorJpaController implements Serializable {

    public ComputadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Computador computador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(computador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComputador(computador.getId()) != null) {
                throw new PreexistingEntityException("Computador " + computador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Computador computador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            computador = em.merge(computador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = computador.getId();
                if (findComputador(id) == null) {
                    throw new NonexistentEntityException("The computador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Computador computador;
            try {
                computador = em.getReference(Computador.class, id);
                computador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The computador with id " + id + " no longer exists.", enfe);
            }
            em.remove(computador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Computador> findComputadorEntities() {
        return findComputadorEntities(true, -1, -1);
    }

    public List<Computador> findComputadorEntities(int maxResults, int firstResult) {
        return findComputadorEntities(false, maxResults, firstResult);
    }

    private List<Computador> findComputadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Computador.class));
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

    public Computador findComputador(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Computador.class, id);
        } finally {
            em.close();
        }
    }

    public int getComputadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Computador> rt = cq.from(Computador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

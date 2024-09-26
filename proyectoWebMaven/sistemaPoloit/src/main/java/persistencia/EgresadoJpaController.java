/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Curso;
import logica.Egresado;
import logica.Mentor;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Maria
 */
public class EgresadoJpaController implements Serializable {

    public EgresadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public EgresadoJpaController() {
        emf = Persistence.createEntityManagerFactory("SistemaPoloit_PU");
    }

    public void create(Egresado egresado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso unCurso = egresado.getUnCurso();
            if (unCurso != null) {
                unCurso = em.getReference(unCurso.getClass(), unCurso.getId_curso());
                egresado.setUnCurso(unCurso);
            }
            Mentor mentorAsignado = egresado.getMentorAsignado();
            if (mentorAsignado != null) {
                mentorAsignado = em.getReference(mentorAsignado.getClass(), mentorAsignado.getId());
                egresado.setMentorAsignado(mentorAsignado);
            }
            em.persist(egresado);
            if (unCurso != null) {
                unCurso.getListaAlumnos().add(egresado);
                unCurso = em.merge(unCurso);
            }
            if (mentorAsignado != null) {
                mentorAsignado.getListaAlumnos().add(egresado);
                mentorAsignado = em.merge(mentorAsignado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Egresado egresado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Egresado persistentEgresado = em.find(Egresado.class, egresado.getId());
            Curso unCursoOld = persistentEgresado.getUnCurso();
            Curso unCursoNew = egresado.getUnCurso();
            Mentor mentorAsignadoOld = persistentEgresado.getMentorAsignado();
            Mentor mentorAsignadoNew = egresado.getMentorAsignado();
            if (unCursoNew != null) {
                unCursoNew = em.getReference(unCursoNew.getClass(), unCursoNew.getId_curso());
                egresado.setUnCurso(unCursoNew);
            }
            if (mentorAsignadoNew != null) {
                mentorAsignadoNew = em.getReference(mentorAsignadoNew.getClass(), mentorAsignadoNew.getId());
                egresado.setMentorAsignado(mentorAsignadoNew);
            }
            egresado = em.merge(egresado);
            if (unCursoOld != null && !unCursoOld.equals(unCursoNew)) {
                unCursoOld.getListaAlumnos().remove(egresado);
                unCursoOld = em.merge(unCursoOld);
            }
            if (unCursoNew != null && !unCursoNew.equals(unCursoOld)) {
                unCursoNew.getListaAlumnos().add(egresado);
                unCursoNew = em.merge(unCursoNew);
            }
            if (mentorAsignadoOld != null && !mentorAsignadoOld.equals(mentorAsignadoNew)) {
                mentorAsignadoOld.getListaAlumnos().remove(egresado);
                mentorAsignadoOld = em.merge(mentorAsignadoOld);
            }
            if (mentorAsignadoNew != null && !mentorAsignadoNew.equals(mentorAsignadoOld)) {
                mentorAsignadoNew.getListaAlumnos().add(egresado);
                mentorAsignadoNew = em.merge(mentorAsignadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = egresado.getId();
                if (findEgresado(id) == null) {
                    throw new NonexistentEntityException("The egresado with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Egresado egresado;
            try {
                egresado = em.getReference(Egresado.class, id);
                egresado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The egresado with id " + id + " no longer exists.", enfe);
            }
            Curso unCurso = egresado.getUnCurso();
            if (unCurso != null) {
                unCurso.getListaAlumnos().remove(egresado);
                unCurso = em.merge(unCurso);
            }
            Mentor mentorAsignado = egresado.getMentorAsignado();
            if (mentorAsignado != null) {
                mentorAsignado.getListaAlumnos().remove(egresado);
                mentorAsignado = em.merge(mentorAsignado);
            }
            em.remove(egresado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Egresado> findEgresadoEntities() {
        return findEgresadoEntities(true, -1, -1);
    }

    public List<Egresado> findEgresadoEntities(int maxResults, int firstResult) {
        return findEgresadoEntities(false, maxResults, firstResult);
    }

    private List<Egresado> findEgresadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Egresado.class));
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

    public Egresado findEgresado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Egresado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEgresadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Egresado> rt = cq.from(Egresado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

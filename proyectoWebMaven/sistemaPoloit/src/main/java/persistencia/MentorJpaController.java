/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Curso;
import logica.Egresado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Mentor;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Maria
 */
public class MentorJpaController implements Serializable {

    public MentorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public MentorJpaController() {
        emf = Persistence.createEntityManagerFactory("SistemaPoloit_PU");
    }

    public void create(Mentor mentor) {
        if (mentor.getListaAlumnos() == null) {
            mentor.setListaAlumnos(new ArrayList<Egresado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso unCurso = mentor.getUnCurso();
            if (unCurso != null) {
                unCurso = em.getReference(unCurso.getClass(), unCurso.getId_curso());
                mentor.setUnCurso(unCurso);
            }
            List<Egresado> attachedListaAlumnos = new ArrayList<Egresado>();
            for (Egresado listaAlumnosEgresadoToAttach : mentor.getListaAlumnos()) {
                listaAlumnosEgresadoToAttach = em.getReference(listaAlumnosEgresadoToAttach.getClass(), listaAlumnosEgresadoToAttach.getId());
                attachedListaAlumnos.add(listaAlumnosEgresadoToAttach);
            }
            mentor.setListaAlumnos(attachedListaAlumnos);
            em.persist(mentor);
            if (unCurso != null) {
                Mentor oldMentorAsignadoOfUnCurso = unCurso.getMentorAsignado();
                if (oldMentorAsignadoOfUnCurso != null) {
                    oldMentorAsignadoOfUnCurso.setUnCurso(null);
                    oldMentorAsignadoOfUnCurso = em.merge(oldMentorAsignadoOfUnCurso);
                }
                unCurso.setMentorAsignado(mentor);
                unCurso = em.merge(unCurso);
            }
            for (Egresado listaAlumnosEgresado : mentor.getListaAlumnos()) {
                Mentor oldMentorAsignadoOfListaAlumnosEgresado = listaAlumnosEgresado.getMentorAsignado();
                listaAlumnosEgresado.setMentorAsignado(mentor);
                listaAlumnosEgresado = em.merge(listaAlumnosEgresado);
                if (oldMentorAsignadoOfListaAlumnosEgresado != null) {
                    oldMentorAsignadoOfListaAlumnosEgresado.getListaAlumnos().remove(listaAlumnosEgresado);
                    oldMentorAsignadoOfListaAlumnosEgresado = em.merge(oldMentorAsignadoOfListaAlumnosEgresado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mentor mentor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mentor persistentMentor = em.find(Mentor.class, mentor.getId());
            Curso unCursoOld = persistentMentor.getUnCurso();
            Curso unCursoNew = mentor.getUnCurso();
            List<Egresado> listaAlumnosOld = persistentMentor.getListaAlumnos();
            List<Egresado> listaAlumnosNew = mentor.getListaAlumnos();
            if (unCursoNew != null) {
                unCursoNew = em.getReference(unCursoNew.getClass(), unCursoNew.getId_curso());
                mentor.setUnCurso(unCursoNew);
            }
            List<Egresado> attachedListaAlumnosNew = new ArrayList<Egresado>();
            for (Egresado listaAlumnosNewEgresadoToAttach : listaAlumnosNew) {
                listaAlumnosNewEgresadoToAttach = em.getReference(listaAlumnosNewEgresadoToAttach.getClass(), listaAlumnosNewEgresadoToAttach.getId());
                attachedListaAlumnosNew.add(listaAlumnosNewEgresadoToAttach);
            }
            listaAlumnosNew = attachedListaAlumnosNew;
            mentor.setListaAlumnos(listaAlumnosNew);
            mentor = em.merge(mentor);
            if (unCursoOld != null && !unCursoOld.equals(unCursoNew)) {
                unCursoOld.setMentorAsignado(null);
                unCursoOld = em.merge(unCursoOld);
            }
            if (unCursoNew != null && !unCursoNew.equals(unCursoOld)) {
                Mentor oldMentorAsignadoOfUnCurso = unCursoNew.getMentorAsignado();
                if (oldMentorAsignadoOfUnCurso != null) {
                    oldMentorAsignadoOfUnCurso.setUnCurso(null);
                    oldMentorAsignadoOfUnCurso = em.merge(oldMentorAsignadoOfUnCurso);
                }
                unCursoNew.setMentorAsignado(mentor);
                unCursoNew = em.merge(unCursoNew);
            }
            for (Egresado listaAlumnosOldEgresado : listaAlumnosOld) {
                if (!listaAlumnosNew.contains(listaAlumnosOldEgresado)) {
                    listaAlumnosOldEgresado.setMentorAsignado(null);
                    listaAlumnosOldEgresado = em.merge(listaAlumnosOldEgresado);
                }
            }
            for (Egresado listaAlumnosNewEgresado : listaAlumnosNew) {
                if (!listaAlumnosOld.contains(listaAlumnosNewEgresado)) {
                    Mentor oldMentorAsignadoOfListaAlumnosNewEgresado = listaAlumnosNewEgresado.getMentorAsignado();
                    listaAlumnosNewEgresado.setMentorAsignado(mentor);
                    listaAlumnosNewEgresado = em.merge(listaAlumnosNewEgresado);
                    if (oldMentorAsignadoOfListaAlumnosNewEgresado != null && !oldMentorAsignadoOfListaAlumnosNewEgresado.equals(mentor)) {
                        oldMentorAsignadoOfListaAlumnosNewEgresado.getListaAlumnos().remove(listaAlumnosNewEgresado);
                        oldMentorAsignadoOfListaAlumnosNewEgresado = em.merge(oldMentorAsignadoOfListaAlumnosNewEgresado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mentor.getId();
                if (findMentor(id) == null) {
                    throw new NonexistentEntityException("The mentor with id " + id + " no longer exists.");
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
            Mentor mentor;
            try {
                mentor = em.getReference(Mentor.class, id);
                mentor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mentor with id " + id + " no longer exists.", enfe);
            }
            Curso unCurso = mentor.getUnCurso();
            if (unCurso != null) {
                unCurso.setMentorAsignado(null);
                unCurso = em.merge(unCurso);
            }
            List<Egresado> listaAlumnos = mentor.getListaAlumnos();
            for (Egresado listaAlumnosEgresado : listaAlumnos) {
                listaAlumnosEgresado.setMentorAsignado(null);
                listaAlumnosEgresado = em.merge(listaAlumnosEgresado);
            }
            em.remove(mentor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mentor> findMentorEntities() {
        return findMentorEntities(true, -1, -1);
    }

    public List<Mentor> findMentorEntities(int maxResults, int firstResult) {
        return findMentorEntities(false, maxResults, firstResult);
    }

    private List<Mentor> findMentorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mentor.class));
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

    public Mentor findMentor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mentor.class, id);
        } finally {
            em.close();
        }
    }

    public int getMentorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mentor> rt = cq.from(Mentor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

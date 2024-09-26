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
import logica.Mentor;
import logica.Egresado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Curso;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Maria
 */
public class CursoJpaController implements Serializable {

    public CursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
     public CursoJpaController() {
        emf = Persistence.createEntityManagerFactory("SistemaPoloit_PU");
    }

    public void create(Curso curso) {
        if (curso.getListaAlumnos() == null) {
            curso.setListaAlumnos(new ArrayList<Egresado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mentor mentorAsignado = curso.getMentorAsignado();
            if (mentorAsignado != null) {
                mentorAsignado = em.getReference(mentorAsignado.getClass(), mentorAsignado.getId());
                curso.setMentorAsignado(mentorAsignado);
            }
            List<Egresado> attachedListaAlumnos = new ArrayList<Egresado>();
            for (Egresado listaAlumnosEgresadoToAttach : curso.getListaAlumnos()) {
                listaAlumnosEgresadoToAttach = em.getReference(listaAlumnosEgresadoToAttach.getClass(), listaAlumnosEgresadoToAttach.getId());
                attachedListaAlumnos.add(listaAlumnosEgresadoToAttach);
            }
            curso.setListaAlumnos(attachedListaAlumnos);
            em.persist(curso);
            if (mentorAsignado != null) {
                Curso oldUnCursoOfMentorAsignado = mentorAsignado.getUnCurso();
                if (oldUnCursoOfMentorAsignado != null) {
                    oldUnCursoOfMentorAsignado.setMentorAsignado(null);
                    oldUnCursoOfMentorAsignado = em.merge(oldUnCursoOfMentorAsignado);
                }
                mentorAsignado.setUnCurso(curso);
                mentorAsignado = em.merge(mentorAsignado);
            }
            for (Egresado listaAlumnosEgresado : curso.getListaAlumnos()) {
                Curso oldUnCursoOfListaAlumnosEgresado = listaAlumnosEgresado.getUnCurso();
                listaAlumnosEgresado.setUnCurso(curso);
                listaAlumnosEgresado = em.merge(listaAlumnosEgresado);
                if (oldUnCursoOfListaAlumnosEgresado != null) {
                    oldUnCursoOfListaAlumnosEgresado.getListaAlumnos().remove(listaAlumnosEgresado);
                    oldUnCursoOfListaAlumnosEgresado = em.merge(oldUnCursoOfListaAlumnosEgresado);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getId_curso());
            Mentor mentorAsignadoOld = persistentCurso.getMentorAsignado();
            Mentor mentorAsignadoNew = curso.getMentorAsignado();
            List<Egresado> listaAlumnosOld = persistentCurso.getListaAlumnos();
            List<Egresado> listaAlumnosNew = curso.getListaAlumnos();
            if (mentorAsignadoNew != null) {
                mentorAsignadoNew = em.getReference(mentorAsignadoNew.getClass(), mentorAsignadoNew.getId());
                curso.setMentorAsignado(mentorAsignadoNew);
            }
            List<Egresado> attachedListaAlumnosNew = new ArrayList<Egresado>();
            for (Egresado listaAlumnosNewEgresadoToAttach : listaAlumnosNew) {
                listaAlumnosNewEgresadoToAttach = em.getReference(listaAlumnosNewEgresadoToAttach.getClass(), listaAlumnosNewEgresadoToAttach.getId());
                attachedListaAlumnosNew.add(listaAlumnosNewEgresadoToAttach);
            }
            listaAlumnosNew = attachedListaAlumnosNew;
            curso.setListaAlumnos(listaAlumnosNew);
            curso = em.merge(curso);
            if (mentorAsignadoOld != null && !mentorAsignadoOld.equals(mentorAsignadoNew)) {
                mentorAsignadoOld.setUnCurso(null);
                mentorAsignadoOld = em.merge(mentorAsignadoOld);
            }
            if (mentorAsignadoNew != null && !mentorAsignadoNew.equals(mentorAsignadoOld)) {
                Curso oldUnCursoOfMentorAsignado = mentorAsignadoNew.getUnCurso();
                if (oldUnCursoOfMentorAsignado != null) {
                    oldUnCursoOfMentorAsignado.setMentorAsignado(null);
                    oldUnCursoOfMentorAsignado = em.merge(oldUnCursoOfMentorAsignado);
                }
                mentorAsignadoNew.setUnCurso(curso);
                mentorAsignadoNew = em.merge(mentorAsignadoNew);
            }
            for (Egresado listaAlumnosOldEgresado : listaAlumnosOld) {
                if (!listaAlumnosNew.contains(listaAlumnosOldEgresado)) {
                    listaAlumnosOldEgresado.setUnCurso(null);
                    listaAlumnosOldEgresado = em.merge(listaAlumnosOldEgresado);
                }
            }
            for (Egresado listaAlumnosNewEgresado : listaAlumnosNew) {
                if (!listaAlumnosOld.contains(listaAlumnosNewEgresado)) {
                    Curso oldUnCursoOfListaAlumnosNewEgresado = listaAlumnosNewEgresado.getUnCurso();
                    listaAlumnosNewEgresado.setUnCurso(curso);
                    listaAlumnosNewEgresado = em.merge(listaAlumnosNewEgresado);
                    if (oldUnCursoOfListaAlumnosNewEgresado != null && !oldUnCursoOfListaAlumnosNewEgresado.equals(curso)) {
                        oldUnCursoOfListaAlumnosNewEgresado.getListaAlumnos().remove(listaAlumnosNewEgresado);
                        oldUnCursoOfListaAlumnosNewEgresado = em.merge(oldUnCursoOfListaAlumnosNewEgresado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = curso.getId_curso();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
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
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getId_curso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            Mentor mentorAsignado = curso.getMentorAsignado();
            if (mentorAsignado != null) {
                mentorAsignado.setUnCurso(null);
                mentorAsignado = em.merge(mentorAsignado);
            }
            List<Egresado> listaAlumnos = curso.getListaAlumnos();
            for (Egresado listaAlumnosEgresado : listaAlumnos) {
                listaAlumnosEgresado.setUnCurso(null);
                listaAlumnosEgresado = em.merge(listaAlumnosEgresado);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    public Curso findCurso(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

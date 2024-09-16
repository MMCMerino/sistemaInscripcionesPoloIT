

package logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author hrivas
 */

@Entity

public class Curso {
    //MM ver bien 
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int  id_curso;
    private int cantAlumnos;
    //Faltria el nombre del curso y numero de comision
   
    @OneToOne
    private Mentor mentorAsignado;
    
    @ManyToOne
    @JoinColumn(name="adminCurso_id")
    private Administrador adminAsignadoCurso;
    
    @OneToMany(mappedBy="unCurso")
    private List<Egresado> listaAlumnos;

    public Curso() {
    }

    public Curso(int cantAlumnos, Mentor mentorAsignado, Administrador adminAsignadoCurso, List<Egresado> listaAlumnos) {
        this.cantAlumnos = cantAlumnos;
        this.mentorAsignado = mentorAsignado;
        this.adminAsignadoCurso = adminAsignadoCurso;
        this.listaAlumnos = listaAlumnos;
    }

    public int getId_curso() {
        return id_curso;
    }

    
    public int getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(int cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    public Mentor getMentorAsignado() {
        return mentorAsignado;
    }

    public void setMentorAsignado(Mentor mentorAsignado) {
        this.mentorAsignado = mentorAsignado;
    }

    public Administrador getAdminAsignadoCurso() {
        return adminAsignadoCurso;
    }

    public void setAdminAsignadoCurso(Administrador adminAsignadoCurso) {
        this.adminAsignadoCurso = adminAsignadoCurso;
    }

   

    public List<Egresado> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Egresado> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    
    
    
}

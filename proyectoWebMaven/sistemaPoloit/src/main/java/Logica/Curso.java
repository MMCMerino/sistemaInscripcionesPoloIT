

package logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
    private Mentor mentorAsignado;
    private Administrador adminAsignado;
    private List<Egresado> listaAlumnos;

    public Curso() {
    }

    public Curso(int cantAlumnos, Mentor mentorAsignado, Administrador adminAsignado, List<Egresado> listaAlumnos) {
        this.cantAlumnos = cantAlumnos;
        this.mentorAsignado = mentorAsignado;
        this.adminAsignado = adminAsignado;
        this.listaAlumnos = listaAlumnos;
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

    public Administrador getAdminAsignado() {
        return adminAsignado;
    }

    public void setAdminAsignado(Administrador adminAsignado) {
        this.adminAsignado = adminAsignado;
    }

    public List<Egresado> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Egresado> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    
    
    
}

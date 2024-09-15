
package logica;

import java.util.Date;
import javax.persistence.Entity;
@Entity

public class Egresado extends Persona{
    
    
    private int comision;
    private Curso unCurso;
    //MM
    private Mentor mentorAsignado;
    private Administrador adminAsignado;
    //
    public Egresado() {
    }

    public Egresado(int comision, Curso unCurso, Mentor mentorAsignado, Administrador adminAsignado, String nombre, String apellido, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, correo, telefono, fecha_nac);
        this.comision = comision;
        this.unCurso = unCurso;
        this.mentorAsignado = mentorAsignado;
        this.adminAsignado = adminAsignado;
    }
    
    

   


    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public Curso getUnCurso() {
        return unCurso;
    }

    public void setUnCurso(Curso unCurso) {
        this.unCurso = unCurso;
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
    
    
    
          
}

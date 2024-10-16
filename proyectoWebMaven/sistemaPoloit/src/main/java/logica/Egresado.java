
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity

public class Egresado extends Persona implements Serializable{
    
    
    private int comision;
    
    @ManyToOne
    @JoinColumn(name="curso_id")
    private Curso unCurso;
    
    @ManyToOne
    @JoinColumn(name="mentor_id")
    private Mentor mentorAsignado;
    
    @ManyToOne
    @JoinColumn(name="admin_id")
    private Administrador adminAsignado;
    //
    public Egresado() {
    }

    public Egresado(String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, dni, correo, telefono, fecha_nac);
    }
    
    

    public Egresado(int comision, Curso unCurso, Mentor mentorAsignado, Administrador adminAsignado, String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, dni, correo, telefono, fecha_nac);
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

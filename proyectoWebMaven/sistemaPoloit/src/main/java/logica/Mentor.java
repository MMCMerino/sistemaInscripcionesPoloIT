package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Mentor extends Persona implements Serializable {
    
    private String empresa;
    private String especializacion;
    
    
    @OneToOne
    private Curso unCurso;
    
    
    @OneToOne
    private Usuario unUsuario;
    
    //MM
    @ManyToOne
    @JoinColumn(name="adminMentor_id")
    private Administrador unAdministrador;
    
    @OneToMany(mappedBy="mentorAsignado")
    private List<Egresado> listaAlumnos;
    //
    
    public Mentor() {
    }

    public Mentor(String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, dni, correo, telefono, fecha_nac);
    }

    public Mentor(String empresa, String especializacion, Curso unCurso, Usuario unUsuario, Administrador unAdministrador, List<Egresado> listaAlumnos, String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, dni, correo, telefono, fecha_nac);
        this.empresa = empresa;
        this.especializacion = especializacion;
        this.unCurso = unCurso;
        this.unUsuario = unUsuario;
        this.unAdministrador = unAdministrador;
        this.listaAlumnos = listaAlumnos;
    }

   

   
    

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public Curso getUnCurso() {
        return unCurso;
    }

    public void setUnCurso(Curso unCurso) {
        this.unCurso = unCurso;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Administrador getUnAdministrador() {
        return unAdministrador;
    }

    public void setUnAdministrador(Administrador unAdministrador) {
        this.unAdministrador = unAdministrador;
    }

    public List<Egresado> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Egresado> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    
 
}

package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Administrador extends Persona{
    
    private String especializacion;
    private String cargo;
   
    @OneToOne
    private Usuario unUsuario;
    
    
    @OneToMany(mappedBy="unAdministrador")
    private List<Mentor> listaMentores;
    
    @OneToMany(mappedBy="adminAsignado")
    private List<Egresado> listaAlumnosDeAdmin;
    
    @OneToMany(mappedBy="adminAsigndoCurso")
    private List<Curso> listaCursos;
    
    
    
    
    
    public Administrador() {
    }

    
    
    
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }


    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    
    
}

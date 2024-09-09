package logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Administrador extends Persona{
    
    private String especializacion;
    private String cargo;
    @OneToOne
    private Usuario unUsuario;
    
    public Administrador() {
    }

    public Administrador( String especializacion, String cargo, Usuario unUsuario, String nombre, String apellido, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, correo, telefono, fecha_nac);
        
        this.especializacion = especializacion;
        this.cargo = cargo;
        this.unUsuario = unUsuario;
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

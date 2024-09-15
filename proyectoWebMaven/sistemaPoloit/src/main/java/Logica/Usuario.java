package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

public class Usuario {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_usuario;
    private String nombreUsuario;
    private String contrasenia;
    ///no se si poner cargo
    //MM
    private String rol;
    
    public Usuario(){}

    public Usuario( String nombreUsuario, String contrasenia) {
        
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

   

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
}

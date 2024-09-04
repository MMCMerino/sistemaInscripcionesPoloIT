package logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//Persona es una herencia pero no quiero que persista
//para guardar en la base de datos 
@Entity
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)
public class Persona {
    @Id
    @GenerationValue(strategy= GenerationType IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;    
    private String telefono;
    private Date fecha_nac;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String correo, String telefono, Date fecha_nac) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    
    
    
}

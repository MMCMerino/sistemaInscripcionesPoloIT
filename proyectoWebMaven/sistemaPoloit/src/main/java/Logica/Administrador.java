package logica;

import java.util.Date;


public class Administrador extends Persona{
    
    private String especializacion;
    private String cargo;
    
    public Administrador() {
    }

    public Administrador( String especializacion, String cargo, String nombre, String apellido, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, correo, telefono, fecha_nac);
        
        this.especializacion = especializacion;
        this.cargo = cargo;
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

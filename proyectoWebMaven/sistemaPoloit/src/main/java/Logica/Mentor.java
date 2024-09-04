package logica;

import java.util.Date;


public class Mentor extends Persona {
    
    private String empresa;
    private String especializacion;
    private Curso unCurso;
    private Usuario unUsuario;
    
    public Mentor() {
    }

    public Mentor( String empresa, String especializacion, Curso unCurso, Usuario unUsuario, String nombre, String apellido, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, correo, telefono, fecha_nac);
        
        this.empresa = empresa;
        this.especializacion = especializacion;
        this.unCurso = unCurso;
        this.unUsuario = unUsuario;
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
    
    
 
}

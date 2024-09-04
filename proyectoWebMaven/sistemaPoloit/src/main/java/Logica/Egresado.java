
package logica;

import java.util.Date;

public class Egresado extends Persona{
    
    
    private int comision;
    private Curso unCurso;

    public Egresado() {
    }
    
    

    public Egresado( int comision, Curso unCurso, String nombre, String apellido, String correo, String telefono, Date fecha_nac) {
        super(nombre, apellido, correo, telefono, fecha_nac);
        
        this.comision = comision;
        this.unCurso = unCurso;
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
    
    
          
}

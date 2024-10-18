/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author Maria
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
   
     
    
    public void crearUsuario(String nombreUsuario, String contrasenia, String rol){
        Usuario usu = new Usuario(nombreUsuario, contrasenia, rol);
        controlPersis.crearUsuario(usu);
    }
    
   

    public List<Usuario> getUsuarios() {
        
        return controlPersis.getUsuarios();
    }

    public void crearInscripcionEgresado(String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        Egresado inscripcion_egre = new Egresado(nombre, apellido, dni,correo, telefono, fecha_nac);
        controlPersis.crearInscripcionEgresado(inscripcion_egre);
    }
    
    public void crearInscripcionMentor(String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        Mentor inscripcion_mentor = new Mentor(nombre, apellido, dni,correo, telefono, fecha_nac);
        controlPersis.crearInscripcionMentor(inscripcion_mentor);
    }

    public boolean comprobarIngreso(String usuario, String contra) {
        
        boolean ingreso = false;
        
        List<Usuario> listaUsuarios =new ArrayList<Usuario>();
        
        listaUsuarios=controlPersis.getUsuarios();
        
        for(Usuario usu : listaUsuarios){
        if(usu.getNombreUsuario().equals(usuario)){
            if(usu.getContrasenia().equals(contra)){
                
        ingreso = true;
        }
        }
        }
     return ingreso; 
    }
      
}

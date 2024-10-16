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
    ControladoraPersistencia controlPersisEgresado = new ControladoraPersistencia();
    
    
    public void crearUsuario(String nombreUsuario, String contrasenia, String rol){
        Usuario usu = new Usuario(nombreUsuario, contrasenia, rol);
        controlPersis.crearUsuario(usu);
    }
    
   

    public List<Usuario> getUsuarios() {
        
        return controlPersis.getUsuarios();
    }

    public void crearInscripcionEgresado(String nombre, String apellido, String dni, String correo, String telefono, Date fecha_nac) {
        Egresado inscripcion_egre = new Egresado(nombre, apellido, dni,correo, telefono, fecha_nac);
        controlPersisEgresado.crearInscripcionEgresado(inscripcion_egre);
    }
    
}

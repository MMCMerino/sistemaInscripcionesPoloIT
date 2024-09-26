/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

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
    
}

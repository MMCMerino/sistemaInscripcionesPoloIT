/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import logica.Egresado;
import logica.Usuario;

/**
 *
 * @author Maria
 */
public class ControladoraPersistencia {
    AdministradorJpaController adminJPA = new AdministradorJpaController();
    CursoJpaController cursoJPA = new CursoJpaController();
    EgresadoJpaController egresadoJPA = new EgresadoJpaController();
    MentorJpaController mentorJPA = new MentorJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    
    
    
    public void crearUsuario(Usuario usu){
    
    usuarioJPA.create(usu);
    }
    
    public void crearInscripcionEgresado(Egresado inscripcion_egre){
    
    egresadoJPA.create(inscripcion_egre);
    }

    public List<Usuario> getUsuarios() {
    return usuarioJPA.findUsuarioEntities();
        
    }
}

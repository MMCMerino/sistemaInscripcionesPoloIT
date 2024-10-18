/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

/**
 *
 * @author Maria
 */
@WebServlet(name = "SvMentores", urlPatterns = {"/SvMentores"})
public class SvMentores extends HttpServlet {

    Controladora control_mentor = new Controladora();
     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String dni = request.getParameter("dni");
        String telefono = request.getParameter("telefono");
        String fechaNacString = request.getParameter("fecha_nac");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the pattern as necessary
        Date fecha_nac = null;

        try {
            fecha_nac = format.parse(fechaNacString); // Handle the exception as needed
        } catch (java.text.ParseException ex) {
            Logger.getLogger(SvEgresados.class.getName()).log(Level.SEVERE, null, ex);
        }
               
         
        control_mentor.crearInscripcionMentor(nombre, apellido, dni,correo, telefono,fecha_nac);
        response.sendRedirect("altaUsuarioEgresado.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

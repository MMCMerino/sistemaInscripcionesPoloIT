/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

     Controladora control = new Controladora();
     
     
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
        
       String usuario = request.getParameter("nombreUsu");
       String contra = request.getParameter("contrasenia");
       
       boolean validacion = false;
       
       validacion = control.comprobarIngreso(usuario,contra);
       
       if(validacion == true){
       HttpSession miSesion = request.getSession(true);
       miSesion.setAttribute("usuario",usuario);
       response.sendRedirect("bienvenido.jsp");
       }
       else{
        response.sendRedirect("loginError.jsp");
       }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

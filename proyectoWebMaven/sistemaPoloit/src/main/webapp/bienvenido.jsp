<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body.jsp"%>
 <% HttpSession miSesion = request.getSession();
  String usuario=(String)request.getSession().getAttribute("usuario");
  
if(usuario == null){
     response.sendRedirect("login.jsp");
     }

 
 %>
  
  
     <h1 class="pl-5">BIENVENIDO</h1>
 

    
<%@include file="componentes/footer.jsp" %>  



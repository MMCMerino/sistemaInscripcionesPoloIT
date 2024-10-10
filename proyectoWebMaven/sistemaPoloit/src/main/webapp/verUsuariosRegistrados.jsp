<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body.jsp"%>
 
     
     
        <!-- Begin Page Content -->
                <div class="container-fluid">

                   

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="mt-2 font-weight-bold text-primary">Lista de usuarios registrados</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            
                                        </tr>
                                    </tfoot>
                                    <%
                                       List<Usuario>listaUsuarios = (List)request.getSession().getAttribute("listaUsuarios");
                                    %>
                                    <tbody>
                                        <%for(Usuario usu: listaUsuarios){%>
                                        <tr>
                                            <td><%=usu.getId_usuario()%></td>
                                            <td><%=usu.getNombreUsuario()%></td>
                                            <td><%=usu.getRol()%></td>
                                            
                                        </tr>
                                        <% }%>
                                     
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>  
                        
                    </div>
                    
                </div>
 

    
<%@include file="componentes/footer.jsp" %>  

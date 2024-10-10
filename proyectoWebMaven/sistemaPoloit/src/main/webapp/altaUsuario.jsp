

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body.jsp"%>
 
     <h1 class="pl-5">Alta Usuario</h1>
 
     <!-- Plantilla de crear usuario -->
                
                    
                      
                        <div class="p-5">
                              <hr>
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Cree su cuenta!</h1>
                            </div>
                            <form class="user" action="SvUsuarios" method="POST">
                               <!-- <div class="form-group row">
                                    <<div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombre"
                                            placeholder="Nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="apellido"
                                            placeholder="Apellido">
                                    </div> 
                                </div>-->
                                <div class="mx-auto" style="width: 40vw;">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                                        placeholder="Elija su nombre de usuario">
                                </div>
                                <div class="form-group">
                                    
                                        <input type="password" class="form-control form-control-user"
                                            id="contrasenia" name="contrasenia" placeholder="Contraseña">
                                   
                                  <!--  <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="repetirContrasenia" placeholder="Repetir contraseña">
                                    </div>  -->
                                </div>
                                 <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="rol"  name="rol"
                                        placeholder="Rol: Administrador, estudiante o mentor">
                                        
                                 </div>
                               
                                <button  class="btn btn-primary btn-user btn-block" type="submit">
                                    Crear Usuario
                                </button>
                                <hr>
                                </div>
                            </form>
                            
                           
                            <div class="text-center">
                                <a class="small" href="#">Ya esta registrado? Ingrese!</a>
                            </div>
                        </div>
                  
                
       

    
<%@include file="componentes/footer.jsp" %>  



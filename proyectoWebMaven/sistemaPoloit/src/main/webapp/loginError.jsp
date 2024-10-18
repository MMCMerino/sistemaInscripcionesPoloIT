<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body.jsp"%>
 
   <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-5 col-lg-9 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        
                                        <h1 class="h4 text-gray-900 mb-6">Usuario o contraseña no encontrada</h1>
                                        <h2 class="h4 text-gray-900 mb-6">Vuelva a ingresar</h2>
                                    </div>
                                    <form class="user" action="SvLogin" method="POST">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="nombreUsu"  name="nombreUsu"
                                                placeholder="Ingrese su nombre de usuario">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="contrasenia" name="contrasenia" placeholder="Contraseña">
                                        </div>
                                        
                                        <button  class="btn btn-primary btn-user btn-block" type="submit">
                                            Ingresar
                                        </button>
                                        
                                    </form>
                                    <hr>
                                    
                                    <div class="text-center">
                                        <a class="small" href="altaUsuario.jsp">Crear usuario!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

   </div>
    
<%@include file="componentes/footer.jsp" %>  

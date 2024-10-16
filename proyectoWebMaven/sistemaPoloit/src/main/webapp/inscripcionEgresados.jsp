<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body.jsp"%>
 




 <div class="container">
     
        <h1> Inscripciones </h1>
        
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-3 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-6">
                        <div class="p-7">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 m-4">Complete los siguientes campos</h1>
                            </div>
                            <form class="user" action="SvEgresados" method="POST">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                                            placeholder="Nombre">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                                            placeholder="Apellido">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="correo" name="correo"
                                        placeholder="Correo electronico">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="dni" name="dni"
                                        placeholder="DNI">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" class="form-control form-control-user"
                                            id="fecha_nac" name="fecha_nac" placeholder="Fecha de Nacimiento">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                            id="telefono" name="telefono" placeholder="Telefono">
                                    </div>
                                </div>
                                <hr>
                                <button  class="btn btn-primary btn-user btn-block" type="submit">
                                    Inscribirse
                                </button>
                                <hr>
                               
                            </form>
                            
                           
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>















    
<%@include file="componentes/footer.jsp" %>  
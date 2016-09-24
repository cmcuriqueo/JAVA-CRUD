<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<title>Modificacion de Perfil</title>
</head>
<body>
    <form class="form-horizontal" method="POST" action="ModificarPerfil" id="formulario_modificacion">
        <div class="container">
            <div class="row-flow">
                <p></p>
                <div class="col-md-12">
                    <div class="panel panel-success">

                        <div class="panel-body">Modificacion de perfil</div>

                        <div class="panel-footer">
                            <ul class="list-group">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="nombre">Nombre </label>
                                    <div class="col-sm-4"> <input class="form-control" name="nombre" type="text" value="<c:out value="${perfil.nombre}"/>"/></div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="apellido">Apellido </label>
                                    <div class="col-sm-4"> <input class="form-control" name="apellido" type="text" value="<c:out value="${perfil.apellido}"/>"/></div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="dni">Dni </label>
                                    <div class="col-sm-4"><input class="form-control" name="dni" type="text" value="<c:out value="${perfil.dni}"/>"></div>
                                </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label" for="fecha_nacimiento">Fecha de Nacimiento </label>
                                        <div class="col-sm-4"><input class="form-control" name="fecha_nacimiento" type="date" value="<c:out value="${perfil.fecha_nacimiento}"/>"></div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default" >Guardar</button>
                                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">Cancelar</button>

                                            <!-- Modal -->
                                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                            <h4 class="modal-title" id="myModalLabel">Cancelar Modificacion</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            Se perderan todas las modificaciones realizadas<br/>¿Esta seguro de continuar?
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                            <a href="Perfil" class="btn btn-danger">Continuar</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <c:if test="${not empty errores}"><!-- muestro errores-->
                                            <div class="alert alert-danger">
                                                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                                <strong>Error al prosesar el formulario</strong>
                                                <ul>
                                                    <c:forEach var="fila" items="${errores}" >
                                                        <li><c:out value="${fila.value}"/></li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </c:if>
                                    </div>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>

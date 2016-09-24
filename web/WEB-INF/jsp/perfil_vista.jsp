
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<title>Perfil</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <nav class="navbar navbar-default" role="navigation">
                <!-- El logotipo y el icono que despliega el menú se agrupan
                   para mostrarlos mejor en los dispositivos móviles -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Desplegar navegación</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index">Logotipo</a>
                </div>
                <!-- Agrupar los enlaces de navegación, los formularios y cualquier
                                otro elemento que se pueda ocultar al minimizar la barra -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Menú<b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="Logout">Cerrar Session</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="panel panel-success">
                <div class="panel-body">Usuario <small><?php echo $_SESSION['nombre_usuario']; ?></small></div>
                <div class="panel-footer">
                    <blockquote>
                        <p>Nombre: <c:out value="${perfil.nombre}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Apellido: <c:out value="${perfil.apellido}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>DNI: <c:out value="${perfil.dni}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Fecha de Nacimiento: <c:out value="${perfil.fecha_naciemiento}"/></p>
                    </blockquote>
                    <p class="text-center"><a href="ModificarPerfil" class="btn btn-info">Modificar</a></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

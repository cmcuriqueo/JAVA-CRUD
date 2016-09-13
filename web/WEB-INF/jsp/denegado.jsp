<%-- 
    Document   : denegado
    Created on : 13/09/2016, 16:45:40
    Author     : universidad
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src=" <c:url value="/bower_components/jquery/dist/jquery.min.js"></c:url>"></script>
        <script type="text/javascript" src=" <c:url value="/bower_components/bootstrap/dist/js/bootstrap.js"></c:url>"></script>
        <link rel="stylesheet" type="text/css" href=" <c:url value="/bower_components/bootstrap/dist/css/bootstrap.css"></c:url>">
        <script type="text/javascript" src=" <c:url value="/bower_components/jquery-ui/jquery-ui.js"></c:url>"></script>
        <script type="text/javascript" src=" <c:url value="/bower_components/jquery-validation/dist/jquery.validate.js"></c:url>"></script>
        <link rel="stylesheet" type="text/css" href=" <c:url value="/bower_components/jquery-ui/themes/base/jquery-ui.min.css"></c:url>">
        <title>Permiso Denegado</title>
    </head>
    <body>
        <div class="container">
            <div class="row-fluid">
                <div class="alert alert-danger" role="alert" >Acceso denagado.<br/>No tiene permiso de acceso.</div>
                <a href="index" class="btn btn-danger">Inicio</a>
            </div>
        </div>
    </body>
</html>

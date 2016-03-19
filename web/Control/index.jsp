<%-- 
    Document   : Control
    Created on : Nov 17, 2015, 7:57:31 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
	<title>SMTP | Módulo de Control</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="description" content="SMTP - Proyecto ATI - Infraestructura Tecnológica II - II Semestre 2015">
	<meta name="author" content="Trío de la TeMuer">

	<!-- CSS -->
	<link href="/SMTP/recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
	<link href="/SMTP/recursos/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="screen">
	<link href="/SMTP/recursos/css/main.css" rel="stylesheet" type="text/css" media="screen">

	<!--[if lte IE 9]>
			<link href="recursos/css/main-ie.css" rel="stylesheet" type="text/css" media="screen" />
			<link href="recursos/css/main-ie-part2.css" rel="stylesheet" type="text/css" media="screen" />
	<![endif]-->

	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="recursos/ico/kingadmin-favicon144x144.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="recursos/ico/kingadmin-favicon114x114.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="recursos/ico/kingadmin-favicon72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="57x57" href="recursos/ico/kingadmin-favicon57x57.png">
	<link rel="shortcut icon" href="/SMTP/recursos/imagenes/logo.png">

</head>
        <div class="wrapper full-page-wrapper page-login text-center">
            <a href="/SMTP/index.htm"><h1>Home</h1></a>
		<div class="inner-page">
      <div class="logo">
                <a href="/SMTP/index.htm">
                        <img height="10%" width="10%" src="/SMTP/recursos/imagenes/logo.png" alt="" />
                </a>
        </div>
                    <div><h2>Módulo de Control</h2></div>
                    <div><h2>${message}</h2></div>
                    <div><h3><i class="fa fa-cog fa-spin"></i></h3></div>
      <!-- main -->
      <div class="content">
        <div class="main-content">
          <div class="widget widget-table">
            <div class="widget-header">
              <h3><i class="fa fa-users"></i> Usuarios del Sistema </h3>
            </div>
            ${mensaje}
            <div class="widget-content" >
                <center><table style="width:90%">
                  <tr>
                  <strong><th>ID</th></strong>
                  <strong><th>Username</th></strong> 
                  <strong><th>Nombre</th></strong>
                  <strong><th>Apellidos</th></strong>
                  <strong><th>Es Administrador</th></strong>
                  </tr>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.getId_usuario_u()}</td>
                        <td>${usuario.getNombre_de_usuario_u()}</td>
                        <td>${usuario.getNombre_u()}</td>
                        <td>${usuario.getApellidos_u()}</td>
                        <td>${usuario.isEs_administrador_u()}</td>
                    </tr>
                </c:forEach>
                    </table></center>
            </div>
          </div>
        </div>
      </div>
    </div>
                    </div>
        <footer class="footer">&copy; 2015 Trío de la TeMuer</footer>

	<!-- Javascript -->
	<script src="/SMTP/recursos/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="/SMTP/recursos/js/bootstrap/bootstrap.js"></script>
	<script src="/SMTP/recursos/js/plugins/modernizr/modernizr.js"></script>
</body>
</html>

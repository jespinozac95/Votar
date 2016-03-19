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
	<title>Votar | Módulo de Control</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="description" content="Votar - Proyecto ATI - Infraestructura Tecnológica II - II Semestre 2015">
	<meta name="author" content="Trío de la TeMuer">

	<!-- CSS -->
	<link href="/Votar/recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
	<link href="/Votar/recursos/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="screen">
	<link href="/Votar/recursos/css/main.css" rel="stylesheet" type="text/css" media="screen">

	<!--[if lte IE 9]>
			<link href="recursos/css/main-ie.css" rel="stylesheet" type="text/css" media="screen" />
			<link href="recursos/css/main-ie-part2.css" rel="stylesheet" type="text/css" media="screen" />
	<![endif]-->

	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="recursos/ico/kingadmin-favicon144x144.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="recursos/ico/kingadmin-favicon114x114.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="recursos/ico/kingadmin-favicon72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="57x57" href="recursos/ico/kingadmin-favicon57x57.png">
	<link rel="shortcut icon" href="/Votar/recursos/imagenes/logo.png">

</head>
        <div class="wrapper full-page-wrapper page-login text-center">
            <a href="/Votar/index.jsp"><h1>Cerrar Sesión</h1></a>
		<div class="inner-page">
      <div class="logo">
                <a href="/Votar/index.jsp">
                        <img height="10%" width="10%" src="/Votar/recursos/imagenes/box.png" alt="" />
                </a>
        </div>
                    <div><h2>Módulo de Control</h2></div>
                    <div><h2>${mensaje}</h2></div>
                    <div><h3><i class="fa fa-cog fa-spin"></i></h3></div>
      <!-- main -->
      <div class="content">
        <div class="main-content">
          <div class="widget widget-table">
            <div class="widget-header">
              <h3><i class="fa fa-users"></i> Competencias </h3>
            </div>
            ${mensaje}
            <div class="widget-content" >
                <center><table style="width:90%">
                  <tr>
                  <strong><th>Nombre</th></strong>
                  <strong><th>Imagen</th></strong> 
                  </tr>
                <c:forEach items="${usuarios}" var="usuario"> 
                    <tr>
                        <td>TEC Emprende</td>
                        <td><img height="10%" width="10%" src="http://placehold.it/256x256" alt="" /></td>
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
	<script src="/Votar/recursos/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="/Votar/recursos/js/bootstrap/bootstrap.js"></script>
	<script src="/Votar/recursos/js/plugins/modernizr/modernizr.js"></script>
</body>
</html>

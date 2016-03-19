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
	<title>Votar | Competencias</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="description" content="Votar">
	<meta name="author" content="Josué Espinoza - Luis Rodríguez">

	<!-- CSS -->
	<link href="recursos/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen">
	<link href="recursos/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="screen">
	<link href="recursos/css/main.css" rel="stylesheet" type="text/css" media="screen">

	<!--[if lte IE 9]>
			<link href="recursos/css/main-ie.css" rel="stylesheet" type="text/css" media="screen" />
			<link href="recursos/css/main-ie-part2.css" rel="stylesheet" type="text/css" media="screen" />
	<![endif]-->

	<!-- Fav and touch icons -->
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="recursos/ico/kingadmin-favicon144x144.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="recursos/ico/kingadmin-favicon114x114.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="recursos/ico/kingadmin-favicon72x72.png">
	<link rel="apple-touch-icon-precomposed" sizes="57x57" href="recursos/ico/kingadmin-favicon57x57.png">
	<link rel="shortcut icon" href="recursos/imagenes/box.png">

</head>
        <div class="wrapper full-page-wrapper page-login text-center">
            <div class="top-bar" style="height: 50%">
                <div class="container">
                        <div class="row" style="height: 50%; font-family: 'latolight'">
                                <!-- logo -->
                                <div class="col-md-2 logo" style="margin-bottom: 0px">
                                        <a href="index.jsp">
                                                <img src="recursos/imagenes/box_white.png" alt="Votar">
                                                <p style="color:white">Votar</p>
                                        </a>
                                </div>
                                <!-- end logo -->
                                <div class="col-md-10">
                                        <div class="row">
                                            <div class="col-md-9" style="width: 100%; height: 100%">
                                                        <div class="top-bar-right">
                
                                                                <!-- logged user and the menu -->
                                                                <div class="logged-user">
                                                                        <div class="btn-group">
                                                                                <a href="#" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                                                                                        <span class="name">Bienvenido, ${usuario}</span>
                                                                                        <span class="caret"></span>
                                                                                </a>
                                                                                <ul class="dropdown-menu" role="menu">
                                                                                        <li>
                                                                                                <a href="/Votar/index.jsp">
                                                                                                        <i class="fa fa-power-off"></i>
                                                                                                        <span class="text">Cerrar Sesión</span>
                                                                                                </a>
                                                                                        </li>
                                                                                </ul>
                                                                        </div>
                                                                </div>
                                                                <!-- end logged user and the menu -->
                                                        </div>
                                                        <!-- /top-bar-right -->
                                                </div>
                                        </div>
                                        <!-- /row -->
                                </div>
                        </div>
                        <!-- /row -->
                </div>
                <!-- /container -->
        </div>
		<div class="inner-page">
                    <div><h2>${mensaje}</h2></div>
                    <div><h2>Listado de Competencias</h2></div>
                    <div><h3><i class="fa fa-cog fa-spin"></i></h3></div>
      <!-- main -->
      <div class="content">
        <div class="main-content">
          <div class="widget widget-table">
            <div class="widget-header">
              <h3><i class="fa fa-users"></i> Competencias </h3>
            </div>
            <div class="widget-content" >
                <center><table class="table-sorting table-striped table-hover datatable" style="width:90%">
                  <tr>
                  <strong><th>Nombre</th></strong>
                  <strong><th>Imagen</th></strong> 
                  </tr>
                    <tr>
                      
                        <td><img height="10%" width="10%" src="http://placehold.it/256x256" alt="" /></td>
                    </tr>
                    <c:forEach items="${competencias}" var="competencia">

                    <tr >
                      <td>
                        <a href="/Votar/Proyectos/index.jsp">
                        <div style="height:100%;width:100%">
                            ${competencia[0]}
                        </div>
                        </a> 
                       </td>
                       <td>
                       ${competencia[1]}
                       </td>
                       <td>
                       ${competencia[2]}
                       </td>
                       <td>
                       ${competencia[3]}
                       </td>
                       <td>
                       ${competencia[4]}
                       </td>
                       <td></td>
                    </tr>
                  </c:forEach>
                    </table></center>
            </div>
          </div>
        </div>
      </div>
    </div>
                    </div>
        <footer class="footer">&copy; 2016 Votar</footer>

	<!-- Javascript -->
	<script src="/Votar/recursos/js/jquery/jquery-2.1.0.min.js"></script>
	<script src="/Votar/recursos/js/bootstrap/bootstrap.js"></script>
	<script src="/Votar/recursos/js/plugins/modernizr/modernizr.js"></script>
</body>
</html>

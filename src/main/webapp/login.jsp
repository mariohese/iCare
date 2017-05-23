<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<link href='http://fonts.googleapis.com/css?family=Oleo+Script' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>iCare</title>
	</head>
	<body>

		<div id="envoltura">
		
	        <div id="contenedor">
	 
	           <div id="cabecera" style = "text-align: center">
	               <img src="images/iCare.jpg">
	            </div>
	            <br>
	 
	            <div class="login-block">
	            
	                <form action="/login" method="post"> 
	                
						<h1>Login</h1>
						
						<c:if test="${alerta == true }">
							<p id="alerta">Valor de usuario o contraseña incorrecto</p>	
						</c:if>
						
						<input type="text" id="username" name="name" placeholder="Introduzca nombre de usuario" />
						<br>
						
						<input type="password" id="password" name="password" placeholder="Contraseña" />
						<br>
						
						<button type="submit">Log In</button>
							  	
							  
					</form>
	            </div><!--fin cuerpo-->
	        </div><!-- fin contenedor -->
	    </div><!--fin envoltura-->

	</body>
</html>
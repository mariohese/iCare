<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/alarm.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>iCare</title>
	</head>
	
	<body>
	
		<c:if test ="${urgencia == false}">
			<% response.sendRedirect("/main"); %>
		</c:if>
		<div class="modal-wrapper" id="popup">
    		<div class="popup-contenedor">
    					
    						<div id="cabecera" >
    							
    							<div id="alarma">
    								<h1>Alarma detectada</h1>
    							</div>
    						</div>
	   						
	   						<div id="cuerpo">
	   							<div id="imagen">
    								<img src="images/alarma.png">
    							</div>
    							
    							<div id="informacion">
									<h3 id="paciente"><strong>Paciente: <c:out value="${alarma.nombrepaciente}"/></strong></h3>
									<h3 id="description"><strong>Motivo: <c:out value="${alarma.descripcion}"/></strong></h3>
									
								</div>
								
								
								<div id="nivel_box">
									
									<h1 id="nivel"><strong><c:out value="${alarma.nivel}"/></strong></h1>
								
									
								</div>
								<div id="gestionar_box">
									<form action="/alarm_management?id=${alarma.id}&op=${usuario}" method="post">
										<button type="submit" class="btn btn-red" id = "gestionar" >Gestionar</button>
									</form>
								</div>
								
								
							
							
					
    		</div>
		</div>
		
	</div>
	</body>
	
</html>
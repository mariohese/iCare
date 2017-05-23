<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Refresh" content="5">
		<title>iCare</title>
	</head>

	<body>
	
		<c:if test ="${urgencia == true}">
		    <%
		      response.sendRedirect("/alarm_management");
		    %>
		</c:if>
	<div id="cabecera">
		<div id="logo" >
	        <img src="images/iCare.jpg"> 
	    </div>
	    <div id="contacto" >
	        <img src="images/contacto.png"> 
	    </div>
	    <div id="usuario" >
	    		<div id="icus">
	       			<img src="images/user.png">
	       		</div>
	       		<div id="nous">
	       			<p><c:out value="${usuario}"/></p>
	       		</div>
	       		<div id = "salir"> 
					<a href='/'>Log Out</a>	
				</div>
	  		</div>
	  	</div>
	    
	<div id="contenido">
		<div id="navegacion">	
   			<a href='/main'  class="current"><span>Inicio</span></a>
   			<a href='/patients' ><span>Lista Pacientes</span></a>
   			<a href='/anomalies' ><span>Anomalías</span></a>
   		</div>
		<div id="tabla">
			
		
			<table>
                <thead>
                    <tr>
            			<th>Nombre paciente</th>
		   	 			<th>Tipo de anomalía</th>
		    			<th>Fecha</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${anomalias}" var="anomaliasi">
                		<tr class = "alt">
                			<td><a href='/info_patient?id=${anomaliasi.idPaciente}'><c:out value="${anomaliasi.nombrepaciente}" /></a></td>
							<td><c:out value="${anomaliasi.descripcion}"/></td>
							<td><c:out value="${anomaliasi.fecha}" /></td>
						</tr>
					</c:forEach>          
                </tbody>
            </table>
			</div>
		</div>
	</body>
	
</html>
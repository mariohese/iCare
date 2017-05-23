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
            			<th>Nombre</th>
		   	 			<th>Edad</th>
		    			<th>Nivel último alarma</th>
		    			<th>Fecha última alarma</th>
		    			<th>Enfermedades</th>
		    			<th>Discapacidades</th>
		    			<th>Vive sólo (si/no)</th>
		    			<th>Cuidador (si/no)</th>
		    			<th>Telefono contacto</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pacientes}" var="pacientesi">
                		<tr class = "alt">
							<td><a href='/info_patient?id=${pacientesi.id}'><c:out value="${pacientesi.paciente}" /></a></td>
							<td><c:out value="${pacientesi.edad}"/></td>
							<c:choose>
								<c:when test="${pacientesi.ult_nivel == 0}">
									<td>NO TIENE ALARMAS</td>
									<td>NO TIENE ALARMAS</td>
								</c:when>
								<c:otherwise>
									<td><c:out value="${pacientesi.ult_nivel}"/></td>
									<td><c:out value="${pacientesi.ult_fecha}"/></td>
								</c:otherwise>
							</c:choose>
							<td><c:out value="${pacientesi.enf}" /></td>
							<td><c:out value="${pacientesi.disc}" /></td>
							<td><c:out value="${pacientesi.vivesolo}" /></td>
                            <td><c:out value="${pacientesi.cuidador}" /></td>
                            <td><c:out value="${pacientesi.tlfcuid}" /></td>
						
						</tr>
					</c:forEach>
                            	
                            	
                          
                </tbody>
            </table>
			</div>
		</div>
	</body>
	
</html>
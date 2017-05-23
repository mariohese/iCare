<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="css/info_patient.css" />
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
				<div id="seccion1" >
					<div id="apartado1" >
						<div id="tabla_info" class="foto_cabecera">
							<img src="images/information.png"> 
						</div>
						<div class="info_cabecera">
							<h2>Información personal</h2>
						</div>
					
					<table >
 					 <tr>
    					<th>Nombre</th>
   						<td><c:out value="${paciente.nombre}"/></td>
   					</tr>
   					<tr>
    					<th>Apellidos</th>
   						<td><c:out value="${paciente.apellidos}"/></td>
   					</tr>
   					<tr>
    					<th>DNI</th>
   						<td><c:out value="${paciente.dni}"/></td>
   					</tr>
   					<tr>
    					<th>NUSS</th>
   						<td><c:out value="${paciente.NUSS}"/></td>
   					</tr>
   					<tr>
    					<th>Nacimiento</th>
   						<td><c:out value="${paciente.nacimiento}"/></td>
   					</tr>
   					<tr>
    					<th>Dirección</th>
   						<td><c:out value="${paciente.dir}"/></td>
   					</tr>
   					<tr>
    					<th>Ciudad</th>
   						<td><c:out value="${paciente.ciudad}"/></td>
   					</tr>
   					<tr>
    					<th>CP</th>
   						<td><c:out value="${paciente.cp}"/></td>
   					</tr>
   					<tr>
    					<th>Estado civil</th>
   						<td><c:out value="${paciente.estadocivil}"/></td>
   					</tr>
   					<tr>
    					<th>Enfermedades</th>
   						<td><c:out value="${paciente.enf}"/></td>
   					</tr>
   					<tr>
    					<th>Discapacidad</th>
   						<td><c:out value="${paciente.disc}"/></td>
   					</tr>
   					<tr>
    					<th>Consumo medio agua (Minutos)</th>
   						<td><c:out value="${paciente.consumoAguaMedio}"/></td>
   					</tr>
				</table>
	        </div>
	         <div id="apartado2" >
				
				<div class="foto_cabecera">
					<img src="images/phone.png"> 
				</div>
				<div class="info_cabecera">
					<h2>Contactos de emergencia</h2>
				</div>
				<div id="subseccion">
					<div class="info_cabecera">
						<p><strong>Familiares</strong></p>
					</div>
					<div class="foto_cabecera">
						<p><strong>Cuidador</strong></p> 
					</div>
				</div>
				<div id="subseccion">
					<div class="info_cabecera">
						<table class="tabla_espacio">
 					 		<tr>
    							<th>Nombre</th>
   								<td><c:out value="${paciente.nombrefam}"/></td>
   							</tr>
   							<tr>
    							<th>Apellidos</th>
   								<td><c:out value="${paciente.apellfam}"/></td>
   							</tr>
   							<tr>
    							<th>Teléfono</th>
   								<td><c:out value="${paciente.tlffam}"/></td>
   							</tr>
						</table>
					</div>
					<div class="foto_cabecera">
						<table>
 							 <tr>
    							<th>Nombre</th>
   								<td><c:out value="${paciente.nombrecuid}"/></td>
   							</tr>
   							<tr>
    							<th>Apellidos</th>
   								<td><c:out value="${paciente.apellcuid}"/></td>
   							</tr>
   							<tr>
    							<th>Teléfono</th>
   								<td><c:out value="${paciente.tlfcuid}"/></td>
   							</tr>
						</table>
					</div>
				</div>
				
	        </div>      
		</div>
		<div id="seccion2" >
			<div id="apartado3" >
				
				<div id="img_alarmas" class="foto_cabecera">
					<img src="images/warning.png"> 
				</div>
				<div class="info_cabecera">
					<h2>Alarmas y anomalías</h2>
				</div>
				<div id="subseccion">
					<div class="info_cabecera">
						<p><strong>Alarmas</strong></p>
					</div>
					<div class="foto_cabecera">
						<p><strong>Anomalias</strong></p> 
					</div>
				</div>
				
				<div id="subseccion">
					<div class="info_cabecera">
						<table class="tabla_espacio">
								<thead>
								  <tr>
								    <th>Descripcion</th>
   									<th>Fecha</th>
								  </tr>
								 </thead>
								 
								 <tbody>
								
									<c:forEach items="${alarms}" var="al">
									
										<tr class = "alt">
											
											<td><c:out value="${al.descripcion}" /></td>
											<td><c:out value="${al.fecha}" /></td>
											
										</tr>
									</c:forEach>
								
								</tbody>
 
							</table>
					</div>
					<div class="foto_cabecera">
					<table>
								<thead>
								  <tr>
								    <th>Descripcion</th>
   									<th>Fecha</th>
								  </tr>
								 </thead>
								 
								 <tbody>
								
									<c:forEach items="${anomalias}" var="an">
									
										<tr class = "alt">
											
											<td><c:out value="${an.descripcion}" /></td>
											<td><c:out value="${an.fecha}" /></td>
											
										</tr>
									</c:forEach>
								
								</tbody>
 
							</table>
						
					</div>
				</div>
	        </div>
	         <div id="apartado4" >
				<div id="img_sensores" class="foto_cabecera">
					<img src="images/graph.png"> 
				</div>
				<div  id="tabla_sensores" class="info_cabecera">
					<h2>Datos sensores</h2>
				</div>
				<table >
								<thead>
								  <tr>
								    <th>Fecha</th>
   									<th>Pulsaciones/minuto</th>
   									<th>Azúcar (mg/dl)</th>
   									<th>Oxígeno en sangre (%)</th>
   									<th>Tensión sistólica</th>
   									<th>Tensión diastólica</th>
   									<th>Consumo agua (minutos)</th>
   									<th>Acelerómetro (m/s2)</th>
   									<th>Nivel CO (ppm)</th>
   									<th>Temperatura (ºC)</th>
   									<th>Nivel CO2 (ppm)</th>
								  </tr>
								 </thead>
								 
								 <tbody>
								
									<c:forEach items="${sensores}" var="sen">
									
										<tr class = "alt">
											
											<td><c:out value="${sen.fecha}" /></td>
											<c:choose>
												<c:when test="${(sen.pulsometro >= 60) and (sen.pulsometro <= 100)}">
													<td><c:out value="${sen.pulsometro}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.pulsometro}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.azucar >= 70) and (sen.azucar <= 130)}">
													<td><c:out value="${sen.azucar}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.azucar}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.oxigeno >= 90) and (sen.oxigeno <= 100)}">
													<td><c:out value="${sen.oxigeno}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.oxigeno}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.tension_sist >= 120) and (sen.tension_sist <= 140)}">
													<td><c:out value="${sen.tension_sist}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.tension_sist}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.tension_diast >= 80) and (sen.tension_diast <= 90)}">
													<td><c:out value="${sen.tension_diast}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.tension_diast}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(paciente.consumoAguaMedio + 25) >= sen.consumo_agua}">
													<td><c:out value="${sen.consumo_agua}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.consumo_agua}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${sen.acelerometro < 18}">
													<td><c:out value="${sen.acelerometro}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.acelerometro}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.CO >= 0.5) and (sen.CO <= 5)}">
													<td><c:out value="${sen.CO}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.CO}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.temperatura >= 36.1) and (sen.temperatura <= 37.2)}">
													<td><c:out value="${sen.temperatura}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.temperatura}" /></td>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${(sen.CO2 >= 350) and (sen.CO2 <= 5000)}">
													<td><c:out value="${sen.CO2}" /></td>
												</c:when>
												<c:otherwise>
													<td style="background-color: red;"><c:out value="${sen.CO2}" /></td>
												</c:otherwise>
											</c:choose>
											
										</tr>
									</c:forEach>
								
								</tbody>
 
							</table>
	        </div>      
		</div>
	</div>
	</div>
</body>
	
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/gestion_manag.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>iCare</title>
		
		<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDgXzT_XAnzMskOPHwgG2bNZi5Et1bSvU4&sensor=false&region=ES&callback=initialize"></script>
    <script>
		var map;
		var nrec = '${nrec}';
		var al_loc = '${al_loc}';
		var al_lat = '${al_lat}';
		var al_long = '${al_long}';
		var al_tlf = '${al_tlf}';
		
		
	
		function initialize() {
			
			if(nrec == 1){
				var loc0 = '${local0}';
				var lat0 = '${latitudes0}';
				var long0 = '${longs0}';
				var tlf0 = '${tlf0}';
				var tipo0 = '${tipo0}';
				var marcadores = [[al_loc, al_lat, al_long, al_tlf, "ALARMA"], [loc0, lat0, long0, tlf0, tipo0]];
			} else if (nrec == 2){
				var loc0 = '${local0}';
				var lat0 = '${latitudes0}';
				var long0 = '${longs0}';
				var tlf0 = '${tlf0}';
				var tipo0 = '${tipo0}';
				var tipo1 = '${tipo1}';
				var tlf1 = '${tlf1}';
				var loc1 = '${local1}';
				var lat1 = '${latitudes1}';
				var long1 = '${longs1}';
				var marcadores = [[al_loc, al_lat, al_long, al_tlf, "ALARMA"], [loc0, lat0, long0, tlf0, tipo0],[loc1, lat1, long1, tlf1, tipo1]];
			} else if (nrec == 3){
				var loc0 = '${local0}';
				var lat0 = '${latitudes0}';
				var long0 = '${longs0}';
				var tlf0 = '${tlf0}';
				var tlf1 = '${tlf1}';
				var tipo0 = '${tipo0}';
				var tipo1 = '${tipo1}';
				var tipo2 = '${tipo2}';
				var tlf2 = '${tlf2}';
				var loc1 = '${local1}';
				var lat1 = '${latitudes1}';
				var long1 = '${longs1}';
				var loc2 = '${local2}';
				var lat2 = '${latitudes2}';
				var long2 = '${longs2}';
				var marcadores = [[al_loc, al_lat, al_long, al_tlf, "ALARMA"], [loc0, lat0, long0, tlf0, tipo0],[loc1, lat1, long1, tlf1, tipo1],[loc2, lat2, long2, tlf2, tipo2]];
			} else if (nrec == 4){
				var loc0 = '${local0}';
				var lat0 = '${latitudes0}';
				var long0 = '${longs0}';
				var tlf0 = '${tlf0}';
				var tlf1 = '${tlf1}';
				var tlf2 = '${tlf2}';
				var tlf3 = '${tlf3}';
				var tipo0 = '${tipo0}';
				var tipo1 = '${tipo1}';
				var tipo2 = '${tipo2}';
				var tipo3 = '${tipo3}';
				var loc1 = '${local1}';
				var lat1 = '${latitudes1}';
				var long1 = '${longs1}';
				var loc2 = '${local2}';
				var lat2 = '${latitudes2}';
				var long2 = '${longs2}';
				var loc3 = '${local3}';
				var lat3 = '${latitudes3}';
				var long3 = '${longs3}';
				var marcadores = [[al_loc, al_lat, al_long, al_tlf, "ALARMA"], [loc0, lat0, long0, tlf0, tipo0],[loc1, lat1, long1, tlf1, tipo1],[loc2, lat2, long2, tlf2, tipo2],[loc3, lat3, long3, tlf3, tipo3]];
			}else if (nrec == 5){
				var loc0 = '${local0}';
				var lat0 = '${latitudes0}';
				var long0 = '${longs0}';
				var tlf0 = '${tlf0}';
				var tlf1 = '${tlf1}';
				var tlf2 = '${tlf2}';
				var tlf3 = '${tlf3}';
				var tipo0 = '${tipo0}';
				var tipo1 = '${tipo1}';
				var tipo2 = '${tipo2}';
				var tipo3 = '${tipo3}';
				var loc1 = '${local1}';
				var lat1 = '${latitudes1}';
				var long1 = '${longs1}';
				var loc2 = '${local2}';
				var lat2 = '${latitudes2}';
				var long2 = '${longs2}';
				var loc3 = '${local3}';
				var lat3 = '${latitudes3}';
				var long3 = '${longs3}';
				
				var loc4 = '${local4}';
				var lat4 = '${latitudes4}';
				var long4 = '${longs4}';
				var tlf4= '${tlf4}';
				var tipo4 = '${tipo4}';
				var marcadores = [[al_loc, al_lat, al_long, al_tlf, "ALARMA"], [loc0, lat0, long0, tlf0, tipo0],[loc1, lat1, long1, tlf1, tipo1],[loc2, lat2, long2, tlf2, tipo2],[loc3, lat3, long3, tlf3, tipo3],[loc4, lat4, long4, tlf4, tipo4]];
			}else{
				var loc0 = '${local0}';
				var lat0 = '${latitudes0}';
				var long0 = '${longs0}';
				var tlf0 = '${tlf0}';
				var tlf1 = '${tlf1}';
				var tlf2 = '${tlf2}';
				var tlf3 = '${tlf3}';
				var tipo0 = '${tipo0}';
				var tipo1 = '${tipo1}';
				var tipo2 = '${tipo2}';
				var tipo3 = '${tipo3}';
				var loc1 = '${local1}';
				var lat1 = '${latitudes1}';
				var long1 = '${longs1}';
				var loc2 = '${local2}';
				var lat2 = '${latitudes2}';
				var long2 = '${longs2}';
				var loc3 = '${local3}';
				var lat3 = '${latitudes3}';
				var long3 = '${longs3}';
				var loc4 = '${local4}';
				var lat4 = '${latitudes4}';
				var long4 = '${longs4}';
				var tlf4= '${tlf4}';
				var tipo4 = '${tipo4}';
				
				var loc5 = '${local5}';
				var lat5 = '${latitudes5}';
				var long5 = '${longs5}';
				var tlf5= '${tlf5}';
				var tipo5 = '${tipo5}';
				var marcadores = [[al_loc, al_lat, al_long, al_tlf, "ALARMA"], [loc0, lat0, long0, tlf0, tipo0],[loc1, lat1, long1, tlf1, tipo1],[loc2, lat2, long2, tlf2, tipo2],[loc3, lat3, long3, tlf3, tipo3],[loc4, lat4, long4, tlf4, tipo4],[loc5, lat5, long5, tlf5, tipo5]];
			
			}
			
		  	
		  var mapOptions = {
		    zoom: 12,
		    center: new google.maps.LatLng(al_lat, al_long)
		  };
		  var infowindow = new google.maps.InfoWindow();
		  map = new google.maps.Map(document.getElementById('map-canvas'),
		      mapOptions);
		  var marker, i;
		  for (i = 0; i < marcadores.length; i++) {
			  if(marcadores[i][4] == "Hospital"){
				  marker = new google.maps.Marker({
			  	        position: new google.maps.LatLng(marcadores[i][1], marcadores[i][2]),
			  	        icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
			  	        map: map  
			  	  });
			  }
			  else if (marcadores[i][4] == "Bomberos"){
				  marker = new google.maps.Marker({
			  	        position: new google.maps.LatLng(marcadores[i][1], marcadores[i][2]),
			  	        icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png',
			  	        map: map  
			  	  });
			  }
			  else if (marcadores[i][4] == "Sociales"){
				  marker = new google.maps.Marker({
			  	        position: new google.maps.LatLng(marcadores[i][1], marcadores[i][2]),
			  	        icon: 'http://maps.google.com/mapfiles/ms/icons/yellow-dot.png',
			  	        map: map  
			  	  });
			  }
			  else {
				  marker = new google.maps.Marker({
				        position: new google.maps.LatLng(marcadores[i][1], marcadores[i][2]),
				        map: map
				  });
			  }
		      
		      google.maps.event.addListener(marker, 'click', (function(marker, i) {
		          return function() {
		            infowindow.setContent('<p>'+marcadores[i][0]+'</p>'+'<p>Teléfono: '+marcadores[i][3]+'</p>');
		            infowindow.open(map, marker);
		          }
		        }) (marker, i));
		    }
		  
		}
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
		
		<script type = "text/javascript">
			function paciente(boton){
			    if (confirm('¿Estas seguro de querer llamar al paciente?')){
			       var id = '${id_al}';
			       let decision = boton.id;
			       window.location = "/save_alarm?id="+id+"&dec="+decision;
			    }
			} 
			
			function cont_paciente(boton){
			    if (confirm('¿Estas seguro de querer llamar al contacto del paciente?')){
			       var id = '${id_al}';
			       let decision = boton.id;
			       window.location = "/save_alarm?id="+id+"&dec="+decision;
			    }
			} 
			
			function emerg(boton){
			    if (confirm('¿Estas seguro de querer llamar a emergencias (112)?')){
			       var id = '${id_al}';
			       let decision = boton.id;
			       window.location = "/save_alarm?id="+id+"&dec="+decision;
			    }
			} 
			
			function chat(boton){
			    if (confirm('¿Estas seguro de querer iniciar un chat?')){
			       var id = '${id_al}';
			       let decision = boton.id;
			       window.location = "/save_alarm?id="+id+"&dec="+decision;
			    }
			} 
			
			function bomberos(boton){
			    if (confirm('¿Estas seguro de querer llamar a los bomberos?')){
			       var id = '${id_al}';
			       let decision = boton.id;
			       window.location = "/save_alarm?id="+id+"&dec="+decision;
			    }
			} 
			function personal(boton){
			    if (confirm('¿Estas seguro de querer llamar al personal sociosanitario?')){
			       var id = '${id_al}';
			       let decision = boton.id;
			       window.location = "/save_alarm?id="+id+"&dec="+decision;
			    }
			} 
		</script>
		
	</head>
	
	<body>
	
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
	  	
	  	<div id="acciones">
	  	
	  			<button type="submit" onclick="paciente(this)" id="1" class="bloque">Llamar paciente</button>
				<button type="submit" onclick="cont_paciente(this)" id="2" class="bloque">Llamar contacto del paciente</button>
				<button type="submit" onclick="emerg(this)" id="3" class="bloque">Llamar Emergencias</button>
				<button type="submit" onclick="chat(this)" id="4" class="bloque">Iniciar chat</button>
				<button type="submit" onclick="bomberos(this)" id="5" class="bloque">Llamar bomberos</button>
				<button type="submit" onclick="personal(this)" id="6" class="bloque">Llamar personal sociosanitario</button>
	    	
    			
   			
		</div>
		
		<div id="map-canvas" style="height:300px; width:300px"></div>
		
		<form method = "post" action="/alarmcontact_management?id=${pac.id}">
			<div id="nav">	
				<button class="boton_nav" type="submit" id="info" name = "info" value = "info" class="current"><span>Información personal</span></button>
				<button class="boton_nav" type="submit" id="alan" name = "alan" value = "alan"><span>Alarmas y anomalías</span></button>
				<button class="boton_nav" type="submit" id="cont" name = "cont" value = "cont"><span>Contactos</span></button>
				<button class="boton_nav" type="submit" id="sens" name = "sens" value = "sens"><span>Datos sensores</span></button>
		   </div>
	   </form>
	   <c:if test="${info == true }">
			<div class="datos" >
				
				<table>
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
	   </c:if>
	   
	   <c:if test="${alan == true }">
	   		<div class="datos" >
				
				<div id="subseccion">
					<div class="info_cabecera">
						<p>Alarmas</p>
					</div>
					<div class="foto_cabecera">
						<p>Anomalias</p> 
					</div>
				</div>
				
				<div id="subseccion">
					<div class="info_cabecera">
						<table>
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
	   </c:if>
	   
	   <c:if test="${cont == true }">
	   		<div class="datos" >
				
				<div id="subseccion">
					<div class="info_cabecera">
						<p>Familiares</p>
					</div>
					<div id="encabezado_cui" class="foto_cabecera">
						<p>Cuidador</p> 
					</div>
				</div>
				<div id="subseccion">
					<div class="info_cabecera">
						<table>
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
					<div id="contacto_cui" class="foto_cabecera">
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
	   </c:if>
	   
	   <c:if test="${sens == true }">
	   		<div class="datos" >
				<table>
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
	   </c:if>
		
			
	</body>
	
</html>
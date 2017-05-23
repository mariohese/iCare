<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="css/admin.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>iCare</title>
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
	       			<p id="username"><c:out value="${usuario}"/></p>
	       		</div>
	       		<div id = "salir"> 
					<a id= "sal" class="boton_peq" href='/'>Log Out</a>	
				</div>
	       	</div>
	  	</div>
	  	
		<div id="operadores">
		<div class='cssmenu'>
			<form action="/admin" method="post"> 
					<button type="submit" class="boton" name="crear_op" id="crear_op" value="crear_op">Crear Operador</button>		
					<button type="submit" class="boton" name="borrar_op" id="borrar_op" value="borrar_op">Eliminar Operador</button>
					
			</form>
			
			<!--  <ul>
							<input type="hidden" name="crear" id="crear" value="crear">
			
			  <li class='active has-sub'><a href='/admin'><span>Crear</span></a></li>
			  <input type="text" id="operador" name="operador" placeholder="operador" />
			  <li class='has-sub'><a href='/admin'><span>Borrar</span></a></li>
			</ul> -->
		</div>
		
		<c:if test="${sinclickar == true }">
				<c:if test="${empty logins_sin}">
				<div class="cuerpo_izq_vac">
				<p>No hay operadores registrados en el sistema</h2>
				</div>
				</c:if>
				
				<c:if test="${not empty logins_sin}">
		
					<div class="cuerpo_izq">
		                <!--<form action="/deleteop" method="post"> -->
							<h2 class="encabezado" >Operadores registrados</h2>
							<table>
									<c:forEach items="${logins_sin}" var="login">
										<tr class = "alt">
											<td><div class="fila"><c:out value="${login.user}" /></div></td>
										</tr>
									</c:forEach>
							</table>
							
							<br>
							<br>
							
								  
						<!--</form>-->
		     		 </div><!--fin cuerpo-->
		      </c:if>
	      </c:if>
		
		<c:if test="${formulario_op == true }">
			<div class="cuerpo_izq">
		                <form action="/createop" method="post"> 
	
							<input type="text" id="name" name="name" placeholder="Nombre operador" />
							<br>
							<input type="text" id="passwd" name="passwd" placeholder="Introduzca su contraseña" />
							<br>
							<button type="submit" class="terminar" >Crear</button>
							<br>
							<br>
								  
						</form>
		      </div><!--fin cuerpo-->
	      </c:if>
	      
	      <c:if test="${lista_op == true }">
	      	<c:if test="${empty logins}">
				<div class="cuerpo_izq_vac">
				<p>No hay operadores registrados en el sistema</h2>
				</div>
			</c:if>
	      	<c:if test="${not empty logins}">
				<div class="cuerpo_izq">
		                <!--<form action="/deleteop" method="post"> -->
							<h2 class="enccabezado">Operadores registrados</h2>
							<table>
									<c:forEach items="${logins}" var="login">
										<tr class = "alt">
											<td><c:out value="${login.user}" /></td>
											<td><div class="fila"><a class="boton_peq" href='/deleteop?id=${login.id}'><span>Eliminar</span></a></div></td>
										</tr>
									</c:forEach>
							</table>
							<br>
							<br>
								  	
								  
						<!--</form>-->
		      	</div><!--fin cuerpo-->
		      	
		      </c:if>
	      </c:if>
	      <br>
		  <br>
		  </div>
		  <div id="pacientes">
		  <div class="cssmenu">
	      <form action="/admin" method="post"> 
				<button type="submit" class="boton" name="crear_pac" id="crear_pac" value="crear_pac">Crear Paciente</button>
				<button type="submit" class="boton" name="borrar_pac" id="borrar_pac" value="borrar_pac">Eliminar Paciente</button> 
		  </form>
		  </div>
		  <c:if test="${sinclickar == true }">
		  	<c:if test="${empty pacs_sin}">
				<div class="cuerpo_izq_vac">
				<p>No hay pacientes registrados en el sistema</h2>
				</div>
			</c:if>
		  	<c:if test="${not empty pacs_sin}">
				<div class="cuerpo_izq">
		                <!--<form action="/deleteop" method="post"> -->
	
							<h2>Pacientes registrados</h2>
							 <table>
								<c:forEach items="${pacs_sin}" var="pac">
									<tr class = "alt">
											<td><div class="fila"><c:out value="${pac.paciente}" /></div></td>
									</tr>
								</c:forEach>
							</table>
								  
						<!--</form>-->
		      	</div><!--fin cuerpo-->
		      </c:if>
	      </c:if>
	      
	      <c:if test="${formulario_pac == true }">
			<div class="cuerpo_der">
		                <form action="/createpac" method="post"> 
							<div id="form_1">
							<h3>Información personal</h3>
							<input type="text" id="name" name="name" placeholder="Nombre paciente" />
							<br>
							<input type="text" id="apell" name="apell" placeholder="Apellidos paciente" />
							<br>
							<input type="text" id="edad" name="edad" placeholder="Edad" />
							<br>
							<input type="text" id="nac" name="nac" placeholder="Fecha nacimiento: dd/mm/yy" />
							<br>
							<input type="text" id="dni" name="dni" placeholder="DNI" />
							<br>
							<input type="text" id="nuss" name="nuss" placeholder="NUSS" />
							<br>
							<input type="text" id="dir" name="dir" placeholder="Dirección" />
							<br>
							<input type="text" id="ciudad" name="ciudad" placeholder="Ciudad" />
							<br>
							<input type="text" id="cp" name="cp" placeholder="Código postal" />
							<br>
							<input type="text" id="est" name="est" placeholder="Estado civil" />
							<br>
							<input type="text" id="enf" name="enf" placeholder="¿Alguna enfermedad?" />
							<br>
							<input type="text" id="disc" name="disc" placeholder="¿Alguna discapacidad?" />
							<br>
							<input type="text" id="vive" name="vive" placeholder="¿Vive solo?" />
							<br>
							<input type="text" id="agua" name="agua" placeholder="¿Consumo medio agua ducha?" />
							<br>
							</div>
							<div id="form_2">
							<h3>Contactos de emergencia</h3>
							<input type="text" id="nombcuid" name="nombcuid" placeholder="Nombre cuidador" />
							<br>
							<input type="text" id="apllcuid" name="apllcuid" placeholder="Apellidos cuidador" />
							<br>
							<input type="text" id="tlfcuid" name="tlfcuid" placeholder="Teléfono cuidador" />
							<br>
							<input type="text" id="nombfam" name="nombfam" placeholder="Nombre familiar" />
							<br>
							<input type="text" id="apllfam" name="apllfam" placeholder="Apellidos familiar" />
							<br>
							<input type="text" id="tlffam" name="tlffam" placeholder="Teléfono familiar" />
							<br>
							</div>
							<div class="terminar">
							<button type="submit" id="terminar_der">Crear</button>
							<br>
							</div>  
						</form>
		      </div><!--fin cuerpo-->
	      </c:if>
	      
	      <c:if test="${lista_pac == true }">
	      	<c:if test="${empty pacs}">
	      		<div class="cuerpo_izq_vac">
				<p>No hay pacientes registrados en el sistema</h2>
				</div>
			</c:if>
	     	<c:if test="${not empty pacs}">
				<div class="cuerpo_izq">
		                <!--<form action="/deleteop" method="post"> -->
							<h2>Pacientes registrados</h2>
							<table>
								<c:forEach items="${pacs}" var="pac">
									<tr class = "alt">
											<td><c:out value="${pac.paciente}" /></td>
											<td><div class="fila"><a class="boton_peq" href='/deletepac?id=${pac.id}'><span>Eliminar</span></a></div></td>
									</tr>
								</c:forEach>
							</table>
								  	
								  
						<!--</form>-->
		      	</div><!--fin cuerpo-->
		      </c:if>
	      </c:if>
	      </div>
	  

	</body>
	
</html>
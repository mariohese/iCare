<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>iCare</title>
	</head>
	
	<body>
	
		<form action="/generator" method="post">
				<button type="submit" name="esc3" id="esc3" value="esc3">Generar Escenario 1</button> 
				<button type="submit" name="esc4" id="esc4" value="esc4">Generar Escenario 2</button>
				<button type="submit" name="esc2" id="esc2" value="esc2">Generar Escenario 3</button>
				<button type="submit" name="sos" id="sos" value="sos">Generar Escenario 4</button>
				
				<!--  <button type="submit" name="inicio" id="inicio" value="inicio" style="float:right;">Iniciar Recursos</button>		-->
		</form>
	
		<br>
		<br>
		<p><strong><u>Escenario 1:</u> </strong>se reciben los datos de todos los sensores de cada uno de los pacientes.</p>
		<p><strong><u>Escenario 2:</u> </strong>se reciben tres medidas anómalas, tomadas en tres tiempos seguidos, de uno de los sensores del paciente, por lo que se genera una alarma.</p>
		<p><strong><u>Escenario 3:</u> </strong>se recibe una anomalía generada en los sensores de un paciente y una alarma de otro, en diferentes tiempos, primero la anomalía y después la alarma.</p>
		<p><strong><u>Escenario 4:</u> </strong>se recibe una alarma de botón de SOS.</p>
	
	
	</body>
	
</html>
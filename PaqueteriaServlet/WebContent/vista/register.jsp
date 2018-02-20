<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Artículo</title>
</head>
<body>
	<h1>Registrar Artículo</h1>
	<form action="adminArticulo?action=register" method="post">
		<table border="1" align="center">
		<tr>
			<td>id:</a></td>		
			<td><input type="text" name="id"/></td>	
		</tr>
		<tr>
			<td>origen</td>
			<td><jsp:include page="_googlemaps.jsp"></jsp:include><td>
		</tr>
		<tr>
			<td>paquete:</a></td>		
			<td><input type="text" name="paquete"/></td>	
		</tr>
		<tr>
			<td>fecha:</a></td>		
			<td><input type="Date" name="fecha"/></td>	
		</tr>
		<tr>
			<td>Remitente:</a></td>		
			<td><input type="text" name="remitente"/></td>	
		</tr>
		<tr>
			<td>transportista:</a></td>		
			<td><input type="text" name="transportista"/></td>	
		</tr>
		<tr>
			<td>Precio:</a></td>		
			<td><input type="text" name="precio"/></td>	
		</tr>		
		
	</table>
	<br>
	<table border="0" align="center">
		<tr>
		<td><input type="submit" value="Agregar" name="agregar"></td>	
		</tr>
	
	</form>
</body>
</html>
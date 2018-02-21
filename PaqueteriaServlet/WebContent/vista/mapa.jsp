<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Mapa</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
</head>
<body>
	<iframe width="600" height="450" frameborder="0" style="border: 0"
		src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyCKtPhLTpAp84VaOouOpfYpNII05UvbVK8
		  &origin=<%=request.getParameter("origen")%>&destination=<%=request.getParameter("destino")%>&avoid=tolls|highways">
	</iframe>
</body>
</html>
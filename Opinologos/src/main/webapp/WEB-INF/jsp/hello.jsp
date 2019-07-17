<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello ${name}!</title>
<link href="/static/css/main.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="bannerSuperior.jsp"></jsp:include>

	<br>
	<div class="container">
		<a class="boton" href="/hello">homee!</a><br>
		<p class="hello-title">Hello Opinologo!
	</div>
	<br>
	<br> usuario: ${pageContext.request.userPrincipal.name}
	<br>
	<div align="right">
		<a class="blue" href="/login">Log in</a> <a class="blue"
			href="/registro">Sing up</a>
	</div>
</body>
<div></div>
</html>
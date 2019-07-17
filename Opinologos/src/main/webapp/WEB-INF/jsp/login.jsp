<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OPINIOLOGOS</title>
<link href="/static/css/main.css" rel="stylesheet">
</head>

<body>
	<br>
	<jsp:include page="bannerSuperior.jsp"></jsp:include>

	<br>
	<div class="container">
		<a class="boton" href="/hello">homee!</a>
	</div>
	<br>
	<div>
		<form action="/login" method="POST">
			<div>
				<input type="text" placeholder="username" id="username"
					name="username">USERNAME<br> <input type="password"
					placeholder="password" id="password" name="password">PASSWORD<br>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<button type="submit">Log in</button>
			</div>

		</form>

		<c:if test="${validacion}">
			<p>${mensaje}!!!
		</c:if>
	</div>

</body>
</html>
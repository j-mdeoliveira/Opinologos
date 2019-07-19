<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OPINIOLOGOS</title>
 <link href="/static/css/main.css" rel="stylesheet">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type="text/javascript">

	window.onload = validateForm;
	
	function validateForm(){
		if(""!="${error}"){
			alert("usuario o contraseña incorrectos");
		return false;
	}
}
</script>

</head>

<body>
<jsp:include page="navbar.jsp"></jsp:include><br>
<br>

<jsp:include page="bannerSuperior.jsp"></jsp:include>

<br>

<div>
<form action="/login" method= "POST">
	<div>
	<input type="text" placeholder="username" id="username" name="username">USERNAME<br>
	<input type="password" placeholder="password" id="password" name="password">PASSWORD<br>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button type="submit">Log in</button>
	</div>
	
</form>
${error}
<c:if test="${error}">
<p>${noLog}!!!
</c:if>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>

<title>Getting Started: Serving Web Content</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
 <style>
		.signUp {
    	background-color: #f1f1f1;
    	padding: 0.01em 16px;
    	margin: 20px 0;
    	box-shadow: 0 2px 4px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12)!important;
	}
	</style>
<link href="/static/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

	<div class=signUp style="justify-content: center; align-items: center;">
	<form:form method="POST" modelAttribute="userForm" class="register-form" id="login-form">
		<form action="/signup" method="post">
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input class="form-control" name="name" placeholder="Nombre">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword3" class="col-sm-2 col-form-label">Nick</label>
				<div class="col-sm-10">
					<input class="form-control" name="userName" placeholder="Nick">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="inputEmail3"
						name="mail" placeholder="Email">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="inputPassword3" class="col-sm-2 col-form-label">Contraseña</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password"
						placeholder="Contraseña">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword3" class="col-sm-2 col-form-label">Repita
					su contraseña</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="passAgain"
						placeholder="Contraseña">
				</div>
			</div>

			<div class="form-group row">
				<div class="btn-group">
					<div class="col-sm-7">
						<button type="submit" class="btn btn-block btn-primary" class="form-submit">Crear Cuenta</button>
					</div>
					<div class="col-sm-7">
						<button class="btn btn-info">Log in</button>
					</div>
				</div>
			</div>
			</form:form>
	</div>

	<c:if test="${noIguales}">
		<p>Las contraseñas tienen que coincidir<p>
	</c:if>
	<c:if test="${nickIguales}">
		<p>
			El nick ya esta tomado
			<p>
      
	</c:if>
	 <c:if test="${mailIguales}">
         <p>Ya se registro un usuario con ese mail<p>
      
	</c:if>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		</body>
</html>
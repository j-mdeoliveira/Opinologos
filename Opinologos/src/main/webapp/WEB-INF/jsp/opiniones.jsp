<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/static/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include><br>
<br>
<jsp:include page="bannerSuperior.jsp"></jsp:include><br>
<br>
	<div class="container row">
		<c:forEach items="${userLogueado.opiniones}" var="op">
			<div class="card col-3" method="get" action="/opiniones">
				<div align="center">
					<img src="https://www.w3schools.com/howto/img_avatar2.png" class="center" height=100 width=100 >
				</div>
  				<div class="card-body">
    				<h5 class="card-title">
    					<b>${op.titulo}</b>
						<b> - </b>
						<b>${op.fechaCreacion}</b>
					</h5>
    				<p class="card-text">${op.detalle} </p>
    				<p class="card-text">Escrita por: ${op.user.userName} </p>
    				<c:if test="${noPuntuacion}">
    					No tiene puntuacion todavia.
    				</c:if>
    				<c:if test="${!noPuntuacion}">
    					<p class="card-text">Puntuacion promedio: ${op.reacciones} </p>
    				</c:if>  		
    				
    				<sec:authorize access="hasAuthority('MODERADOR')">
						<label><input type="checkbox" id="bloquear" name="bloquear" value="first_checkbox">Bloquear opinion</label><br>
					</sec:authorize>		

					<button type="submit" class="btn btn-block btn-primary" class="form-submit">MG</button>    				
					<c:if test="${op.blockeada}">
						${op.id}						
    					<a href="/edicionopinion" class="btn btn-block btn-primary" role="button" aria-pressed="true">Editar Opinion</a>
					</c:if>    				
  				</div>
  			</div>
		</c:forEach>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
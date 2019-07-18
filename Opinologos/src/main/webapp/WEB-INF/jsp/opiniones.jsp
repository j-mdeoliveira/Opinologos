<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/static/css/main.css" rel="stylesheet">
<style type="text/css">
.card {
	/* Add shadows to create the "card" effect */
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

/* Add some padding inside the card container */
.container {
	padding: 2px 16px;
}

.ec-stars-wrapper {
	/* Espacio entre los inline-block (los hijos, los `a`) 
	   http://ksesocss.blogspot.com/2012/03/display-inline-block-y-sus-empeno-en.html */
	font-size: 0;
	/* Podríamos quitarlo, 
		pero de esta manera (siempre que no le demos padding), 
		sólo aplicará la regla .ec-stars-wrapper:hover a cuando
		también se esté haciendo hover a alguna estrella */
	display: inline-block;
}
.ec-stars-wrapper a {
	text-decoration: none;
	display: inline-block;
	/* Volver a dar tamaño al texto */
	font-size: 32px;
	font-size: 2rem;
	
	color: #888;
}

.ec-stars-wrapper:hover a {
	color: rgb(39, 130, 228);
}
/*
 * El selector de hijo, es necesario para aumentar la especifidad
 */
.ec-stars-wrapper > a:hover ~ a {
	color: #888;
}
</style>
</head>
<body>

	<div class="card" method="get" action="/opiniones" style="width: 50%">
		<c:forEach items="${userLogueado.opiniones}" var="op">
			<img src="https://www.w3schools.com/howto/img_avatar2.png"
				alt="Avatar" style="width: 100%">
			<div class="container">
				<h4>
					<b>${op.titulo}</b>
					<b> - </b>
					<b>${op.fechaCreacion}</b>
				</h4>
				<p>${op.detalle}</p>
				<button type="submit" class="btn btn-block btn-primary"
					class="form-submit">MG</button>
			</div>
			
			<c:if test="${op.blockeada}">
				${op.id}
    			<a href="/edicionopinion" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Editar Opinion</a>
			</c:if>
			
		</c:forEach>

	</div>

	<script>
		/* When the user clicks on the button, 
		 toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}
	</script>
</body>
</html>
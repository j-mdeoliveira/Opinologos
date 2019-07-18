<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
<!DOCTYPE html>
<html>
 <head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>


<jsp:include page="bannerSuperior.jsp"></jsp:include>

<%-- <c:if test="${adminValidator}"> --%>
<!-- <div align= "right" class="container"> -->
<!-- 	<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups"> -->
<!--   		<div   class="btn-group mr-2" role="group" aria-label="First group"> -->
<!--     	<a href="/login" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Log in</a> -->
<!-- 		<a href="/signup" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Sign up</a> -->
<!-- 		<a href="/opinar" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Opinar</a> -->
<!-- 		<a href="/opiniones" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Opiniones</a> -->
<!--     	<a href="/usuarios" class="btn btn-warning btn-lg active" role="button" aria-pressed="true">Usuarios</a> -->
<!-- 		<a href="/profile" class="btn btn-warning btn-lg active" role="button" aria-pressed="true">Perfil</a> -->
<!--     	<a href="#" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Log out</a> -->
<!--     	</div> -->
    	
    	
<!-- 	</div> -->
<!-- </div> -->

<%-- </c:if> --%>


${opiniones}
<c:forEach items="${usuarioLogueado.opiniones}" var="opi">
<div class="container row">
	<div class="card col-3" style="width: 18rem;">
  	<img src="..." class="card-img-top" alt="...">
  		<div class="card-body">
    		<h5 class="card-title">${opi.titulo} </h5>
    		<p class="card-text">${opi.detalle} </p>
    		<a href="#" class="btn btn-primary">Go somewhere</a>
  		</div>
	</div>
</div>
		
   </c:forEach>
</body>
</html>
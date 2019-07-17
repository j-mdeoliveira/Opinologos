<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

user: ${usuarioLogueado.userName}<br>
Mis perfiles: 
	<c:forEach items="${usuarioLogueado.roles}" var="rol">
		${rol} -
   </c:forEach>

<div align= "right" class="container">
	<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
  		<div   class="btn-group mr-2" role="group" aria-label="First group">
    	<a href="/login" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Log in</a>
		<a href="/signup" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Sign up</a>
		<a href="/opinar" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Opinar</a>
		<a href="/opiniones" class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Opiniones</a>
    	<a href="/usuarios" class="btn btn-warning btn-lg active" role="button" aria-pressed="true">Usuarios</a>
		<a href="/profile" class="btn btn-warning btn-lg active" role="button" aria-pressed="true">Perfil</a>
    	<a href="#" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Log out</a>
    	</div>
    	
    	
	</div>
</div>
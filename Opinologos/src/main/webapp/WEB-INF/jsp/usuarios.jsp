<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sec:authorize access="hasAuthority('ADMINISTRADOR') or hasAuthority('MODERADOR')">
<c:forEach items="${todos}" var="user" >
${user.name}<br>
${user.getUserName()}<br>
${user.roles}<br>
${user.mail}<br>
///////////////////////////<br>
<button onClick='<c:url value="/login" />'>Editar Usuario</button><br>
</c:forEach>
PUEDES VER LOS USERS PORQUE ERES UN ADMIN
</sec:authorize>
<sec:authorize access="hasAuthority('SOCIO') && !hasAuthority({'ADMINISTRADOR','MODERADOR'})">
NO DEBERÍAIS ESTAR EN ESTA pÁGINA <a href="/login">regresa al login para authorization</a>
</sec:authorize>
</body>
</html>
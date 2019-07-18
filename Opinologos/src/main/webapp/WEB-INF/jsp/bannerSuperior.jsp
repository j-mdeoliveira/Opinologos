<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- user: ${usuarioLogueado.userName}<br> --%>
<%-- esAdmin: ${adminValidator};  --%>
<%-- log: ${logueado} --%>
<!-- Mis perfiles:  -->
<%-- 	<c:forEach items="${usuarioLogueado.roles}" var="rol"> --%>
<%-- 		${rol.role} - --%>
<%--    </c:forEach> --%>

<c:if test="${!logueado}">
	<div class="container d-flex flex-row-reverse">
		<a href="/login" class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">Log in</a> 
		<a href="/signup"class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">Sign up</a>
	</div>
</c:if>


<c:if test="${logueado}">

	<div align="right" class="container d-flex flex-row-reverse">
		<div class="btn-toolbar" role="toolbar"
			aria-label="Toolbar with button groups">
			<div align="right" class="btn-group mr-2" role="group"
				aria-label="First group">
				<div>
					<a href="/opinar" class="btn btn-danger btn-lg active"
						role="button" aria-pressed="true">Opinar</a>
				</div>
				<div>
					<a href="/opiniones" class="btn btn-danger btn-lg active"
						role="button" aria-pressed="true">Opiniones</a>
				</div>
				<div>
					<c:if test="${adminValidator}">
						<a href="/usuarios" class="btn btn-warning btn-lg active"
							role="button" aria-pressed="true">Usuarios</a>
					</c:if>
				</div>
				<div>
					<a href="/profile" class="btn btn-warning btn-lg active"
						role="button" aria-pressed="true">Perfil</a>
				</div>
				<div>
					<form action=<c:url value="/logout" /> method="POST">
						<button type="submit" class="btn btn-secondary btn-lg active"
							name="Logout" role="button" aria-pressed="true">Logout</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
	</div>
</c:if>





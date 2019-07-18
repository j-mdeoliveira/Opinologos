<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include><br>
<br>
<form action="/opinar" method="post">
  <div class="form-group">
    <label for="exampleFormControlInput1">Título</label>

    <input type="text" class="form-control" id="titulo"  name= "titulo" placeholder="piensa en un buen título">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Reseña</label>
    <textarea class="form-control" id="detalle" name="detalle" rows="3"></textarea>
  </div>
  <div class="col-sm-7">
		<button type="submit" class="btn btn-block btn-primary" class="form-submit">Opinar</button>
  </div>
</form>
</body>
</html>
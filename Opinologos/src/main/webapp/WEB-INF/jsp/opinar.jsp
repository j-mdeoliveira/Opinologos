<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include><br>
<br>
<form:form action="/opinar" method="post">
  <div class="form-group">
    <label for="exampleFormControlInput1">T�tulo</label>

    <input type="text" class="form-control" id="titulo"  name= "titulo" placeholder="piensa en un buen t�tulo">
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Rese�a</label>
    <textarea class="form-control" id="detalle" name="detalle" rows="3"></textarea>
  </div>
  <div class="col-sm-7">
		<button type="submit" class="btn btn-block btn-primary" class="form-submit">Opinar</button>
  </div>
</form:form>
</body>
</html>
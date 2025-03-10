<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>

<ul>
	<c:forEach items="${productos}" var="p">
		<li>${p.nombre} ${p.precio}</li>
	</c:forEach>
</ul>

</body>
</html>
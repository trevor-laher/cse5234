<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="item" items="${request.getSession().getAttribute("order")}">
    <c:out value="Name: ${item.getName()}\n"/> 
    <c:out value="Price: ${item.getPrice()}\n"/> 
    <c:out value="Quantity: ${item.getQuantity()}\n"/> 
</c:forEach>
</body>
</html>
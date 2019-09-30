<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Order</title>
</head>
<body>
<table style="width:100%; border: 1px solid black">
	<tr><th>Order</th></tr>
<c:forEach var="item" items="${order.getItems()}">
	<tr><td><c:out value="Name: ${item.getName()}"/></td></tr>
	<tr><td><c:out value="Price: ${item.getPrice()}"/></td></tr>
	<tr><td><c:out value="Quantity: ${item.getQuantity()}"/></td></tr>
</c:forEach>
</table>
<form:form modelAttribute="order" method="post" action="confirmOrder">
<input type="submit" value="Purchase">
</form:form>
</body>
</html>
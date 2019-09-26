<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="item" items="${order.getItems()}">
    <c:out value="Name: ${item.getName()}\n"/> 
    <c:out value="Price: ${item.getPrice()}\n"/> 
    <c:out value="Quantity: ${item.getQuantity()}\n"/> 
</c:forEach>
<form:form modelAttribute="order" method="post" action="confirmOrder">
<input type="submit" value="Purchase">
</form:form>
</body>
</html>
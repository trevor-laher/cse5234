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
BLABLABLA
<c:set var = "payment" scope = "session" value = "${payment}"/>
<c:set var = "shipping" scope = "session" value = "${shipping}"/>

<c:out value = "${payment.getCcNumber()}"/>
<c:out value = "${payment.getExpiration()}"/>
<c:out value = "${payment.getCvvCode()}"/>
<c:out value = "${payment.getCardName()}"/>

<c:out value="${shipping.getName()}"/>
<c:out value="${shipping.getAddressLine1()}"/>
<c:out value="${shipping.getAddressLine2()}"/>
<c:out value="${shipping.getCity()}"/>
<c:out value="${shipping.getState()}"/>
<c:out value="${shipping.getZip()}"/>
BLABLABLA
</body>
</html>
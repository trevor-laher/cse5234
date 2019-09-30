<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
</head>
<body>
<jsp:include page="Header.jsp" />
<c:forEach var="item" items="${order.getItems()}">
    <c:out value="Name: ${item.getName()}\n"/> 
    <c:out value="Price: ${item.getPrice()}\n"/> 
    <c:out value="Quantity: ${item.getQuantity()}\n"/> 
</c:forEach>

<table style="width:100%; border: 1px solid black">
	<tr><td><div> Thank You <c:out value="${shipping.getName()}"/> for your order.</div></td></tr>
	<div> </div>
	<c:set var = "payment" scope = "session" value = "${payment}"/>
	<c:set var = "shipping" scope = "session" value = "${shipping}"/>

	<tr><td><div>Please Confirm that your payment info for <c:out value = "${payment.getCardName()}"/> is correct:</div></td></tr>
	<tr><td><div>Credit Card Number: <c:out value = "${payment.getCcNumber()}"/></div></td></tr>
	<tr><td><div>Expiration Date: <c:out value = "${payment.getExpiration()}"/></div></td></tr>
	<tr><td><div>CVV: <c:out value = "${payment.getCvvCode()}"/></div></tr>


	<tr><td><div>Your Order will be shipped to: <c:out value="${shipping.getName()}"/> , <c:out value="${shipping.getAddressLine1()}"/>, <c:out value="${shipping.getAddressLine2()}"/>
	<c:out value="${shipping.getCity()}"/>, <c:out value="${shipping.getState()}"/>, <c:out value="${shipping.getZip()}"/></div></td></tr>
</table>
<jsp:include page="Footer.jsp" />
</body>
</html>
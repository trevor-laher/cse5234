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
<div> Thank You <c:out value="${shipping.getName()}"/> for your order.</div>
<div> </div>
<c:set var = "payment" scope = "session" value = "${payment}"/>
<c:set var = "shipping" scope = "session" value = "${shipping}"/>

<div>Please Confirm that your payment info for <c:out value = "${payment.getCardName()}"/> is correct:</div>
<div>Credit Card Number: <c:out value = "${payment.getCcNumber()}"/></div>
<div>Expiration Date: <c:out value = "${payment.getExpiration()}"/></div>
<div>CVV: <c:out value = "${payment.getCvvCode()}"/></div>
<div> </div>

<div>Your Order will be shipped to: <c:out value="${shipping.getName()}"/> , <c:out value="${shipping.getAddressLine1()}"/>, <c:out value="${shipping.getAddressLine2()}"/>
<c:out value="${shipping.getCity()}"/>, <c:out value="${shipping.getState()}"/>, <c:out value="${shipping.getZip()}"/></div>


</body>
</html>
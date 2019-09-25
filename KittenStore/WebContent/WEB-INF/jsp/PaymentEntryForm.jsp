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

<form:form modelAttribute="order" method="post" action="purchase/submitPayment">
	<table style="width:100%; border: 1px solid black">
		<c: payInf = "${PaymentInfo}"></c:>
		<tr>
			<td>Credit Card Number</td>
			<td><form:input path="payInf.ccNumber" /></td>
		</tr>
		<tr>
			<td>Expiration</td>
			<td><form:input path="payInf.expiration" /></td>
		</tr>
		<tr>
			<td>CVV</td>
			<td><form:input path="payInf.cvvCode" /></td>
		</tr>
		<tr>
			<td>Card Name</td>
			<td><form:input path="payInf.cardName" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>
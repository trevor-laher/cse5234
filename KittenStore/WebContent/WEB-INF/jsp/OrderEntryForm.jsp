<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>

<jsp:include page="Header.jsp" />
<h1><%= request.getSession().getAttribute("error") %></h1>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">
    <table style="width:100%; border: 1px solid black">
    	<tr>
    		<th>Item Name</th>
    		<th>Price</th>
    		<th>Quantity</th>
    	</tr>
	<c:forEach items="${order.lineItems}" var="item" varStatus="loop">
		<tr>
			<td><form:input path="items[${loop.index}].itemName" readonly="true" /></td>
			<td>$<form:input path="items[${loop.index}].price" readonly="true" /></td>
			<td><form:input path="items[${loop.index}].quantity" /></td>
			
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="2"><input type="submit" value="Purchase"></td>
	  </tr>
	

    </table>
</form:form>
<jsp:include page="Footer.jsp" />
</body>
</html>
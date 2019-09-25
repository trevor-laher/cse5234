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
<form:form modelAttribute="shipping" method="post" action="purchase/submitShipping">
    <table style="width:100%; border: 1px solid black">
    	<td>Name: <form:input path="shipping.name" readonly="true" /></td>
    	<td>AddressLine 1: <form:input path="shipping.addressLine1" readonly="true" /></td>
    	<td>AddressLine 2:<form:input path="shipping.addressLine2" readonly="true" /></td>
    	<td>City: <form:input path="shipping.city" readonly="true" /></td>
    	<td>State: <form:input path="shipping.state" readonly="true" /></td>
    	<td>Zip: <form:input path="shipping.zip" readonly="true" /></td>
    </table>
</form:form>

</body>
</html>
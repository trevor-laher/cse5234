<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<link href="${pageContext.request.contextPath}/CSS/mystyle.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="Header.jsp"/>
<h1>Michael Lynch</h1>
<img class ="img" src="${pageContext.request.contextPath}/img/michael.jpg" alt="michael">
<h3>Software Engineer</h3>
<p>A CS student from Ohio State, Michael solves NP Hard problems in his free time.
</p>
<hr>
<h1>Bryan Fennell</h1>
<img class ="img" src="${pageContext.request.contextPath}/img/bryan.jpg" alt="Bryan">
<h3>Kitten Wrangler</h3>
<p>Raised in an environment surrounded by a swath of exotic cats, Bryan has a talent at taming felines.</p>
<hr>
<h1>Jeff Hensal</h1>
<img class ="img" src="${pageContext.request.contextPath}/img/jeff.jpg" alt="Jeff">
<h3>Kitten Caretaker</h3>
<p>This person loves kitties, it's just that simple.</p>
<hr>
<h1>Trevor Laher</h1>
<img class ="img" src="${pageContext.request.contextPath}/img/trevor.jpg" alt="Trevor">
<h3>Kitten Packager</h3>
<p>An expert at packaging kittens such that they survive the 110 degree shipping warehouses, all so your kitten makes it to your home safe and sound.</p>
<jsp:include page="Footer.jsp"/>
<br>
</body>
</html>
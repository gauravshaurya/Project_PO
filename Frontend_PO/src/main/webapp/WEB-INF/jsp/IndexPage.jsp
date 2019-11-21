<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<c:set var="img" value="${pageContext.request.contextPath}/resources/img" scope="application"/>
<c:set var="js" value="${pageContext.request.contextPath}/resources/js" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> --%>
</head>
<body>
<img alt="" src="${img}/bg.jpeg">
<h1 align="center">${myIndex}</h1>
<hr/>
<table align="right">
<tr>
<td><a href="getLoginPage">Login</a></td>
<td><a href="getRegistrationForm">Register</a></td>
</tr>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="functions.js"></script>

<title>Purchase Orders</title>
</head>
<body>
	<div align="right">
		<%-- Welcome ${sessionScope.uObj.userName} --%>
	</div>
	<hr/>

	<table id="tblData">
		<thead>
			<tr>
				<th>Item</th>
				<th>Quantity</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><button id="btnAdd" >New</button></td>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>	
</body>
</html>
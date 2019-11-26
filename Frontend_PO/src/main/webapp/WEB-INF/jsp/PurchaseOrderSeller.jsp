<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="SellerNavbar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Orders</title>
</head>
<body>
	<div align="right">
		<%-- Welcome ${sessionScope.uObj.userName} --%>
	</div>
	<hr/>
	
	<div align="center">
		<h1>Purchase Orders List</h1>
		<table border="1">
			<tr>
				<th>PO Number</th>
				<th>Buyer Name</th>
				<th>PO Status</th>
				
			</tr>
			<c:forEach items="${puchaseOrders}" var="obj">
				<tr>
					<td>${obj.purchaseOrderId}</td>
					<td>${obj.buyerObj}</td>
					<td>${obj.status}</td>
				</tr>
			</c:forEach>	
		</table>
		
	</div>
</body>
</html>
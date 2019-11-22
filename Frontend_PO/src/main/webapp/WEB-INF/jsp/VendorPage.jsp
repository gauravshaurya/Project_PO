<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Page</title>
</head>
	<body>
		<div align="right">
				Welcome ${sessionScope.uObj.userName}
		</div>
		<div align="center">
			<h1>Welcome Vendor</h1>
			<a href="viewProfile">View Profile</a><br/>
			<a href="addProduct">Add Product</a><br/>
			<a href="productsList">Products List</a><br/>
			<a href="purchaseOrders">Purchase Orders</a><br/>
			<a href="">Change Password</a><br/>
			<a href="">Logout</a>
		</div>
	</body>
</html>
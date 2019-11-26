<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="SellerNavbar.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="color: green;">Buyers List</h1>
		
		<table class="table table-borderless  table table-hover table-dark">
			<thead>
				<tr>
					<th>Buyer Name</th>
					<th>Buyer Email</th>
					<th>Buyer Phone No.</th>
					<th>Buyer Address</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buyerDetails}" var="obj">
				<tr>
					<td>
						${obj.userName}
					</td>
					<td>
						${obj.email}
					</td>
					<td>
						${obj.phone}
					</td>
					<td>
						${obj.address.houseNumber}, ${obj.address.address1}, ${obj.address.address2}, ${obj.address.city}, ${obj.address.state}
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>
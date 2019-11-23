<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="jquery-1.7.2.min.js"></script>

<title>Purchase Orders</title>
</head>
<body>
	<div align="right">
		<%-- Welcome ${sessionScope.uObj.userName} --%>
	</div>
	<hr/>

<h1 align="center">Purchase Order Form</h1>
<hr/>		
<fieldset>
        <f:form action="createPurchaseOrder" method="post" modelAttribute="purchaseObj">
            <table>
            	<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Quantity</th>
				</tr>
				<c:forEach items="${pList}" var="obj">
				<tr>
					<td><f:input path="productId"/></td>
					<td><f:input path="productname"/></td>
					<td><f:input path="productQuantity"/>]</td>
                </tr>
                </c:forEach>
                <tr>
             		<td/>
             		<td/>
                    <td><input type="submit" value="Submit"/></td>
                </tr>      
            </table>
        </f:form>
        </fieldset>	
</body>
</html>
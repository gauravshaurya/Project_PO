<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${js}/script.js"></script>
</head>
<body>
<h1 align="center">Registration Form</h1>
<hr/>		
<fieldset>
        <f:form action="registerUser" method="post" modelAttribute="uObj">
            <table>
             	<tr>
                    <td>Buyer Name:</td>
                    <td><f:input path="userName" required="true"/></td>
                </tr>
                <tr>
                    <td>Phone No:</td>
                    <td><f:input path="phone"/></td>
                </tr>
                <tr>
                    <td>Email ID:</td>
                    <td><f:input path="email"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><f:input path="address.houseNumber" required="true" placeholder="House No."/></td>
                </tr>
             	<tr>
                    <td/>
                    <td><f:input path="address.address1"  required="true" placeholder="Address Line1"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><f:input path="address.address2"  required="true" placeholder="Address Line2"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><f:input path="address.city" size="15" required="true" placeholder="City"/></td>
                </tr>
                <tr>
                    <td/>
                 	<td><f:input path="address.state" size="15" required="true" placeholder="State"/></td>
                </tr>
                <tr>
                    <td/>
                    <td><f:input path="address.pincode" size="15" required="true" placeholder="Pincode"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><f:input path="password" required="true"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" id="register"/></td>
                </tr>      
            </table>
        </f:form>
        </fieldset>
</body>
</html>
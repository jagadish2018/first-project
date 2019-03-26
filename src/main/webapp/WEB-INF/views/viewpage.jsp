<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<h2>Registration Form</h2>
<form:form action="signup" modelAttribute="user">  
        Name: <form:input path="name" />         
        <br><br>  
        Password: <form:password path="password" />  
        <br><br> 
        Confirm Password: <form:password path="confirmPassword" />  
        <br><br> 
        Mobile number:<form:input path="mobileno" />
        <br><br>
        Address:<form:input path="address" />
        <br><br>
        Email id:<form:input path="emailid" /> 
        <br><br>   
        <input type="submit" value="Submit" />      
    </form:form>  
</body>
</html>
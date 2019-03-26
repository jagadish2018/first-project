<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container-fluid">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    
    <ul class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ul>

    
    <div class="carousel-inner">
      <div class="item active">
        <img src="${contextPath}/resources/carousel2.jpeg" alt="tshirt" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="${contextPath}/resources/kids1.jpg" alt="tshirt2" style="width:100%;">
      </div>
    </div>

    
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3>MENS</h3>
<a href="${contextPath}/CategorizedProducts/1">
<img src="${contextPath}/resources/katsonecktshirt.jpg" alt="tshirt"></a>    
</div>
    <div class="col-sm-4">
      <h3>WOMENS</h3>
      <a href="${contextPath}/CategorizedProducts/2">
<img src="${contextPath}/resources/women.jpg" alt="women"></a>   
    </div>
    <div class="col-sm-4">
      <h3>KIDS</h3>        
      <a href="${contextPath}/CategorizedProducts/44">
<img src="${contextPath}/resources/kids.jpg" alt="kids"></a>    
    </div>
  </div>
</div>
<br>
<%@include file="footer.jsp" %>
</body>
</html>
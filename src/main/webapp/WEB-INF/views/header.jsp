<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/security/tags"
 prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>T-shirts</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
.footer {
   width: 100%;
   background-color: blue;
   color: white;
text-align: center;
}
div.a {
    text-align:left;
}

</style>
</head>
<body>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-inverse navbar-fixed-top">
<ul class="nav navbar-nav">
<li><a class="navbar-brand" href="file:///C:/Users/INDIA/Desktop/example.htm">T-shirts Brand</a></li>
<li class="active"><a href="${contextPath}">Home</a></li>
    <security:authorize access="hasAuthority('ROLE_ADMIN')">
     <li><a href="${contextPath}/admin/product">Product Operations</a></li>
     <li><a href="${contextPath}/admin/category">Category Operations</a></li>
    </security:authorize>
    <security:authorize access="!hasAuthority('ROLE_ADMIN')">
    <li><a href="${contextPath}/products">Products</a></li>
    <li><a href="${contextPath}/category" class="dropdown-toggle" data-toggle="dropdown">Categories<b class="caret"></b></a>
     <ul class="dropdown-menu">
      <c:forEach items="${catlist}" var="cat">
       <li><a href="${contextPath}/CategorizedProducts/${cat.cid}">${cat.cname}</a></li>
      </c:forEach>
     </ul>
     </li>
   </security:authorize>
   <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    </ul>
  
  <div class="container-fluid">
 <ul class="nav navbar-nav navbar-right">
<security:authorize access="isAnonymous()">
      <li><a href="${contextPath}/signin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            <li><a href="${contextPath}/reg"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            </security:authorize>
            <security:authorize access="hasAuthority('ROLE_USER')">
            <li><a href="${contextPath}/customer/myCart"><span class="glyphicon glyphicon-shopping-cart" style="margin-left: 2px; margin-right: 2px;"></span>
      <span style="border-radius: 10px; background-color: red; color: white; padding: 8px; margin-right: 2px;">${cart.cquantity}</span>My Cart</a></li>
      </security:authorize>
				<security:authorize access="isAuthenticated()">
				<li id="logout"><a href="${contextPath}/perform_logout"><span class="glyphicon glyphicon-user"></span>Logout</a></li>
				</security:authorize>
                
			</ul>
    
  </div>
</nav>
<hr>


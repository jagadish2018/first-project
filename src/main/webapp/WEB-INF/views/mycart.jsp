<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
 prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
 <c:set var="images" value="${contextPath}/resources/carouselPics" />
 <c:set var="image" value="${contextPath}/resources" />
 <div class="container">
 <center>
   <c:if test="${cart.cquantity} == 0">
    <h2>Your Cart is Empty</h2>
    <a
      href="${contextPath}/products">
       <button type="button" class="btn btn-primary">Continue
        Shopping</button>
     </a>
    </c:if>
    </center>
  <br>
  <div class="table-responsive">
   <table border="2" align="center" class="table table-inverse"
    style="width: 70%">
    
    <tr>
     <td>Product</td>
     <td>Price of Product</td>
     <td>Quantity</td>
     <td>Total Price</td>
     <td></td>
    </tr>
    
    
    <c:forEach items="${cartItems}" var="cartItem">
     <tr>
      <form
       action="${contextPath}/customer/editCartItems/${cartItem.ciid}">
       <td>${cartItem.prod.pname}</td>
       <td>${cartItem.prod.price}</td>
       <td><input type="number" class="form-control"
        name="quantity" value="${cartItem.ciquantity}"></td>
       <td>${cartItem.ciprice}</td>

       <td>
        
        <a href="${contextPath}/customer/editCartItems/${cartItem.ciid}"><button type="submit" class="btn btn-primary">Edit</button></a>
      </form>
      <a
       href="${contextPath}/customer/deleteCartItems/${cartItem.ciid}/cartItem"><button
        type="button" class="btn btn-danger">Remove</button></a>
      </td>
    </c:forEach>
    </tr>
    <tr>
     <td colspan="3">Total Price of Cart</td>
     <td>${cart.cprice}</td>
     <td></td>
    </tr>

    <tr>
     <td colspan="3" style="text-align: center"><a
      href="${contextPath}/products">
       <button type="button" class="btn btn-primary">Continue
        Shopping</button>
     </a></td>
     <td colspan="2" style="text-align: center"><a
      href="${contextPath}/customer/checkout">
       <button type="submit" class="btn btn-primary">Check Out</button>
     </a></td>
    </tr>
   </table>
   
  </div>
  
 </div>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="image" value="${contextPath}/resources" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%> 
<form:form id="prodForm" modelAttribute="product" action="${contextPath}/admin/prodprocess" enctype="multipart/form-data" method="post">

	<div class="table-responsive">

		<center>
			<h2>Product form</h2> 	</center>
		</br>

		<div class="container">

			<div class="row">

				<div class=col-sm-3></div>

				<div class="col-sm-6">

					<div class="form-group">

						<form:input path="pid" type="hidden" />

						<label for="pname">Product Name:</label>

						<form:input path="pname" name="pname" id="pname"
							required="true"  class="form-control" />

					</div>

					<div class="form-group">

						<label for="pdescription">Product Description:</label>

						<form:input path="pdescription" name="pdescription" id="pdescription"
							class="form-control" />

					</div>
					<div class="form-group">

						<label for="price">Product price:</label>

						<form:input path="price" name="price" id="price"
							class="form-control" />

					</div>
					<div class="form-group">

						<label for="stock">Product stock:</label>

						<form:input path="stock" name="stock" id="stock"
							class="form-control" />

					</div>
					<div class="form-group">

						<label for="category.cid">Category id:</label>

						<form:input path="category.cid" name="category.cid" id="category.cid"
							class="form-control" />

					</div>
					<div class="form-group">
      					<label for="image">Upload Image:</label>
      					<form:input path="image" type="file" class="form-control"
       						required="true" />

     				</div>
					

					<button type="submit" class="btn btn-default">Add Product</button>
					

			
				</div>

			</div>

		</div>

	</div>
	<div class="table-responsive">
  <table border="2" align="center" class="table table-inverse"
   style="width: 70%">
   <tr>
    <th>Product Image</th>
    <th>Product Name</th>
    <th>Product Description</th>
    <th>Product Price</th>
    <th>Product Stock</th>
    <th>Category id</th>
    <th>Edit Product</th>
    <th>Delete Product</th>
   </tr>
   <c:forEach items="${prodlist}" var="prod">
    <tr>
    <td><img src="${image}/${prod.pid}.jpg"
     style="width: 50px; height: 50px;"></td>
     <td>${prod.pname}</td>
     <td>${prod.pdescription}</td>
     <td>${prod.price}</td>
     <td>${prod.stock}</td>
     <td>${prod.category.cid}</td>
     <td><a href="${contextPath}/admin/updatePat/${prod.pid}"><button
     type="button" class="btn btn-primary">Edit</button></a></td>
     <td><a href="${contextPath}/admin/deletePat/${prod.pid}"><button
     type="button" class="btn btn-danger">Delete</button></a></td>
    </tr>
   </c:forEach>
  </table>
 </div>
	</form:form>
	
</body>
</html>
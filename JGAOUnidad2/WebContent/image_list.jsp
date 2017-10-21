<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Images</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="ImageController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Type</th>
			 <th>Height</th>
			  <th>Category</th>
			
		</tr>
		<c:forEach var="image" items="${images}">
		
		<tr>
			<td>
				<form action= "ImageController">
					<input type = "hidden" name = "id" value= "${image.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${image.id}</td>
			<td> ${image.type}</td>
			<td> ${image.height}</td>
			<td> ${image.category}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>
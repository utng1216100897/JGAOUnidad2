<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Image Form</title>
</head>
<body>
	<form action="ImageController">
		<label>image type:</label><br>
		<input type = "text" name= "type" value = "${image.type}" /><br>
		
		<label>image height:</label><br>
		<input type = "text" name= "height" value = "${image.height}" /><br>
		
		<label>image Category:</label><br>
		<input type = "text" name= "category" value = "${image.category}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete File</title>
</head>
<body>

<!-- Generation of a dynamic drop down list based on the Examination List returned from service -->
	
<form action="deleteFile.hr">
	<select name="Files" id="selectedFile">
		<c:forEach items="${fileList}" var="file">
  			<option value="${file.fileName}">${file.fileName}</option>
  		</c:forEach>
	</select>
	<input type="submit" value="delete file">
</form>
</body>
</html>
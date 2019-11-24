<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head></head>
<h1>UPLOAD QUESTION FILE</h1>

<!-- Generation of a dynamic drop down list based on the Examination List returned from service -->
	<select name="Subjects">
		<c:forEach items="${examList}" var="exam">
  			<option value="${exam.examId}">${exam.examName}</option>
  		</c:forEach>
	</select>
<form action="fileUpload.hr" enctype="multipart/form-data" method="post">
	<input type="file" name="file"/>
	<input type="submit" value="Upload File">
</form>
<a href="view-all.hr">View All Images</a>
</body>
</html>
    
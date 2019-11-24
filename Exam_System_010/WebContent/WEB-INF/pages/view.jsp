<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image Catalog</title>
</head>
<body>
<h2>View all Uploaded images here...</h2>

<!-- Get the Context root of current web-app (It should be http://localhost:8080/demo-files/)
	 It can auto-detect your tomcat port (8080) and application name (demo-files) from URL -->
<c:set var="rootPath">
<%=request.getContextPath() %>
</c:set>

<c:forEach var="img" items="${images}" >
	<img src="${rootPath}${img}" width="120" height="100" />
</c:forEach>
</body>
</html>
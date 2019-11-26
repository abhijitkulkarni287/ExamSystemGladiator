<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.background {
  background: url(pc2.jpg) repeat;
  background-size:cover;
  border: 2px solid black;
}

div.transbox {
  margin: 260px;
  background-color: #ffffff;
  border: 1px solid black;
  opacity: 0.6;
  filter: alpha(opacity=60); /* For IE8 and earlier */
}

div.transbox p {
  margin: 5%;
  font-weight: bold;
  color: #000000;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="background">
  <div class="transbox">
 <h1 align="center" >Online Test Application</h1>
 <hr width=480 >
 <form:form commandName="user" action="login.html" >
 <table align="center">
  <tr>
    <td><form:label path="userName" >User Name:</form:label></td>
    <td><input type="text" name="userName" maxlength="30"/>
    <td>
     <form:input path="userName"/>     
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
      <FONT color="red"><form:errors path="userName"></form:errors></FONT>
    </td>
  </tr>
  <tr>
    <td><form:label path="password"  >Password:</form:label></td>
    <td><input type="password" name="password" maxlength="30"/>
    
    <td>
      <form:password path="password" />      
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
      <FONT color="red"><form:errors path="password"></form:errors></FONT>
    </td>
  </tr>
  <tr>
    <td></td>
    <td>
      <input type="submit" value="Login"/> or
      <a href="register.hr"> Sign up</a>
    </td>
  </tr> 
 </table>
 </form:form> 

</body>
</html>
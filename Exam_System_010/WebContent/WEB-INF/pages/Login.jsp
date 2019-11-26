<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
div.background {
  background: url(/Exam_System_010/pictures/pc2.jpg) repeat;
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
<title>Login Page</title>
</head>
<body>
<a href="home.hr">HOME</a>
<div class="background">
  <div class="transbox">
 <h1 align="center" >Online Test Application</h1>
 <hr width=480 >
 <form commandName="user" action="loginValidate.hr" >
 <table align="center">
  <tr>
    <td><label>User Name:</label></td>
    <td><input type="text" name="username" maxlength="30"/></td>
  </tr>
  <tr>
    <td><label>Password:</label></td>
    <td><input type="password" name="password" maxlength="30"/>
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
 </form> 

</body>
</html>
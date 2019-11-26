<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
color:white;

background-image: url("https://cdn.pixabay.com/photo/2015/01/08/18/26/write-593333_960_720.jpg");
background-repeat: no-repeat;
background-size:cover;

}
input[type=text], select {
  width: 100%;
  padding: 3px 5px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
p{font-size:20px;font-family:arial;text-align:center}
</style>
<!-- <link rel="stylesheet" type="text/css" href=""> -->
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<a href = "login.hr">Existing User? Login here</a>
<a href="home.hr">HOME</a>
<p>REGISTRATION PAGE</p>
<form action="registerStudent.hr" method="post">
	<table align="center">
	<tr>
		<td>FIRST NAME:</td><td> <input type= "text" name="firstName"></td>
	</tr>
	<tr>
		<td>LAST NAME:</td><td><input type= "text" name="lastName"></td>
	</tr>
	<tr>
		<td>DATE OF BIRTH:</td><td><input type= "date" name="dateOfBirth"></td>
	</tr>
	<tr>
		<td>GENDER:</td><td><label>Male</label><input type= "radio" name="gender"><label>Female</label><input type= "radio" name="gender"></td>
	</tr>
	<tr>
		<td>EMAIL:</td><td><input type= "text" name="email"></td>
	</tr>
	<tr>	
		<td>PHONE:</td><td><input type= "text" name="phoneNumber"></td>
	</tr>
	<tr>	
		<td>CITY:</td><td><input type= "text" name="city"></td>
	</tr>
	<tr>	
		<td>STATE:</td><td><input type= "text" name="state"></td>
	</tr>
	<tr>
		<td>Username:</td><td><input type= "text" name="username"></td>
	</tr>
	<tr>	
		<td>Password:</td><td><input type= "password" name="password"></td>
	</tr>
	<tr>	
		<td>Repeat Password:</td><td><input type= "password" name="passwordNA"></td>
	</tr>
	<tr>
	<td colspan=2><input type="submit" value = "Register"></td>
	</tr>
	</table>
</form>

</body>
</html>
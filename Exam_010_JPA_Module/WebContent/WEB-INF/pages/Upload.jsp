<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
</head>
<body>

<div class="background">
  <div class="transbox">
    </style>
<body onload="myFunction()">

<h1>UPLOAD QUESTION FILE</h1>


<form>
<!-- Generation of a dynamic drop down list based on the Examination List returned from service -->
	<select name="Subjects">
		<c:forEach items="${examList}" var="exam">
  			<option value="${exam.examId}">${exam.examName}</option>
  		</c:forEach>
	</select>
	<input type="file" id="myFile" multiple size="50" onchange="myFunction()">
</form>
<p id="demo"></p>
  
<script>
function myFunction(){
  var x = document.getElementById("myFile");
  var txt = "";
  if ('files' in x) {
    if (x.files.length == 0) {
      txt = "Select one or more files.";
    } else {
      for (var i = 0; i < x.files.length; i++) {
        txt += "<br><strong>" + (i+1) + ". file</strong><br>";
        var file = x.files[i];
        if ('name' in file) {
          txt += "name: " + file.name + "<br>";
        }
        if ('size' in file) {
          txt += "size: " + file.size + " bytes <br>";
        }
      }
    }
  } 
  else {
    if (x.value == "") {
      txt += "Select one or more files.";
    } else {
      txt += "The files property is not supported by your browser!";
      txt  += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead. 
    }
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>

<p><strong>Tip:</strong> Use the Control or the Shift key to select multiple files.</p>

  </div>
</div>

</body>
</html>
    
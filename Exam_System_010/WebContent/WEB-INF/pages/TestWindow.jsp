<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- clear browser cashe after making changes to js -->

<!DOCTYPE html>
<html>
<head>
<style>
.ques
{height: 50%;
  width: 100%;
	
}
.questionDisp
{
height: 50%;
  width: 100%;
}
.button1 {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
label
{
width:20px;
}
ul li
{
  text-align: left;
  font-size: 20px;
  margin-top: 0px;
  background:lightblue;
  margin: 5px;
  
}

.split1 {
  height: 100%;
  width: 20%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}
.split2 {
  height: 100%;
  width: 80%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

/* Control the left side */
.left {
  left: 0;
  background-color: lightblue;
}

/* Control the right side */
.right {
  right: 0;
  background-color:#FFFAF0;
}

</style>
<meta charset="ISO-8859-1">
<title>TestWindow</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
var examId=${examId};

$(document).ready(function(){
  $("#startTestBtn").click(function(){
    $.ajax({url:"http://localhost:8082/Exam_System_010/test/fetchQuestion.hr?examId="+examId, success: function(result){
    data=result;
    document.getElementById("startTestBtn").disabled = true;
    displayQuestion(0);
    }});
  });
});
</script>
<script src="<%=request.getContextPath()%>/scripts/timer.js"></script> 
<script src="<%=request.getContextPath()%>/scripts/testWindowPage.js"></script> 
<script type="text/javascript">
        window.history.forward();
        function noBack()
        {
            window.history.forward();
        }
</script>

</head>

<body  onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="" >


<div class="split1 left">
<div id="demo" class="timer"></div>
<button id ="startTestBtn" onclick="startExam()">STAR TEST</button><br><br>

<button id ="1" onclick="return displayQuestion(0)" >Q 1 </button><br>
<button id ="2" onclick="return displayQuestion(1)" >Q 2 </button><br>
<button id ="3" onclick="return displayQuestion(2)" >Q 3 </button><br>
<button id ="4" onclick="return displayQuestion(3)" >Q 4 </button><br>
<button id ="5" onclick="return displayQuestion(4)" >Q 5 </button><br>
<button id ="6" onclick="return displayQuestion(5)" >Q 6 </button><br>
<button id ="7" onclick="return displayQuestion(6)" >Q 7 </button><br>
<button id ="8" onclick="return displayQuestion(7)" >Q 8 </button><br>
<button id ="9" onclick="return displayQuestion(8)" >Q 9 </button><br>
<button id ="10" onclick="return displayQuestion(9)" >Q10</button><br>

</div>



<div class="split2 right">        <!-- right split div start -->
<div class='ques'>
<form id="questionForm" >
<div id="questionDisp" ><h1>INSTRUCTIONS</h1>
<ul>
<li>Make sure you have good internet connection</li>
<li>Press start button on the  LEFT side panel to start exam</li>
<li>Go to Any question by using question no. panel on left  </li>

</ul>
<br>
 <br>
 <br>
</div>
 <input type="submit"  id="nextQuestion" onclick="return getRadioValue()" value="SAVE ANSWER" >
 <br>
 <br>
 <br>
</form>
</div>

<div align="center" >

<form id="testOver" action="generateResult.hr">
<!-- <input type="hidden" id = "studentId" >  -->       
 <input type="hidden"  id= "testScore" name="testScore"  >  

<button  class='button1'  onclick="return submitTest()" >Submit</button>  
</form>
</div>

</div>         <!-- right split div end -->

</body>
</html>
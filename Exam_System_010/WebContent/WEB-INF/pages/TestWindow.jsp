<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table
{
  padding:20px;
}
label
{
width:20px;
}
p
{
  text-align: center;
  font-size: 10px;
  margin-top: 0px;
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
  background-color: yellow;
}

/* Control the right side */
.right {
  right: 0;
  background-color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>TestWindow</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/WebContent/scripts/timer.js"></script> 

<script>
document.oncontextmenu = new Function(' return false; ');    // disable right click
var data;
var markedOptions = ["","","","","","","","","",""];
var index =0;

var examId = ${examId};

var testScore=0;
var maxScore=10;

$(document).ready(function(){
  $("#btn").click(function(){
    $.ajax({url: "http://localhost:8082/Exam_System_010/test/fetchQuestion.hr", success: function(result){
    data=result;
    displayQuestion(0);
    }});
  });
});


function displayQuestion(index)
{   
   window.index = index;

    var mainContainer = document.getElementById("questionDisp");
    mainContainer.innerHTML = '<p>Q' + data[index]["questionId"] + ' ' + data[index]["question"] + '</p>';
 
    for (var i = 0; i < data[index]["options"].length; i++) {
        var div = document.createElement("p");
        div.className='option';
        div.innerHTML = '<input type="radio" name="option" value="'+data[index]["options"][i]+'" ><label> ' + data[index]["options"][i] + '</label><br>';
        mainContainer.appendChild(div);     
    }
    var radioButtons = document.getElementsByName('option');   
    for(i = 0; i < radioButtons.length; i++) {
        if(radioButtons[i].checked) {
        	radioButtons[i].checked = true;
        }}
   // return false;
}

function getRadioValue() {
    var ele = document.getElementsByName('option');
     
    for(i = 0; i < ele.length; i++) {
        if(ele[i].checked) {
        console.log(index +'   '+ele[i].value) ;
        markedOptions[index] = ele[i].value ;
        console.log(markedOptions[index]);
        selected = ele[i];        
        }
    }
    
    if(index<10)
    	{
    		window.index++
    		displayQuestion(index);
    		//return false   not needed
    	}
     return false;
}

function submitTest()
{  
	var submit = confirm("SUBMIT TEST !!!!");
	if(submit == true)
		{ generateTestScore();
		document.getElementById("testScore").value = testScore;
		return true;   
		}
	else return false;
}

function generateTestScore()
{   testScore = 0;
	for(i = 0 ; i < 3 ; i++)
		{
		if( data[i]["markedOption"]===markedOptions[i]) 
			testScore++;
		}
	console.log("score : "+testScore);
	return false;
	}

</script>
</head>

<body   >


<div class="split1 left">
<div id="demo" class="timer"></div>
<button id ="btn">press</button><br><br>

<button id =1 onclick="return displayQuestion(0)" >Q 1</button><br>
<button id ="2" onclick="return displayQuestion(1)" >Q 2</button><br>
<button id ="3" onclick="return displayQuestion(2)" >Q 3</button><br>
<button id ="4" onclick="return displayQuestion(3)" >Q 4</button><br>
<button id ="5" onclick="return displayQuestion(4)" >Q 5</button><br>
<button id ="6" onclick="return displayQuestion(5)" >Q 6</button><br>
<button id ="7" onclick="return displayQuestion(6)" >Q 7</button><br>
<button id ="8" onclick="return displayQuestion(7)" >Q 8</button><br>
<button id ="9" onclick="return displayQuestion(8)" >Q 9</button><br>
<button id ="10" onclick="return displayQuestion(9)" >Q 10</button><br>

</div>



<div class="split2 right">
<form id="questionForm" >
<div id="questionDisp" >
</div>
 <input type="submit"  id="nextQuestion" onclick="return getRadioValue()" value="SAVE ANSWER" >
</form>

<button id="sc" onclick="generateTestScore()" >score</button>       <!--  isko hatana hai  -->

<div>
<form action="testResultPage.jsp"  method="post" >
<!-- <input type="hidden" id = "studentId" >  -->       
 <input type="hidden"  id= "testScore" name="testScore"  >  
<button onclick="return submitTest()" >Submit</button> 
</form>
</div>

</div>

</body>
</html>
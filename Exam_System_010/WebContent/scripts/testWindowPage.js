document.oncontextmenu = new Function(' return false; ');    // disable right click
var data;
var markedOptions = ["","","","","","","","","",""];
var index =0;

var testScore=0;
var maxScore=10;

function displayQuestion(index)
{   
   window.index = index;

    var mainContainer = document.getElementById("questionDisp");
    mainContainer.innerHTML = '<p><strong>Q' + (index+1) + '</strong> ' + data[index]["question"] + '</p>';
 
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

function submitTest(timeLeft)
{  
	
	
	var submit = confirm("SUBMIT TEST !!!!");
	if(submit == true)
		{ 
		generateTestScore();
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
	document.getElementById("testScore").value = testScore;
	console.log("score : "+testScore);
	//return false;
	}
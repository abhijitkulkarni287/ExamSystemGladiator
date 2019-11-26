// Set the date we're counting down to
	//var countDownDate = new Date("Jan 5, 2021 12:53:50").getTime();
	var countDownDate = new Date().getTime()+(1000 * 60)*2;
	// Update the count down every 1 second
	
	function startExam(){
		
	var x = setInterval(function() {

  	// Get today's date and time
  	var now = new Date().getTime();
    
 	 // Find the distance between now and the count down date
  	var distance = countDownDate - now;
    
  	// Time calculations for days, hours, minutes and seconds
  	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  	var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
 	 var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML = hours + "h "
  + minutes + "m " + seconds + "s ";
    
  // If the count down is over, write some text 
  if (distance < 0) {
    stop(x);
  }
}, 1000); 
}
function stop(ref){

	console.log("Time out");
    document.getElementById("demo").innerHTML = "EXAM OVER";
    generateTestScore();
    document.forms.testOver.submit();
	clearInterval(ref);
}    


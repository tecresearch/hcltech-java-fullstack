function makeActive(linkid)
{
	document.getElementById(linkid).style.color='red';
	//document.getElementById(linkid).style.backgroundColor='black';
}
function checkAmountLimit()
{
	if(document.getElementById("amount").value>20000){
		document.getElementById("error").innerHTML="Maximum 20000 is allowed per transaction";
		return false;
	}
	return true;
}
function checkSelfAccountNo()
{
	var san=document.getElementById("san").value;
	var ran=document.getElementById("ran").value;
	if(parseInt(san)==parseInt(ran))
	{
		document.getElementById("error").innerHTML="This is your own account number";
		return false;
	}
	return true;
}
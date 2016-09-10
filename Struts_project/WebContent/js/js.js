function form_submit(){
	document.getElementById("login").submit();
}
function form_reset(){
	document.getElementById("login").reset();
}
function reloadcode(){
    var verify=document.getElementById('safecode');
    verify.setAttribute('src','code.php?'+Math.random());
}

function check(checkcontent,nresult){
	var result = document.getElementById(nresult);
	if(document.getElementById(checkcontent).value == "") {
	
		result.innerHTML = "*必填选项";

	}	
	
}
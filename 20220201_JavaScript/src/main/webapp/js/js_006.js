var a = document.getElementById('anchor');
a.addEventListener('click', function(event){
	event.preventDefault();
//	return;
//	return false;
	console.log(event.target.href);	
});


function preGallary(){
	console.log("이전");
	return false;
}

function nextGallary(){
	console.log("다음");
	return false;
}
function numTest(val){
	// 화면의 모든 값을 문자열로 받을 수 있음
	console.log(val, typeof val);
	var cal1 = val + 10;
	console.log(cal1)
	var cal2 = Number(val) + 20;
	console.log(cal2, typeof cal2);
	
	var cal3 = new Number(val);
	console.log(cal3, typeof cal3)
	
	document.getElementsByTagName("h1")[0].textContent = cal3;
}

//실수값이 들어 와도 버림으로 처리 되어 정수값이 됨
function intTest(){
	var val = document.getElementById("int").value;
	var vals = parseInt(val)+5;
	console.log(vals);
}

function floatTest(val){
	var vals = parseFloat(val);
	console.log(vals, typeof vals);
}

function evalTest(){
	var val = document.getElementsByName("eVal")[0];
	if(confirm("입력하신 코드가 맞습니까?"+val.value)){
		document.getElementsByTagName("span")[0].innerHTML=
		"<b>"+eval(val.value) +"</b>"
	}else{
		val.value="다시 작성하세요. 예)10+1";
	}
}







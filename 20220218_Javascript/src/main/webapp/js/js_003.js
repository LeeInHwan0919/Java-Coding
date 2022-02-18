window.onload = function(){
	let ele = document.getElementById('callFn');
	ele.addEventListener("click",callFunction);
}
//function callFunction(){
//	alert("addEventListner 호출")		
//}

var callFunction = function(){
	alert("addEventListner 호출")		
}





/**
	1. undefined 미정의 되어 있다.
	   변수는 선언이 되어 있으나 값이 없는 경우
 */

function variable_scope() {
	//탐색  dom이 없으므로 null이 됩니다.
	//	var uf = document.getElementById("name");
	//	console.log(uf);
	//	console.log(uf,typeof(uf));

	//javascript에서 선언만 되어 있고 값이 없음으로 undefined
	//	var a;
	//	console.log(a);
	//	console.log(a,typeof(a));
	//	
	//	alert(b)

	var a = 10;
	if (true) {
		var b = 100;
		var b = 200;
		console.log('for문 위의 c는 undefined ' + c);

		for (var c = 0; c < 5; c++) {
			console.log('c=' + c)
		} //for문의 범위

		console.log('for문 밖의 c는 scope ' + c);
	}//if문의 범위

	console.log('for문 밖의 b는 scope ' + b);

	const PI = 3.14; //ES6에서 추가된 문법 변수 상수화
	console.log(typeof (PI));
	//	PI = 9.11; //const는 변수를 상수로 만들기 때문에 console의 로그를 꼭 확인 해야 함

	for (let i = 0; i < 3; i++) { //ES6에서 추가된 문법 변수 local variable
		console.log(i);
	}
	//	console.log(i); //var변수(글로벌변수)가 아니기때문에 선언되지 않은 상태 /let은 외부에서 사용할 수 없다.

	var array = [1, 2, 3]; //다중배열 가능
	for (let x of array){ //of 값을 보여줌 , in 인덱스 번호 보여줌 
		console.log(x);
	}
}//function variable_scope

//변수의 범위
//1. 전역변수 : 모든 function에서 사용가능 단, HTML 은 넘어 갈 수 없다.

var variable = 10;

function global_variable() {
	variable = variable + 3;
	var doc = document.getElementById('v1');
	doc.textContent = '<b>' + variable + '</b>';
	//	doc.innerHTML = '<b>' + variable + '</b>'; 아래설명 참조
	//innerHTML : mark-up의 시작과 종료 tag사이의 영역에 HTML로 인식시켜 넣는다.<b>삭제
	//textContent : mark-up의 시작과 종료 tag사이의 영역에 문자로 인식시켜 넣는다.<b>그대로출력
}


function local_scope() {
	//전역변수의 선언은 지역변수로 사용할 경우 지역변수로 변경된다.
	alert(variable); //같은 이름의 지역변수를 선언하지 않았다면 전역변수 이기 때문에 10이 출력이되고,
					// 만약 같은 이름의 지역변수가 있다면 (아래포함) 먼저 실행되기 때문에 undefined가 됩니다. 
	
	var variable = 5;//지역 scope로 전역변수와 같은 이름의 변수를 정의 
	alert(variable);//위의 지역 scope에 의해서 5출력
}




function local_variable(){
//	let variable = variable + 100;
//	let variable = undefined + 100;
	let variable01 = variable +100;
	console.log(variable01);
	document.getElementById('v2').innerHTML = '<strong>'+variable01+'</strong>';
}

function variableType(){
	var var02 = 5;    //정수 -> 숫자 number
	var var03 = 3.14; //실수 -> 숫자 number 
	console.log(typeof var02);
	console.log(typeof var03);
	
	var var04 = '문자';
	console.log(typeof var04);
	
	var var05 = [1,2,3,4]
	console.log(typeof var05);
	
	var var06 = false;
	console.log(typeof var06);
	console.log(true + 11);
	
	var var07 = null;
	console.log(typeof var07);
	
	var var08 = function(id){alert('값=' + id)};
	console.log(typeof var08);
	
	//익명 함수의 실행과 사용, argument가 반드시 필요한건 아닙니다.
	var08('안녕');
	
	var var09; //선언만 되어 있는 변수 undefined
	console.log(typeof var09);
	
	var var10 = document.getElementById('val'); //존재하지 않는 DOM탐색
	console.log(typeof var10); //Object node가 없는 Object                                                                              
	console.log(var10); //null

}

















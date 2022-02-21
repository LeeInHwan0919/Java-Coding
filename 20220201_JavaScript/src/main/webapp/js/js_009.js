function numberTest(){
	//작성 방법
	var num1 = new Number(7); // 객체 선언방법
	var num2 = 101; //리터럴 선언방법
	
	Number.prototype.test=function(){
		console.log("프로토타입");
		return "프로토타입"
	}
	
	console.log(typeof num1, num1.test());
	console.log(typeof num2, num2.test());
	
	//NaN(Not a Number)
	//숫자가 아닌 문자형 숫자인지를 판별 해줌
	document.write(1=='1');// 값의 형변환이 자동으로 일어남
	//문자형 숫자는 자동으로 변환이 가능함 하지만 숫자가 아닌 형태는 NaN(Not a Number)으로 출력된다.,
	document.write("속성NaN:"+parseInt('가')+"<br>");
	
	//infinity
	//무한의 값을 표현해 주는 값
	document.write("infinity속성 : "+(Number.MAX_VALUE+0.000001e+380)+"<br>");
	
	//number 객체의 함수
	// toFixed(); 실수형의 소수점 자리를 지정하고 반올림 하여 문자열반환
	var double = 3.1234856;
	var d = double.toFixed(4);
//	var d = double.round(4); 라운드는 안댐..
	document.write("toFixed():" + d + "<br>");
	console.log(typeof d);
	var r = Math.round(double*1000)/1000;
	console.log(r, typeof r);
	console.log(typeof double);
	var p = double.toPrecision(4);
	console.log(p, typeof p);
	
	// toString();
	console.log(num2.toString(16));	
}

function isNumber(){
	var prop = prompt("숫자만 입력해 주세요");
	if(isNaN(prop)){
		alert("숫자가 아닙니다.");
	}else{
		alert("숫자 입니다.");
	}
}

function isRegEx(){
	//숫자를 판별하는 정규화표현식
	var regex = /^[0-9]*$/;
	var val = document.getElementById("num").value;
	console.log(val);
	if(!regex.test(val)){
		alert("숫자만 입력해 주세요")
	}
}

// ^ 문자열의 시작
// $ 문자열의 종료
// [] 문자열의 범위
// {} 반복
// ?  앞에 있는 문자가 한번 있거나 없거나
// +  앞에 있는 문자가 한번
// * 앞에 있는 문자가 한번 있을수도 있고 무한정 반복될 수 있음
// \w 알파벳과 숫자 만 선택
// \W 알파벳과 숫자 빼고 선택
// \d 숫자만
// \D 숫자가 아닌것만
// g 반복으로 검색
// i 대소문자 무시
// m 여러줄 검색
// 이메일 정규화 표현식
// /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$/;

function isPhoneRegEx(){
	var regex= /^\d{2,3}-\d{3,4}-\d{4}$/;
	var val = document.getElementById("phone").value;
	console.log(val);
	if(!regex.test(val)){
		alert("형식에 맞는 전화번호를 입력해 주세요");
	}
}


















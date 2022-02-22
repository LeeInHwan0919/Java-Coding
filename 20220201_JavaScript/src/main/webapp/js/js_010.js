
//문자열 합치기
function stringTest01() {
	var str01 = 'String';
	var str02 = 'Test';
	//연산자를 통한 방법 concatenation
	var str03=str01+str02;
	
	//객체를 생성해서 하는 방법
	var newString1 = str01.concat("a","b",1,false);
	var newString2 = str01.concat(str02);
	console.log(newString1);
	console.log(newString2);
	
	//문자열의 배열을 conjunction 과 함께 문자열로 만들어줌
	var joinString = ['String','20',10].join('/');
	console.log(joinString);
}

//다른 자료형 합치기
function stringTest02() {
	var double = 3.14;
	var int = 10;
	var str="화요일";
	var boolean = false;
	var con = boolean+double+int+str;//false = 0
	console.log(con);	
}

//문자열 비교하기
function stringTest03() {
	//동등연산자 ==
	var strVal = prompt("당신의 이름은","");
	var span = document.getElementById("cmd");
	//prompt는 문자열 null, 값
	if(strVal.match(/[2-9]/)){ //문자열
		alert("숫자 2~9까지는 입력 금지")
	}else if(strVal == 1){//문자 숫자 비교
		span.textContent = strVal + "님 환영합니다."
	}else{
		span.innerHTML="이름을 다시 입력해 주세요."
	}
	
	//완벽한 비교 연산자 ===
	// '1' == 1  true , '1' === 1  false
	// 완벽한 비교는 자료형과 값을 판단하기 때문에
	
	var objStr1 = new String("화요일");
	var objStr2 = "화요일";
	if(objStr1 === objStr2){
		console.log("new 와 리터럴은 같다");
	}else{
		console.log("new 와 리터럴은 다르다");
	}
	
}

//문자열 검색하기
function stringTest04() {
	// indexOf(), lastIndexOf(), IndexOf(,3)
	var strWord = "흥부 놀부 까치 놀부 도깨비";
	var promp = prompt("검색할 이름을 선택해 주세요.");
	console.log(strWord.indexOf(promp));
	console.log(strWord.indexOf(promp,7));
	console.log(strWord.lastIndexOf(promp,7));
}

//문자열 추출하기
function stringTest05() {
	var strVal = "문자열 추출, indexOf         :        lastIndexOf        ";
	var comma = strVal.indexOf(',');
	var colon = strVal.indexOf(':');
	console.log(comma, colon);
	
	//subString은 java와 같이 startindex를 포함, endindex는 -1을 한다.
	console.log(strVal.substring(comma, colon+1));
	
	//javascript split은 java의 split과 다름
	var val = "opp:ooo:foo";
	var valSplit = val.split("o");
//	console.log(valSplit);
	for(let i = 0; i < valSplit.length; i++){
		if(!valSplit[i]==''){
			console.log(valSplit[i]);
		}
	}
	
}

//키워드 나누기
function stringTest06() {
	var val = prompt("쉽표로 구분하여 값을 입력해 주세요","ex)감,사과,배,오렌지");
	var splitVal = val.split(',');
	for(let i = 0; i < valSplit.length; i++){
		
	}
}

//개미수열 출력
function stringTest07() {
	var val = prompt("쉽표로 구분하여 값을 입력해 주세요","ex)감,사과,배,오렌지");
	var splitVal = val.split(',');
	console.log(i);
}


















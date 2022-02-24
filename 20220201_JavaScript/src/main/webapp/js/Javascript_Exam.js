function numCheck01(){
	console.log("numCheck01");
	// javascript에서 타입
	// 화면에 뿌려져있는 (HTML이 아닌것들-콘텐츠-textNode) node를 가져오면
	// DOM의 방법
	
	//document. tlwkr - document 사용되고 있는 stateless의 페이지
	//document.getElement(s)  : s를 붙인다면 nodeList의 형태로 s를 안붙이면 node형태로 탐색이 된다.
	// ** DOM된 결과는 위치 탐색
	
	//탐색된 위치의 값을 처리하는 방식
	//empty Element(닫힘 tab가 없고 단일) : value 속성(property)으로 가지고 있음
	// markup tab(wel-formed) 한 tag : innerHTML - 자식 노드 전체를 HTML인 String가져옴 ex) <br>값</br>
	//								   textContent - textNode을 가져옴 ex) 값
	
	//<input> : form 요소(tag)는 서버(WAS)에 데이터를 <form>태그를 통해서 속성이 action의 위치로 전송할 수 있다.
	//<input>의 type중에 특이사항 : submit - action을 호출
	//                          reset - 처음에 뿌려진 값을 다시 호출
	//<textarea></textarea> : 콘텐츠를 값으로 가짐, pre속성이 적용되기 때문에 공백이 없는 상태 
	//                          textarea -> textarea   ex)하늘\n\r구름 -> 하늘\n\r구름
	//							textarea -> text 달라짐 보이는 그대로 볼 수 있음 ex) 하늘\n\r구름 -> 하늘 구름
	//	전송되는 form요소는 <form>로 작성하는게 좋음
	// 서버로 전송되는 protocol(HTTP)의 규약 : GET, POST, PUT, DELETE ...
	// <form> 요소에서만 동작되는 이벤트 : submit, reset
	
	
	var num = document.getElementsByName('num')[0].value;
	
	//정규화 표현식
	
	//숫자판단
	var regexNum = /^[0-9]/g;
	var numChk = num.search(regexNum); // 인덱스 반환
	alert(numChk); // 정규식을 판단하면 맞다면 0, 아니면 -1
	
	if(numChk == -1){
		alert("숫자가 아닙니다.");
	} else{
		alert("숫자입니다.");
	}
	
	var num = document.getElementById('A');
	console.log(num); // null 탐색을 하였는데 위치에 대한 객체가 없다면 null
	
	var numb = document.getElementsByName('B'); // nodeList
	console.log(numb); // nodeList
	
	var numc = document.getElementsByName('B')[0];
	console.log(numc); // undefined
	
//	if(numc == null || null == undefined){ // null과 undefined 동등으로 비교연산이 진행됨
	if(numc === null){ // 완벽한 비교에서는 null과 undefined 정확하게 비교
		alert("값을 입력해주세요")
	}else{
		if(isNaN(num)){
			alert("숫자가 아닙니다")
		}else{
			alert("숫자입니다.")
		}
	}
	
	/*if(isNaN(num1)){
		alert("숫자가 아닙니다.");
	}else {
		alert("숫자입니다.");
	}*/
}

function searchStr02(){
	var val = document.getElementById('val').value;
	var num2 = document.getElementById('num2').textContent;
//	alert(num2) // [object HTMLDiv] 
//	alert(num2.innerHTML); //코로나 나빠요
							//	<span>
							//		날씨가 매우 좋아요
							//	</span>
							
	var preVal = document.getElementsByTagName('pre')[0].textContent;
	console.log(preVal);
	if(preVal.indexOf(val) != -1 || divVal.indexOf(val) != -1){
		alert("검색어 존재함");
	}else{
		alert("검색어 존재하지 않음");
		let result = pre.replace(val, "<b>"+val+"</b>")
		document.getElementsByTagName('pre').innerHTML = result;
	}
	var preVal2 = document.getElementsByTagName('pre')[0].innerHTML[18]
	var preVal2 = document.getElementsByTagName('pre')[0].innerHTML[20]
	console.log(preVal2)
}
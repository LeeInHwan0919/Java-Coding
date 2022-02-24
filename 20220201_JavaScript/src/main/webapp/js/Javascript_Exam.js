<<<<<<< HEAD
function numCheck01(){
=======
function numCheck01() {
>>>>>>> cc4558443a521a6c52326b3ec87120623024e3ba
	console.log("numCheck01");
	// javascript에서 타입
	// 화면에 뿌려져있는 (HTML이 아닌것들-콘텐츠-textNode) node를 가져오면
	// DOM의 방법
<<<<<<< HEAD
	
	//document. tlwkr - document 사용되고 있는 stateless의 페이지
	//document.getElement(s)  : s를 붙인다면 nodeList의 형태로 s를 안붙이면 node형태로 탐색이 된다.
	// ** DOM된 결과는 위치 탐색
	
=======

	//document. tlwkr - document 사용되고 있는 stateless의 페이지
	//document.getElement(s)  : s를 붙인다면 nodeList의 형태로 s를 안붙이면 node형태로 탐색이 된다.
	// ** DOM된 결과는 위치 탐색

>>>>>>> cc4558443a521a6c52326b3ec87120623024e3ba
	//탐색된 위치의 값을 처리하는 방식
	//empty Element(닫힘 tab가 없고 단일) : value 속성(property)으로 가지고 있음
	// markup tab(wel-formed) 한 tag : innerHTML - 자식 노드 전체를 HTML인 String가져옴 ex) <br>값</br>
	//								   textContent - textNode을 가져옴 ex) 값
<<<<<<< HEAD
	
=======

>>>>>>> cc4558443a521a6c52326b3ec87120623024e3ba
	//<input> : form 요소(tag)는 서버(WAS)에 데이터를 <form>태그를 통해서 속성이 action의 위치로 전송할 수 있다.
	//<input>의 type중에 특이사항 : submit - action을 호출
	//                          reset - 처음에 뿌려진 값을 다시 호출
	//<textarea></textarea> : 콘텐츠를 값으로 가짐, pre속성이 적용되기 때문에 공백이 없는 상태 
	//                          textarea -> textarea   ex)하늘\n\r구름 -> 하늘\n\r구름
<<<<<<< HEAD
	//							textarea -> text 달라짐 보이는 그대로 볼 수 있음 ex) 하늘\n\r구름 -> 하늘 구름
	//	전송되는 form요소는 <form>로 작성하는게 좋음
	// 서버로 전송되는 protocol(HTTP)의 규약 : GET, POST, PUT, DELETE ...
	// <form> 요소에서만 동작되는 이벤트 : submit, reset
	
	
	var num = document.getElementsByName('num')[0].value;
	
	//정규화 표현식
	
=======
	//							textarea -> text 달라짐  보이는 그대로 볼 수 있음 ex) 하늘\n\r구름 -> 하늘 구름
	//	전송되는 form요소는 <form>로 작성하는게 좋음
	// 서버로 전송되는 protocol(HTTP)의 규약 : GET, POST, PUT, DELETE ...
	// <form> 요소에서만 동작되는 이벤트 : submit, reset


	var num = document.getElementsByName('num')[0].value;

	//정규화 표현식

>>>>>>> cc4558443a521a6c52326b3ec87120623024e3ba
	//숫자판단
	var regexNum = /^[0-9]/g;
	var numChk = num.search(regexNum); // 인덱스 반환
	alert(numChk); // 정규식을 판단하면 맞다면 0, 아니면 -1
<<<<<<< HEAD
	
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
	
=======

	if (numChk == -1) {
		alert("숫자가 아닙니다.");
	} else {
		alert("숫자입니다.");
	}

	var num = document.getElementById('A');
	console.log(num); // null 탐색을 하였는데 위치에 대한 객체가 없다면 null

	var numb = document.getElementsByName('B'); // nodeList
	console.log(numb); // nodeList

	var numc = document.getElementsByName('B')[0];
	console.log(numc); // undefined

	//	if(numc == null || null == undefined){ // null과 undefined 동등으로 비교연산이 진행됨
	if (numc === null) { // 완벽한 비교에서는 null과 undefined 정확하게 비교
		alert("값을 입력해주세요")
	} else {
		if (isNaN(num)) {
			alert("숫자가 아닙니다")
		} else {
			alert("숫자입니다.")
		}
	}

>>>>>>> cc4558443a521a6c52326b3ec87120623024e3ba
	/*if(isNaN(num1)){
		alert("숫자가 아닙니다.");
	}else {
		alert("숫자입니다.");
	}*/
}

<<<<<<< HEAD
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
=======

function searchStr02() {
	var val = document.getElementById('val').value;
	var num2 = document.getElementById('num2').textContent;
	//	alert(num2) // [object HTMLDiv] 
	//	alert(num2.innerHTML); //코로나 나빠요
	//	<span>
	//		날씨가 매우 좋아요
	//	</span>

	var preVal = document.getElementsByTagName('pre')[0].textContent;
	console.log(preVal);
	if (preVal.indexOf(val) != -1 || divVal.indexOf(val) != -1) {
		alert("검색어 존재함");
//	} else {
//		alert("검색어 존재하지 않음");
//		let result = pre.replace(val, "<b>" + val + "</b>")
//		document.getElementsByTagName('pre').innerHTML = result;
//	}
	var preVal2 = document.getElementsByTagName('pre')[0].innerHTML[18]
	var preVal2 = document.getElementsByTagName('pre')[0].innerHTML[20]
	console.log(preVal2)
}

window.onload = function() {
	var rdo = document.getElementsByName('site');
	console.log(rdo.length);

	for (let i = 0; i < rdo.length; i++) {
		rdo[i].onclick = function() {
			console.log(this.checked, this.value);
			openURL(this.value);
		}
	}
}

function openURL(url) {
	var urlName = url.substring(url.indexOf(".") +  url.lastIndexOf("."));
	console.log(urlName);
	open(url, urlName, "");
}

// return; 함수를 종료
// return false; propagation(전파) <a href='' onclick='return fn()'>이동</a>
// event.preventDefault();
function allchk04(bool) {
	var chks = document.getElementsByName("subject");
	//	return;
	for (let i in chks) {
		chks[i].checked = bool;
	}
}


$(function() { //jQuery에서 window.onload
	$('#all').click(function() {
		if ($('#all').prop('checked')) {
			$('input[type="checkbox"]').prop('checked', true);
		} else {
			$('input[type="checkbox"]').prop('checked', false);
		}

	});
})


function randomNum05() {
	var n = document.getElementById('rdmNum');
	var randomNum = Math.ceil(Math.random() * 20);
	n.value = randomNum;
}

function selPage06() {
	//selected, selectedIndex, options
	var sel = document.getElementById('selsite');
	location.href = sel.options[sel.selectedIndex].value;
}

function sortNum() {
	var doc = document.getElementById('numVal').textContent; //글자들을 가져옴
	//	console.log(doc, typeof doc);

	var arrStr = doc.split(',');
	//	console.log(arr, typeof arr);

	var strResult = arrStr.sort(); //문자 정렬(lexicoraphic, letters)를 기준으로 정렬이 된다.
	//	console.log(strResult);		// 문자형 숫자를 sort를 하기 위해서는 연산이 필요하다.

	//	var strResultNum = arrStr.sort(compare); //숫자 정렬 함수를 생성 사용
	//	console.log(strResultNum);

	//	console.log(reverseStr(strResult));
	bubbleSort(arrStr);//버블정렬실행
}

//문자형 숫자 정렬 법
function compare(a, b) {
	return a - b;
}

//리버스함수
var reverseStr = function(arr) {
	var arrNew = new Array();
	for (let i = 0; i < arr.length; i++) {
		arrNew.push(arr[arr.length - 1 - i]);
	}
	return arrNew;
}

//버블 정렬을 통한 sort
function bubbleSort(arrStr) {
	var len = arrStr.length;
	var tmp;
	for (let i = 0; i < len - 1; i++) {
		for (let j = 0; j < len - 1 - i; j++) {//회차
			//			if(arrStr[j] > arrStr[j+1]){ //1 15 19 2 21
			if (parseInt(arrStr[j]) < parseInt(arrStr[j + 1])) {
				tmp = arrStr[j];
				arrStr[j] = arrStr[j+1];
				arrStr[j + 1] = tmp;
			}
			//			}
		}
	}
	console.log(arrStr);
}

function life() {

	var date = new Date();
	console.log(date.toDateString());
	console.log(date.toLocaleDateString());
	console.log(date.toLocaleString());
	console.log(date.toLocaleTimeString());

	var birthday = document.getElementsByName('birthday')[0];
	var birth = new Date(birthday.value);

	console.log(birth);
	//	console.log(birth.getTime());//살아온 전체일수

//	var life = (birth.getTime() - date.getTime()  / (60 * 60 * 24* 1000);
	//	console.log(Math.ceil(life));

	document.getElementById('dateVal').innerHTML =
		"<b>" + Math.abs(Math.ceil(life)) + "</b>"

	//---------------------------------------------------
	// input의 date type은 출력되는 형태가 javascript Date()와 다르다.
	// 2022-02-24 <-> 2022-2-24

	// getDate(), getMonth(), getFullYear();

	var year = date.getFullYear();
	var month = date.getMonth() + 1; //month는 입력할 때는 -1 출력할때는 +1
	var day = date.getDate();

	//	console.log(year, month, day); //숫자이기 때문에 한자로 표기 -> HTML ex)02...

//	var dateInput = year + "-" +   month +  "-" + day;
	//	console.log("t"+dateInput);

	document.getElementById("nowDate").value = dateInput;

	// 두자리로 변경하기
	month = (month >= 10 ? month : '0' + month);

	//첫째날
	var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
	console.log(firstDay.toLocaleString());

	//마지막 날
	var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0)
	console.log(lastDay.toLocaleDateString());


}


function guguDanView(){
	
} 

}
>>>>>>> cc4558443a521a6c52326b3ec87120623024e3ba

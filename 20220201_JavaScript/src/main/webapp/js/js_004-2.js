/**
 * 
 *//**
	DOM 탐색을 통해서(tagName) 각 위치에 이벤트를 설정해줌\
	this 현재 선택되고 있는 객체를 이야기한다
*/
//window.onload = function(){
//	var btns = document.getElementsByTagName('button');
//	console.log(btns.length);
//	for(let i=0; i<btns.length-1; i++){
//		btns[i].onclick = function(){
//			console.log(this.textContent);
//		}
//	}
//}

//alertTest 주로 경고나 코드 디버깅시 사용
function alertTest(){
	alert("asd");
}

//promptTest 텍스트 박스를 제공해줌, 확인/취소 버튼제공
//확인을 눌렀을 경우 : 값이 없어도 string으로 처리
//취소를 눌렀을 경우 : null로 처리 됨

function promptTest(){
	var txt = prompt('어느 과목을 좋아하세요 /n 1번:자바, 2번:HTML 3번DB')
	console.log(txt);
	switch(txt){
		case "1": alert("재미있어요"); break;
		case "2": alert("싸우지마세요");break;
		case "3": alert("사이좋게 지내세요");break;
		case null: alert("오늘 상태 좋으시네요");break;
		default : alert("1~3사이의 번호를 선택해주세요");
		
	}
	
}

//confirmTest 확인과 취소를 제공해준다 , TRUE/FALSE를 반환
function confirmTest(){
	var bool = confirm("왜 나만 안돼?");
//	var color = $("#choiceColor");
	var color = document.getElementById('choiceColor');
	
	console.log(bool);
	console.log(color.value);
	
	if(bool){
		//$(body).css('backgroundColor',color);
		document.body.style.backgroundColor = color.value;
		
	}else{
		document.body.style.backgroundColor = "#fff";
	}
	
}


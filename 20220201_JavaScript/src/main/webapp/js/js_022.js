/**
 엘리먼트 생성하기 : createElement("태그명");
 속성개체 생성하기 : createAttribute("속성")
 콘텐츠(textNode)생성하기 : createTextNode("내용 입력");
 속성 추가하기: setAttributeNode("attr명"); /setAttribute("속성명","속성값");
 */

function elementCreate(){
	//body에 div를 작성하고, 속성을 입력, 글을 입력하고, loc에 append를 붙여 넣음
	var div = document.createElement("div"); //<div></div>
	var attr = document.createAttribute('style'); //style=
	var text = document.createTextNode('안녕하세요. 추가로 들어왔어요.') //안녕하세요. 추가로 들어왔어요.
	
	//1번 방법
	//속성을 추가한다.
//	attr.nodeValue='border:2px solid blue'; //style='border:2px solid blue'
//	div.setAttributeNode(attr);// <div style='border:2px solid blue'></div>
	
	//2번 방법
	div.setAttribute('style','border:2px solid blue');
	
	
	//공통
	div.appendChild(text);//<div style='border:2px solid blue'>안녕하세요. 추가로 들어왔어요.</div>
	
	//HTML에 존재하는 영역에 생성된 div를 append해줌
	document.getElementById('loc').appendChild(div);
}
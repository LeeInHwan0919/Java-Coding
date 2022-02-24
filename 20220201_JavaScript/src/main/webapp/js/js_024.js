function childAppend(){
	//body에 존재하는 element를 탐색
	var fieldSet = document.getElementById('addElement');
	
	//새로 추가할 element 생상
	var p = document.createElement('p');
	
	//fieldSet의 자식 tag중에 마지막에 붙여 넣음
	
	//1번 노드를 메소드를 통해서 생성후 p에 append한 후 다시 append시켜줌
//	var txt = document.createTextNode('appendChild는 맨 뒤에 붙어요');
//	p.appendChild(txt);

	p.textContent = 'appendChild는 맨 뒤에 붙어요';
	fieldSet.appendChild(p);
}

var cnt=1;
function beforeInsert(){
	var newP = document.createElement('p');
	newP.textContent = 'element 앞에 붙여요'+(cnt++);
	var fieldSet = document.getElementById('addElement');
	
	//붙여 넣을 위치
	var oldDiv = document.querySelector('fieldset>div');
	
	//insertBefore(추가할 element의 위치)
	fieldSet.insertBefore(newP,oldDiv);
	
	//자식의 node(\n인식)를 찾는 것과 element(\n을 인식하지 않음)을 찾음
	var childNode = fieldSet.childNodes;
//	console.log('\\n을 인식',childNode);
	
	var childElement = fieldSet.children;
//	console.log('\\n을 인식하지 않음' , childElement);
}

function moveElement(){
	var moveEle=document.querySelector("fieldset").children[1];
	console.log(moveEle.nodeName, moveEle.tagName);		
	var addEle = document.body;
	addEle.append(moveEle);
}


function addTest(){
var fieldSet = document.getElementById('test01');
var div = document.createElement('div');

div.textContent = 'DOM test';
fieldSet.appendChild(div);
}

function moveTest(){
	var test02 = document.getElementById('test02');
	var test01 = document.getElementById('test01').children[0];		
	test02.appendChild(test01);
}


















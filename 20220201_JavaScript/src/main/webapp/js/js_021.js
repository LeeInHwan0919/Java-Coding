// parentNode : 자신이 속해 있는 NodeTree의 상위 Element를 찾아 줌
function searchParents(){
	var child = document.getElementsByTagName("p")[1];
	console.log(child.innerHTML); //Child02
	
	var div = child.parentNode; //선택된 노드의 부모 nodeTree를 찾음
	console.log(div.tagName);
	console.log(div.textContent);
	console.log(div.innerHTML);
	
	var body = child.parentNode.parentNode;
	console.log(body.tagName);
	
	div.style.backgroundColor='lime';
}

// childNodes : 탐색한 Element의 자식 Element "들"을 찾는다. 

function searchChild(){
	var div = document.getElementsByTagName("div")[0];
	console.log(div.length); // 위치를 탐색(자식이 포함되어있는건 아님)
	
	var divChild = div.childNodes; // 부모 하위에 있는 자식을 찾는다.
	console.log(divChild); 
	
	/*
		childNodes를 사용할 때는 사용되는 엘리먼트들 뿐만이 아니라
		엘리먼트의 구성인 node textNode를 같이 포함한다.
		ex)enter로 구분되어 있지 않다면 생각하는 그대로 갯수가 나오지만 
		만약 enter로 구분되어 있다면 node사이에 textNode가 포함되어 진다.
		<div>'1'<'2'>'3'<'4'>'5'<'6'>'7'</div>
	*/ 
	
	console.log(divChild.length);
	
	for(let i=0; i<divChild.length;i++){
		console.log(divChild[i].tagName);
//		alert(divChild[i]);
	}
	
	/*
		tag는 element의 구성(nodeTree)이 있고 구성은 innerHTML로 읽어 올 수 있음
		하지만 element의 구성 요소중에서 주석 혹은 그외의 것들이 포함이 된다면 모두 node로 인식을한다.
		만약 한줄로 작성이 되어 있다면 하나의 element인식
	*/ 
	
	divChild[5].style.color="green";
	
	
}

function domExam(){
	var p = document.getElementsByTagName('p')[3];
	var div = p.parentNode;
	div.style.backgroundColor = 'yellow';
	
	var div2 = document.getElementsByTagName('div')[3];
	var pChild = div2.childNodes[1];
	pChild.style.fontSize = '30px'
}

















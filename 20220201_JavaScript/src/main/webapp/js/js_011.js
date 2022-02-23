/**
	1) 유효값
	2) Element추가
	 ->dom탐색 후에 html코드를 입력 creatElement
 */
function makeAnt(s){
	var result = "";
	var c = s.charAt(0);
	var cnt = 1;
	
	for(var i=1; i<s.length; i++){
		if(c == s.charAt(i)){
			cnt++;
		}else{
			result = result + c + cnt;
			c = s.charAt(i);
			cnt = 1;
		}
	}
	result = result + c + cnt;
	console.log(result);
	return result;
}

function antStage(stage){
	var s = "11";
	for(var i = 0 ; i < stage; i++){
		console.log(s);
		s = makeAnt(s);
	}
	return s;
}

function antPrint(){
	var inputVal = document.getElementById("antValue");
	
	var val="";
	//숫자만 입력 받는 유효값
	
	if(isNaN(inputVal.value)){//숫자가 아니면 true
		alert("숫자만 입력해 주세요.")
		inputVal.value='';
		inputVal.focus();
	}else if(inputVal.value >= 10){
		alert("10 이하의 숫자만 입력해 주세요.")
		inputVal.value='';
		inputVal.focus();
	}
	//화면에 HTML을 만들어서 append(네이버 댓글 답글)
	else{
		// 1) html tag를 concatenation을 통해서 생성후 교체 innerHTML
//		for(var i = 0; i < inputVal.value;i++){
//			val += "<span>"+andStage(i)+"</span><br>"
//		}
//		document.getElementById("antSequence").innerHTML = val;
		
		//2) createElement 방법 tag를 createElement 함수를 생성한 후 자식 node append함
		// 붙여 넣을 상위 tag를 생성한다.
		var div = document.createElement("div"); // <div></div>
		
		//붙여 넣을 하위 tag를 생성한다
		for(var i = 0; i< inputVal.value;i++){
			var childDiv = document.createElement("div");
			childDiv.innerHTML = antStage(i);
			
			//생성된 자식 tag를 부모 tag에 붙여 넣는다(append)
			div.appendChild(childDiv);
		}
		
		//document에 붙이고 하는 영역에 생성된 div를 자식을 append를 함
		var print = document.getElementById("antSequence");
		print.innerHTML = "";
		print.style.background = "skyblue";
		print.appendChild(div);
	}
}

//1
//1 1
//1 2
//1 1 2 1
//1 2 2 1 1 1
//onSequence
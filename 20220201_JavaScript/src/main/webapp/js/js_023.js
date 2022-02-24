function createImg(){
	var radioBtn = document.getElementsByName('rdoBtn');
	var radioValue ='';
	for(let i=0; i<radioBtn.length;i++){
		if(radioBtn[i].checked){
			radioValue = './image/'+radioBtn[i].value;
		}
	}
	
	console.log(radioValue)
	
	//img tag생성
	var img = document.createElement('img');
	img.setAttribute('src',radioValue);
	
	// 붙여넣은 위치를 탐색
	var div = document.getElementById('imgView');
	
	//div에서 자식 노드가 있다면 삭제하거나 replace를 하여 새로운 img를 붙여 넣음
	//element의 구성은 작성되어 있는 node에 따라서 textNode를 포함하고 있음
	//현재의 div의 element의 구조는 text, img, text로 구성되어 있기 때문이다.
	//firstChild를 삭제하면 첫번째인 textNode가 삭제되고 두번째 삭제일때 img가 삭제된다.
//	if(div.childNodes.length != 0){
//		var divImg = div.firstChild; //div가 가지고 있는 tag중 무조건 첫번째
//		div.removeChild(divImg);
//	}

	// 삭제 대상의 element를 직접적으로 삭제
//	var img = document.getElementsByTagName('img')[0];
//	div.removeChild(img);

	var oldImg = document.querySelector("#imgView>img");
	div.replaceChild(img, oldImg); //앞에 바꿀 node, 뒤에는 교체대상
}
















function tableInput(){
    /*
    form을 사용하는 이유는 값을 전달하기 위한 영역 => action, method
    값을 유효성 처리하는 로직이 필요로 함
    기초적인 유효값 처리는 required를 통해서 값의 유무만 판단할 수 있음
    화면에 input 4개가 있음, DOM탐색을 4번 해야함

    form tag는 탐색하는 가지로 탐색을 할 수 있다.
    1) var doc = document.forms[0]; -> tag검색
    2) var doc = document.frm; -> name검색
    3) var doc = document.get ElementXXXX('명명'); -> DOM 탐색
    

    
    
    form 요소의 이벤트 : submit, reset => 반드시 form tag안에 존재해야함
    <input type='submit' value='전송'> => 클릭을 누르면 form action이 동작하여 이동
    javascript를 통해서 동작
    doc.submit();
    */
	var doc = document.frm;

    var vals = [doc.id.value, doc.pw.value, doc.address.value, doc.phone.value];
    console.log(vals);

    //유효값(Validation) exception과 error 과 validation 은 다름
    for(var i=0; i<vals.length; i++){
        if(vals[i]==''){ // node면 null, nodeList(undefined:name[0])
            alert("모든 값을 입력해주세요");
            return;//propagation
        }
    }
    console.log("for문 이후 작성");

//생성된 row의 갯수를 10개 제한
var tbody = document.getElementById('addr');
var trLength = tbody.children.length; //tbody의 element의 갯수
console.log(trLength);

// javascript의 3항연산자는 반환되는 변수를 담지 않아도 문법 오류가 발생 하지 않음(동적 바인딩)
//  참과 거짓의 기능이 달라도 됨
trLength<10 ? tbody.appendChild(createRow(vals)):alert('10개 까지만 추가 가능합니다.');

}

// 상위 form에서 완성된 값을 createElement를 통해서 tr을 생성
 function createRow(vals){
	var tr = document.createElement('tr');
	for(var i in vals){
		var td = document.createElement('td');//$tr = $('<tr></tr>')
		td.textContent = vals[i];
		tr.appendChild(td);
	}
	
	var delBtn = document.createElement('td');
	delBtn.innerHTML="<input type='button' value='삭제' onclick='delRow(this)'>";
	
	tr.appendChild(delBtn);
	return tr;
}

function delRow(elem){
	console.log(elem);// this onclick을 포함하고 있는 input Element이다.
	var delTr = elem.parentNode.parentNode; //input > td > tr
	var tbody = document.getElementById('addr');
	tbody.removeChild(delTr);
}

function deleteVal(){
	var tbody = document.getElementById('addr');
//	tbody.removeChild(tbody.lastChild);
	tbody.innerHTML="";
}













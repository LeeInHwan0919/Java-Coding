//명시적 함수는 이름가지고 있는 함수
function function01(){
	console.log('명시적 함수 : function 함수명()');
}

//익명함수 함수인데 함수명을 가지고 있지 않고 변수에 담겨있음
var function02 = function(){
	console.log('익명적함수: function(){}');
};

//함수 리터럴
//즉, 변수에 담겨져있는 function이 아닌 값의 역할을 하는 function
//클로저

function literalFn(literal){
	literal("반갑다 ㅋㅋ")
}

function function03(){
	literalFn(function(msg){alert("클로저:"+msg);});
}

var literal = function(msg){alert("전달받았다 ㅋㅋ 어쩔거냐" +msg);};

function valueArguments(){
	console.log(arguments[0]);
	console.log(arguments[1]);
	console.log(arguments[2]);
	console.log(arguments[3]);
	
	var val='';
	// javascript에서의 향상된 for문은 두개(in, of)의 연산자를 가지고 있음
	// in은 Array의 index 번호를 반환
	// of는 Array의 값을 반환
	for(let iter in arguments){
		console.log(iter,arguments[iter]);
	}
	
	for(let iter in arguments){
		console.log("♥"+iter);
	}
	
//	var p = document.getElementsByTagName("p");
//	for(let i in p){
//		console.log(i, p[i]);
//	}
	
	
}

function closureFn(val){
	function addVal(msg){
		alert(val+":"+msg);
}
		return addVal;
}

var amEdu = closureFn("database");
//		function addVal(this.value){
//		alert(val+":"+msg);
//}
//		return addVal;
//}

var pmEdu = closureFn("자바스크립트");

function closureTest(){
	closureFn('js')("전민균")
	// closureFn('js') =>function addVal(js) { => ("전민균") => function addVal('전민균')
	// alert(js+":"+msg);
	//=>function addVal('전민균') {alert(js+":"+msg)}
	//=> alert(js+":"+전민균);
	}
	
	
//------------------값전달
//string /number
// html에서 가져오는 값들은 모두다 string

function valueCheck01(v){
	console.log(typeof v, v);
}	 

function valueCheck02(s){
	console.log(typeof s, s);
}

function valueCheck03(k){
	console.log(typeof k, k);
}	

// String seq = "a";
// String html ="";
// html += "<input type ='button' onclick = 'deleteBoard('"+seq+"')'>";
// "valueCheck03(a)"
	

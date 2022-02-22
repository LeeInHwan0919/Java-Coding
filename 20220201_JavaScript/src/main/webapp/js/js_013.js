// 1.배열의 선언방법
var arrayObj = new Array();//배열 객체의 선언
var arrayObjLiteral = ["a1", "a2", 3, 4]; //타입의 구분이 없음
console.log(arrayObj, typeof arrayObj);
console.log(arrayObjLiteral, typeof arrayObjLiteral);

// 2.객체의 선언 방식의 종류
var array02 = new Array();// 선언
var array03 = new Array(5);// 배열의 생성 크기를 선언해줌
var array04 = new Array(1, 2, 3, 4, 5);//두개이상 > 값으로 인식

array02[0] = 10;
array02[2] = 20;

console.log(array02.length);
console.log(array02[0]);
console.log(array02[1]); //undefined
console.log(array02[2]);
console.log("=======================");

//배열의 크기를 선언함
for(var i=0; i<array03.length; i++){
	console.log('㉾',array03[i]);
}

//document.getElementById('view1').innerHTML = array03[0];
//document.getElementById('view2').value= array03[0]+"";
array04[5] = 10;
console.log(array04[5]);
console.log(array04.length);

//다차원 배열
function multiArray(){
	var arrlen = 3;
	var arr = new Array(arrlen);
	for(var i=0; i<arr.length; i++){
		arr[i]=new Array(arrlen);
	}
	arr[0][0] = "apple";
	arr[0][1] = "banana";
	arr[0][2] = "tomato";
	
	arr[1][0] = 1;
	arr[1][1] = 2;
	arr[1][2] = 3;
	
	arr[2][0] = ["java", "javascript"] 
	arr[2][1] = ["jsp", "servlet"]
	arr[2][2] = ["oracle", "mysql"]
	
	console.log(arr);
	console.log(arr[2][2][1]); //mysql
	console.log("=================");
	
	
	for(var i=0; i<3; i++){
		for(var j=0; j<3; j++){
			console.log(arr[i][j]);
		}
	}
	
}

function joinFn(){
	var array01 = ["apple","peach", "lemon", 3];
	var array02 = [1, 2];
	var array03 = [1, 1];
	
	var joinArray = array01.join("-");//배열의 각요소를 conjunction을 포함하여 문자열로 만든다.
	console.log(joinArray);
	console.log(typeof joinArray);
	
	var arraySum = array02.concat(array03);
	console.log(arraySum);
	console.log(arraySum.length);
}

function sortStringFn(){
	var arr = ['a','b','c','d'];
	var arrS = ['1','10','4'];
	arr.sort();
	arrS.sort();
	console.log(arr);
	console.log(arrS);
}

function sortNumberFn(){
	var arr = [1,20,2,5,3,8];
//	arr.sort();
//	console.log(arr); arr에 숫자가 들어 가 있어도 크기 비교를 할 수가 없다.
	arr.sort(compare);
	console.log(arr)
}

function compare(a,b){
	return a-b;
}

function reverseFn(){
	var arr = ["a","e","b"];
	arr.sort();
	arr.reverse();//desc를 만들고 싶다면 반드시 sort한 후 reverse하여 반대로 출력한다.
	console.log(arr);
	
	var brr = [1,10,5,5.14,'a',null];
	brr.sort(compare);
	brr.reverse();
	console.log(brr);
	// 배열의 모든 sort 는 java와 같이 타입을 따지는게 아님
	// 다음 타입의 집합체로 가능하기 때문에 무조건 문자로 취급
	// 따라서 숫자의 경우는 무조건 비교함수를 만들고 
	// desc를 만들기 위해서는 반드시 sort를 한 후 반대로 출력이 되는 reverse함수를 실행하면된다.
}

function saveArray(){
	var queue = new Array();
	console.log(typeof queue);
	console.log(queue);
	
	//index에 상관없이 값을 입력 push
	queue.push(1);
	queue.push("first");
	queue.push("second");
	queue.push("third");
	console.log(queue);
	console.log(queue[0]);
	
	//shift 배열의 앞부터 잘라냄
	var a0 = queue.shift();
	console.log(a0);
	console.log(queue[0],queue.length);
	
	//pop은 배열의 뒤부터 잘라냄
	var b0 = queue.pop();
	console.log(b0);
	console.log(queue[queue.length-1],queue.length);
}


function sliceFn(){
	var array01 = [1,2,3,4,5];
	//slice는 잘라내는 index를 포함합니다.
	//end-1를 한다.
	//java 사용하는 subString과 유사하구요.
	
	var array01New = array01.slice(1); // 1::1
	console.log(array01New);
	
	var array02 = new Array(4);
	array02[0] = new Array(1,2);
	array02[1] = new Array(3,4);
	array02[2] = new Array(5,6);
	array02[3] = new Array(7,8);
	
	var array02New = array02.slice(1,3);
	console.log(array02New);
}

















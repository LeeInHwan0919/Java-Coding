onload = function() {
	//	var btns = document.getElementsByTagName('button');
	//	for(let i=0; i<btns.length;i++){
	//		btns[i].onclick = testDate01;
	//	}	
	//}
	document.getElementsByTagName('button')[0].onclick = testDate01;
	document.getElementsByTagName('button')[1].onclick = testDate02;
	document.getElementsByTagName('button')[2].onclick = testDate03;
	document.getElementsByTagName('button')[3].onclick = testDate04;
	document.getElementsByTagName('button')[4].onclick = testDate05;
}
function testDate01() {
	console.log("testDate01");
	var outputToday = document.getElementById("today")
	var date = new Date();
	// java에서의 pattern변환 : SimpledateFormate
	// DB TO_DATE, TO_CHAR

	//		outputToday.innerHTML=date;
	//		outputToday.innerHTML=date.toDateString();
	//		outputToday.innerHTML=date.toLocaleDateString();
	//		outputToday.innerHTML=date.toLocaleString();
	outputToday.innerHTML = date.toLocaleTimeString();
	// java 혹은 DB에서 조심해야 할것
	// month -1을 해주어야 함.
	// java.util.Calendar 날짜의 선언은 Calendar.getInstance(), cal.set(year, month-1, date);
	// java.util.GregorianCalendar GreforianCalendar gCal = new GreforianCalendar(); 

}
function testDate02() {
	console.log("오늘날짜(표현)");
	var dayOfWeek = ["일", "월", "화", "수", "목", "금", "토"];

	var date1 = new Date('2022-02-22');
	var date2 = new Date('2022-2-22');
	var date3 = new Date('2022.2.22');
	var date4 = new Date('2022/2/22');
	var date5 = new Date('2022_2_22');
	console.log(date1.toLocaleDateString());

	var date = new Date();
	var year = date1.getFullYear(); //getYear로하면 두자리로 표시가 되기때문에 full로 찍어야한다.
	var month = date1.getMonth() + 1;//month는 배열이기 때문에 +1처리를 해주어야 한다.
	var date = date1.getDate();
	var day = date1.getDay();
	console.log(year, month, date, dayOfWeek[day])
}
function testDate03() {
	console.log("특정 날짜 구하기");
	// 표준화 되어있는 세팅 표기법 -, /, .
	var date = new Date();
	var date1 = new Date('2022-02-22');

	// 만약에 한개의 값들을 단일로 입력 할 때 month를 조심
	var date2 = new Date('2022', 2 - 1, '22');
	console.log(date1);
	console.log(date2);
}
function testDate04() {
	console.log("경과날짜 구하기");
	//화면에 있는 value혹은 content

	var dates = document.getElementById('dates'.value);
}
function testDate05() {
	console.log("testDate05");
}
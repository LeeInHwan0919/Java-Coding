package com.min.test;

//import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Calendar_Use_Switch {

	public void calendarAPI() {
		// method로 계산을 하여 만년달력을 만들어 냄.
		// java에서 날짜에 관련된 클래스
		// java.util.Date, java.sql.Data, (권고사항) java.util.Calendar
//		Date d = new Date(2022, 3, 3); //deprecate된 메소드는 가능하면 사용하지 말자하.

		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR) + "현재년도");
		cal.set(2022, 0 - 1, 1); // Calendar 클래스에 년월일 세팅
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "입력된 요일");
		int dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);

		// 선택 판단문
		// 1) switch fall through
		// 2) key, value는 반드시 같은 타입이어야 합니다.
		// 3) (권고사항) 비교대상은 정수만. jdk1.7이상부터는 String 도 비교가능
		String key = "커피";
		switch (key) {
		case "커피":
			System.out.println("아이스 아메리카노");
//			break;
		case "홍차":
			System.out.println("따뜻한 밀크티");
			break;
		default:
			System.out.println("기타 포션");
			break;
		}
	}

}

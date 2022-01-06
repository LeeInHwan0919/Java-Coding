package com.min.edu;

public class CalendarMain {

	public static void main(String[] args) {
		Calendar cal = new Calendar();
//		int now = cal.calDays(2022,1, 6);
//		int dob = cal.calDays(1997,  9, 19);
//		System.out.println("20220106의 누적 일수 " + now);
//		System.out.println("내가 살아온 일수 : " + (now-dob));

//		int dayOfWeek = (cal.calDays(2022, 9, 19)+1)%7;// 요일을 계산해줌
//		System.out.println("20220301의 요일 : " + dayOfWeek);

//		int lastDay = cal.getDayOfMonth(4, 2);
//		System.out.println(lastDay);
//		for (int i = 1; i <= 12; i++) {
//			cal.print_calendat(2022, 1);
//			System.out.println("\n\n");
//		}
		
		CalendarAPI calAPI = new CalendarAPI();
		calAPI.print_calendat(2022, 3);
		
	}
}

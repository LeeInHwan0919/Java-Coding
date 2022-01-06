package com.min.edu;

public class Calendar {

	private final int[] LEAP = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 윤년
	private final int[] PLAIN = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 평년

	// TODO 001. 윤년판단 메소드
	/**
	 * 윤년 판단 메소드
	 * 
	 * @param year 판단 년도
	 * @return true윤년 / false평년
	 */
	private boolean isCheckLeap(int year) {
		boolean isc = false;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			isc = true;
		}

		return isc;
	}

	// TODO 002. 입력 받은 이전 년도 까지 일수를 계산하는 메소드
	/**
	 * 입력받은 전 년도 까지의 일수를 누적해 주는 메소드
	 * 
	 * @param year 이전 년도
	 * @return 1년부터~ year 이전까지 누적 일수
	 */
	private int calDays(int year) {
		int sumDays = 0;
		for (int i = 1; i < year; i++) {
			if (isCheckLeap(i)) {
				sumDays += 366;
			} else {
				sumDays += 365;
			}
		}
		return sumDays;
	}

	// TODO 003. 구하고자 하는 년도의 월 이전까지의 누적
	private int calDays(int year, int month) {
		int SumDays = calDays(year);
		for (int i = 1; i < month; i++) {
			if (isCheckLeap(year)) {
				SumDays += LEAP[i - 1];
			} else {
				SumDays += PLAIN[i - 1];
			}
		}
		return SumDays;
	}

	// TODO 004. 년월일을 누적하는 메소드
	/**
	 * 년 월일을 최정적으로 누적하여 최종 일수를 만들어 주는 메소드
	 * 
	 * @param year  구하고자하는 년도
	 * @param month 구하고자하는 월
	 * @param day   구하고자하는 일
	 * @return 1~year + 1~month + day 의 총합 (일수)
	 */
	private int calDays(int year, int month, int day) {
		int sumdays = calDays(year, month);
		sumdays += day;
		return sumdays;
	}

	// TODO 005. 출력한 달력의 최대 일수
	/**
	 * 입력받은 월의 최대 일수를 구하는 함수
	 * 
	 * @param year  구하고자 하는 년도
	 * @param month 구하고자 하는 월
	 * @return 윤년을 판단한 월의 최대 일 수
	 */
	private int getDayOfMonth(int year, int month) {
		int days = 0;
		if (isCheckLeap(year)) {
			days = LEAP[month - 1];
		} else {
			days = PLAIN[month - 1];
		}
		return days;
	}

	private int beforeDays(int year, int month) {
		int beforeDays = 0;
		if (month == 1) {
			beforeDays = getDayOfMonth(year - 1, 12);
		} else {
			beforeDays = getDayOfMonth(year, month - 1);
		}
		return beforeDays;
	}

}

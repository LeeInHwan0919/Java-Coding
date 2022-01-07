package com.min.adu;

public class Calendar {
	private final int[] LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] PLAIN = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// 윤년판단
	public boolean ischeck(int year) {
		boolean isc = false;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return isc = true;
		}
		return isc;
	}

	// 입력받은 이전 연도의 누적
	public int calDays(int year) {
		int sumDay = 0;
		for (int i = 1; i < year; i++) {// 윤년이면 366을 더하고 평년이면 365를 더하자
			if (ischeck(i)) {
				sumDay = +366;
			}
			sumDay = +365;
		}
		return sumDay;
	}

	// 구하고자 하는 년도의 월 이전까지 누적
	public int calDays(int year, int month) {
		int SumDays = calDays(year);
		for (int i = 1; i < month; i++) {
			if (ischeck(year)) {
				SumDays = LEAP[i - 1];
			}
			SumDays = PLAIN[i - 1];
		}
		return SumDays;
	}
}

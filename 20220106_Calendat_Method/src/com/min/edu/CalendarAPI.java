package com.min.edu;

import java.util.Calendar;

public class CalendarAPI {
	public void print_calendat(int year, int month) {
		System.out.printf("\t\t%d년도\t%d월\n", year, month);
		System.out.print("일\t월\t화\t수\t목\t금\t토\n");
//		int dayOfWeek = (calDays(year, month, 1) + 1 - 1) % 7;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-1; // 2022	3	1

//		int dayOfMonth = this.getDayOfMonth(year, month);
		int dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

//		int beforeOfMonth = beforeDays(year, month);
		cal.set(year, month - 2, 1);
		int beforeOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = beforeOfMonth - dayOfWeek + 1; i <= beforeOfMonth; i++) {//?? 22    28    ++ 
			System.out.printf("%d\t", i);
		}

		for (int i = 1; i <= dayOfMonth; i++) {// 날짜
			System.out.printf("%d\t", i);
			if ((dayOfWeek + i) % 7 == 0) {
				System.out.println();
			}
		}

		// ---------------------------------------//
		int afterDays = 7 - (dayOfMonth + dayOfWeek) % 7;
		for (int i = 1; i <= afterDays; i++) {
			System.out.printf("%d\t", i);
		}
	}
}

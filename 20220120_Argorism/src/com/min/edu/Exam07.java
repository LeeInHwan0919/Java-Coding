package com.min.edu;

import java.util.Arrays;

public class Exam07 {

	// 집의개수 최소위치 최대위치 -> 배송 못한 집
	public int[] solution(int n, int min_position, int max_position, int[] positions) {
		int[] result = null;
		// 1) 범위 min_position ~ max_position 까지 일정한 간격(정수)
		int 간격 = (max_position - min_position) / (n - 1);
		System.out.println(" 집들의 간격 : " + 간격);

		// 2) 집의 위치( 전체집)
		Integer[] house = new Integer[n];
		for (int i = 0; i < n; i++) {
			house[i] = min_position + 간격 * i;
		}
		System.out.println("전체 집의 위치 값:" + Arrays.toString(house));

		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < house.length; j++) {
				if (house[j] != null && positions[i] == house[j]) {
					house[j] = null;
				}
			}
		}
		System.out.println("배달 되지 않은 집 : " + Arrays.toString(house));
		System.out.println(positions.length);

		result = new int[n - positions.length]; // 전체집에서 - 배달집

		int idx = 0;
		for (int i = 0; i < house.length; i++) {
			if (house[i] != null) {
				result[idx++] = house[i];
			}
		}

		System.out.println("최종 미배송지 : " + Arrays.toString(result));

		return result;
	}

}

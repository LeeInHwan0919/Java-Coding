package com.min.edu;

import java.util.Arrays;

public class Exam07 {

	// ���ǰ��� �ּ���ġ �ִ���ġ -> ��� ���� ��
	public int[] solution(int n, int min_position, int max_position, int[] positions) {
		int[] result = null;
		// 1) ���� min_position ~ max_position ���� ������ ����(����)
		int ���� = (max_position - min_position) / (n - 1);
		System.out.println(" ������ ���� : " + ����);

		// 2) ���� ��ġ( ��ü��)
		Integer[] house = new Integer[n];
		for (int i = 0; i < n; i++) {
			house[i] = min_position + ���� * i;
		}
		System.out.println("��ü ���� ��ġ ��:" + Arrays.toString(house));

		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < house.length; j++) {
				if (house[j] != null && positions[i] == house[j]) {
					house[j] = null;
				}
			}
		}
		System.out.println("��� ���� ���� �� : " + Arrays.toString(house));
		System.out.println(positions.length);

		result = new int[n - positions.length]; // ��ü������ - �����

		int idx = 0;
		for (int i = 0; i < house.length; i++) {
			if (house[i] != null) {
				result[idx++] = house[i];
			}
		}

		System.out.println("���� �̹���� : " + Arrays.toString(result));

		return result;
	}

}

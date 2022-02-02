package com.min.edu;

import java.util.Arrays;
import java.util.Comparator;

public class Exam05 {

	public long solution(int[][] goods, int[][] coupons) {
		long answer = 0;

//		int[][] goods = {{25400,2},{10000,1},{31600,1}};
//		int[][] coupons = {{5, 3},{23, 2}, {11, 2}, {9, 5}};

		// 1) ������������ ū ������ ū ������ �������� �����ϱ� ���ؼ� pbr�� ����ϱ� ���ؼ�
		sortArray1(goods);
		sortArray2(coupons);

		// 2) ���� ��ǰ�� ������ 0, ������ ������ 0 => ��ǰ�� ���� ���� ����
		long a = 0; // ���� �ݾ�
		int ��ǰ���� = 0;
		int co = 0; // coupon

		for (int i = 0; i < goods.length; i++) {
			��ǰ���� = 0;
			while (co < coupons.length && ��ǰ���� < goods[i][1]) {
				if (coupons[co][1] != 0) {
					a += goods[i][0] * ((double) coupons[co][0] / 100);
					��ǰ����++;
					coupons[co][1]--;
				} else {
					co++;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < goods.length; i++) {
			sum += (goods[i][0] * goods[i][1]);
		}

		System.out.println("������� ����? " + (sum-a));

		return answer;
	}

	// 2���� �迭 sort
	public void sortArray1(int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				final int tmp1 = o1[0];
				final int tmp2 = o2[0];
//				return Integer.compare(tmp1, tmp2); //��������
				return Integer.compare(tmp2, tmp1); // ��������

			}
		});
	}

	public void sortArray2(int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
//				return o1[0]-o2[0]; //��������
				return o2[0] - o1[0]; // ��������
			}
		});
	}
//	Arrays.sort(arr, (o1,o2)-> {return o1[0]-o2[0];});
//	Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]).reversed());

	public void sortArray3(int[][] arr) {
		Arrays.sort(arr, (t1, t2) -> { // ��������
//			Arrays.sort(arr, (t2,t1) -> { // ��������
			if (t1[0] == t2[0]) {
				return Integer.compare(t1[0], t2[0]);
			} else {
				return Integer.compare(t2[0], t1[0]);
			}
		});
	}

}
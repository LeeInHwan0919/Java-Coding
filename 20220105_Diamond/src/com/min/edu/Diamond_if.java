package com.min.edu;

/**
 * 조건을 가지고 중간을 기점으로 변수를 증가/감소하여 반복의 횟수를 제어하자 1) if는 3항연산자와 호환이 되지 않는다! 2) 반환은 단
 * 1회만 된다 3) 기능을 분리하여 메소드를 작성해야 한다.
 * 
 * @author Lee In Hwan
 *
 */
public class Diamond_if {

	static int j2 = 0;// static , instance(전역), local(지역)

	public static void dia_if(int stage) {
		// 입력받은 stage의 중간값(홀수만 입력 받아야 함)
		int mid = stage / 2;

		for (int i = 0; i < stage; i++) {
			for (int j = 0; j < mid - j2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * j2 * 1; j++) {
				System.out.print("◆");
			}
			System.out.println();

			// 1)변하는 값을 mid값과 현재 층을 판단하여 j2를 증가혹은 감소하면 되겟죠
			if (i < mid) {
				j2++;
			} else {
				j2--;
			}

			// 2) for문은 삼항연산자를 처리할 수 없다.
			//j2 = (i < mid) ? j2++ : j2--;
			//j2 = (i < mid) ? ++j2 : --j2;
			//int tmp = (i < mid) ? j2++ : j2--;
			
			// 3) 기능을 분리하여 3항연산자를 사용
			//check_mid(i, mid);
		}//for문
		
	}//dia_if 메소드
	
//	private static int check_mid(int i, int mid) {
//		return (i<mid)?j2++:j2--;
//	}

	private void printOneDiamond(int n) {// (조건문) ? 참 : 거짓

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {// 4 3 2
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {// 1 3 5
				System.out.print("*");
			}
			System.out.println();
		}

		for (int j = 0; j < n; j++) {
			for (int j2 = 0; j2 < j; j2++) {// 3 4
				System.out.print(" ");
			}
			for (int j2 = 0; j2 < n - 2 * j; j2++) {// 3 1
				System.out.print("*");
			}
			System.out.println();
		}

	}
}

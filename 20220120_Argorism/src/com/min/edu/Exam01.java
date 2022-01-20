package com.min.edu;

public class Exam01 {
	
	// 입력 받은 숫자를 한자리가 될때가지 연산을 진행해 달라
	// 첫번째 요구분석 진행되는 횟수를 알 수가 없다
	// 두번째 종료조건 1자리
	
	public void exam_2(int n) {
		int result = 0; // 결과를 누적
		
		//1) 입력받은 숫자를 각 요소별로 자르기 위해서 String 으로 변환
		String intStr = String.valueOf(n);
		while (true) {
			char[] charArray = intStr.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				result += (charArray[i]-'0');
				
			}
			if(result/10 == 0) {
				break;
			}
			intStr = String.valueOf(result);
			result = 0;
		}
		
		System.out.printf("%d 입력받은 숫자의 최종결과 %d\n", n, result);
	}
	
	
	
	
	//1) 만약에 조건이 입력받은 정수의 각요소를 더해서 새로운 숫자를 만들어 내자
	public void exam_1(int n) {
		int answer = 0;
		
		// 입력받은 n을 각 요소별로 분리
		// 연산 나머지 /몫 , 문자열 split, 문자열 charAt(), 문자열 toCharArray() 
		// 1) 입력 받은 숫자를 요소로 구분하기 위해서 String 
		String result = String.valueOf(n);
		
		// 2) 요소별로 구분한다
		String[] array = result.split("");
		
		// 3) 각요소를 더한다
		for (int i = 0; i < array.length; i++) {
			answer += Integer.parseInt(array[i]);
		}
		
		System.out.printf("%s의 각요소의 합 %d/n", result, answer);
	}
}

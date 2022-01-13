package com.min.edu;

public class AntQuiz {

	public void antQuizIterator(int stage) {
		String val = "1";
		for (int i = 0; i < stage; i++) { // 반복으로만 사용
			String result = antProcess(val);
			System.out.println(result);
			val = result;
		}
	}
	
	private String antProcess(String val) {
		String answer = ""; // 최종 결과를 누적하는 변수
		char init = val.charAt(0); // 처음에 비교대상이 되는 기준값
		int cnt = 1;

		// 수열의 연산 범위, 입력받은 문자열의 끝 length-1
		for (int i = 1; i < val.length(); i++) { // index0은 비교대상의 값으로 사용되었기 때문에 1부터 시작
			if (init == val.charAt(i)) { // 비교대상과 차례대로 뒤의 요소를 비교함
				cnt++; // 뒤에 값과 같다면 반복이 "여러개 이다" 로직으로 횟수를 증ㅈ가
			} else { // 뒤에 값과 같지 않다면 현재 비교대상을 누적 ex) "1" n개 누적 다음 연산으로 진행
				answer = answer + init + cnt; // 누적변수(String) + (concatenation) + char + int; 즉, 문자열이 맨 앞에서 연산되기 때문에 모든 결과는 concate으로 동작 된다.
				// 이전에 사용된 변수를 초기화 / 비교대상 , cnt
				// 현재 확인되고 있는 index i값의 char 값을 init에 대입
				init = val.charAt(i);
				cnt = 1;
			}
		}
		answer = answer + init + cnt;
		return answer;
	}
}

package com.min.edu;
/**
 * 1)생성된 학생정보(Student) 객체를 입력받아 이쁘게 출력
 * 2)생성된 학생정보(Student) 객체를 입력받아 이쁘게 문자열로 만들어 반환
 * @author ldkko
 *
 */
public class StudentPrint {

	//1)생성된 학생정보(Student) 객체를 입력받아 이쁘게 출력
	static void studentView01(Student s) {
		System.out.printf("이름: %s,나이: %d, 주소:%s%n", s.getName(), s.getAge(),s.getAddress());
		
	}
	
	//2)생성된 학생정보(Student) 객체를 입력받아 이쁘게 문자열로 만들어 반환
	static String studentView02(Student st) {
		//반환타입을 초기화
		String answer =null;
		
		answer = String.format("이름: %s,나이: %d, 주소:%s%n 뀨", st.getName(), st.getAge(),st.getAddress());
		
		return answer;
	}
	
	
}

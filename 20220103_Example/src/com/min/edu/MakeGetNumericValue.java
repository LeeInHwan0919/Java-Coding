package com.min.edu;

public class MakeGetNumericValue {
	
	
	public static int getNumericValue(char c) {
		int result = 0;
		
		
		if(c >= 48 && c <= 57) {
			//char의 index(codePoint)를 연산을 통해서 정수 값으로 만들어 준다.
			result = c-48;
		}else {
			result = 777;
		}
		
		
		return result;
	}
	
	
}

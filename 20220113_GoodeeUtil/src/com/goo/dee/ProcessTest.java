
package com.goo.dee;

/*
 *	 사용자 예외처리
 *  일반 클래스(POJO)를 특정한(예외처리 부모 java.lang.Exception)부모를 extends하면
 *  일반클래스에서 부모의 특징을 물려받는 객체가 된다.
 *  즉, 아래의 NonAcceptException 클래스명 때문에 예외를 처리 할 수 있는 클래스가 되는 것이 아닌
 *  Exception을 extends 하였기 때문에 예외가 처리 할 수 있는 클래스가 된다.
 *  여기서 예외처리는 자신이 처리하는 try~catch, 실행시키는 곳에서 처리하는 throws로 구분된다.
 */

/**
 * 수업에서 만들어 놓은 사용자 예외 처리 클래스
 * @author GDJ44
 * @since 2022.01.13
 */
public class ProcessTest {

	public int Choice(int n) throws Exception {
		
		int result = 0;
		
		if(n%2 == 1) {
//			System.out.println("홀수 입니다. 사용하지 마세요");
			System.out.println("홀수를 . 사용하지 마세요");
			throw new NonAcceptException();
		}
		
		return result;
	}
}

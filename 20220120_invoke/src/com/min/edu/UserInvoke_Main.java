package com.min.edu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserInvoke_Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String choice = "A"; // 실행시킬 메소드의 이름
		
		// 사용할 메소드를 선언해야 줘야한다.
		Method f = Other.class.getMethod(choice, String.class);
		Other o = new Other();
		f.invoke(o, "네 A입니다");
	}

}

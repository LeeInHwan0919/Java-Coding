package com.min.edu;

import com.goo.dee.GoodeeUtil;

public class PrintMain {

	public static void main(String[] args) {
		PrintClass pc = new PrintClass();
		
		int m = GoodeeUtil.inputNum();
		
		pc.userPrint("메세지");
		pc.userPrint(1);
		pc.userPrint(1.0);
		
		
		
		

	}

}

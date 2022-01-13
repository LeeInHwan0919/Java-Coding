package com.goo.dee;

public class ProcessMain {
	public static void main(String[] args) throws Exception{
		ProcessTest pt = new ProcessTest();
		try {
			int n = ScannerInputValue.inputInteger();
			pt.Choice(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("애플리케이션 완료");
	}
}

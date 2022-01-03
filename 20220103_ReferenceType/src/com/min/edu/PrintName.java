package com.min.edu;

public class PrintName {

	public static void main(String[] args) {
		 Info info = new Info();
		 info.name = "토마토";
		 info.age = 54;
		 info.address = "울산 광역시";
		 info.infoPrint();
		 
		 ChangeInfo.InfoInput(info);
		 info.infoPrint();
		 
		 int v = 100;//값복사
		 System.out.println(v);
		 ChangePrimtive.changeVail(v);
		 System.out.println(v);
		 

	}

}

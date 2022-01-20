package com.min.edu;

public class Prototype_Main {

	public static void main(String[] args) {
		
		// 1) 입력하기가 힘들다
		StudentVo stu01 = new StudentVo("왕눈이", "남성", 12);
		StudentVo stu02 = new StudentVo("왕눈이", "남성", 12);
		
		// 2) pass by Reference가 발생되면 원하지 않는 객체의 변경
		StudentVo stu03 = new StudentVo("아로미", "여성", 12);
		System.out.println("원본: " + stu03);
		
		StudentVo stuTmp = stu03;  // pbr
		stuTmp.setAge(15);
		System.out.println("원본: " + stu03);
		System.out.println("복사: " + stuTmp);
		
		//-----------------------------------------------------------//
		
		StudentVo stu04 = new StudentVo("투투", "남성", 40);
		StudentVo stuClone = (StudentVo)stu04.createClone();
		System.out.println("stu04 : " + stu04);
		System.out.println("stuClone : " + stuClone);
		
		
		System.out.println("stu04 : " + stu04.hashCode());
		System.out.println("stuClone : " + stuClone.hashCode());
		
		

	}

}

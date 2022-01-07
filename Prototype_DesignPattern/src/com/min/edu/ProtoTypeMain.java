package com.min.edu;

public class ProtoTypeMain {

	public static void main(String[] args) {
		Something box1 = new Something("산군", "무두리");
		Something box2 = box1; // 참조타입 복사 주소복사

		System.out.println(box1.equals(box2));

		Something box3 = (Something) box1.createClone();
		System.out.println(box1.equals(box3));
		System.out.println(box1);
		System.out.println(box2);
	}
}
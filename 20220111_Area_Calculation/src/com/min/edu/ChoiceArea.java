package com.min.edu;

import java.util.Scanner;

public final class ChoiceArea {// final 로 클래스를 지정하면 재정의를 못시키게 할수가 있다~~
	public static AreaImpl choiceShpae() {
		AreaImpl obj = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("선택해주세요 1.삼각형, 2.원형, 3.사각형");
		switch (scan.nextInt()) {
		case 1:
			obj = new Triangle();
				break;
		case 2:
			obj = new Circle();
				break;
		case 3:
			obj = new Square();
				break;
		}
		return obj;
	}
}

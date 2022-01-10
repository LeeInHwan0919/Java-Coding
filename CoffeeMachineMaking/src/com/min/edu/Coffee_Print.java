package com.min.edu;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Coffee_Print {
	public void CoffeePrint() {
		int money = 0;
		int menu = 0;
		int nam = 0;
		int plus = 0;
		;

		int ame = 1000;
		int cafe = 2000;
		int milk = 1500;

		System.out.println("안녕하세요. 커피자판기 입니다.");
		System.out.println("-------------------------------------------");
		System.out.println("돈을 넣어주세요");
		Scanner moneysc = new Scanner(System.in);
		money = moneysc.nextInt();

		// 금액 표기
		DecimalFormat formatter = new DecimalFormat("###,###");

		System.out.println(formatter.format(money) + "원 넣으셨습니다. \n 잔돈 : " + formatter.format(money) + "원");

		while (plus == 0) {
			System.out.println("커피를 선택해 주세요.\n1.아메리카노 1000원 \n2.카페라떼 2000원 \n3.밀크커피 1500원 \n4.거스름돈 반환 \n5.준비중...");
			Scanner coffeeselect = new Scanner(System.in);
			menu = coffeeselect.nextInt();
			if (menu == 1) {
				nam = money - ame;
				if (nam < 0) {
					System.out.println("요금이 부족합니다. 거스름돈 " + formatter.format(money) + "원이 반환되었습니다. 감사합니다.");

				} else {
					System.out.println("아메리카노가 나왔습니다. 거스름돈은" + formatter.format(nam) + "입니다. 감사합니다");
				}
				break;

			} else if (menu == 2) {
				nam = money - cafe;
				if (nam < 0) {
					System.out.println("요금이 부족합니다. 거스름돈 " + formatter.format(money) + "원이 반환되었습니다. 감사합니다.");

				} else {
					System.out.println("카페라떼가 나왔습니다. 거스름돈은" + formatter.format(nam) + "입니다. 감사합니다");
				}
				break;

			} else if (menu == 3) {
				nam = money - milk;
				if (nam < 0) {
					System.out.println("요금이 부족합니다. 거스름돈 " + formatter.format(money) + "원이 반환되었습니다. 감사합니다.");

				} else {
					System.out.println("밀크커피가 나왔습니다. 거스름돈은" + formatter.format(nam) + "입니다. 감사합니다");
				}
				break;

			} else if (menu == 4) {
				System.out.println(money + "원이 반환되었습니다. 감사합니다.");

			} else {
				System.out.println("준비중 입니다. 다시 입력해주세요.");
			}
			break;

		} // while

	}// method
}// class

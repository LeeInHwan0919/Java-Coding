package com.min.edu;

import java.util.Scanner;

public class StarMain {

	public static void main(String[] args) {
		System.out.println("원하는 숫자를 입력해 주세요 ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		RealStar r = new RealStar();
		r.leftdown(n);
//		r.leftup(5);
//
//		r.rightdown(5);
//		r.rightup(5);

	}

}

package com.min.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMethod {

	public int calculation() throws Exception {
		int n = 0;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("정수를 입력해 주세요");
//			int num = scan.nextInt();
			n = scan.nextInt() / scan.nextInt();
		} catch (InputMismatchException | ArithmeticException e) {
			throw new IllegalArgumentException();
//			e.printStackTrace();
//			System.out.println(e.toString());
		}
//		}catch (Exception e) {
//			System.out.println("두번째 : " + e.toString());
//		}
//		}finally {
//			System.out.println("무조건 작동");
//		}
		System.out.println("작동이 되어야함");
		return n;
	}

}

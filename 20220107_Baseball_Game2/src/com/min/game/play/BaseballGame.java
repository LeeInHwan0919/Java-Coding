package com.min.game.play;

import java.util.Scanner;

import com.min.game.comm.BaseballConst;
import com.min.game.user.Hitter;
import com.min.game.user.Picher;

public class BaseballGame {

	private int len; // 전체적으로 세팅된 Array의 길이
	private Picher pBox; // Pitcher 클래스를 통해 단 한번 입력된 객체
	private Hitter hBox; // Hitter 클래스를 통해 계속해서 입력 받을 객체
	private Umpire ump; // 멤버필드의 pBox와 hBox를 판단하는 객체

	public BaseballGame() {
		this(3);
	}

	public void newGame() {
		Scanner sc = new Scanner(System.in);
		String answer = "Y";

		do {
			play(); // 게임을 진행

			System.out.println("게임을 다시 진행하시겟습니까? Y or N");
			answer = sc.nextLine();
			if (answer.toUpperCase().trim().compareTo("N") == 0) {
				System.out.println("종료 하겠습니다.");
			}
		} while (answer.toUpperCase().trim().equals("Y"));
	}

	public BaseballGame(int n) {
		this.len = n;
		pBox = new Picher(n);
		hBox = new Hitter(n);
		ump = new Umpire();

	}

	private void play() {
		int num = 0; // 게임횟수
		int strike = 0; // 스트라이크횟수
		int ball = 0; // 볼 횟수

		// 자동생성 번호
		pBox.make();
		pBox.print();

		// 비교판단 객체에 넣어 줌
		ump.setpBox(pBox.getBox());

		// 게임을 시작해줌
		while (num != BaseballConst.ITERATOR) { // 첫번째 종료조건 : 게임의 횟수가 10까지 만
			num++;
			hBox.make(); // 사용자 입력해줄 수 있도록 함.
			System.out.println("현재 남은 게임 횟수 : " + (BaseballConst.ITERATOR - num));

			// 비교판단에 객체를 넣어 줌
			ump.sethBox(hBox.getBox());

			strike = ump.getStrike();
			ball = ump.getBall();

			System.out.printf("당신의 결과는? Strike : %d / Ball : %d \n", strike, ball);

			// 두번 째 종료 조건
			// 게임이 진행 되는 중간에 모든 배열의 숫자값을 맞췄을 경우 종료
			if (strike == BaseballConst.STRIKE) {
				break;
			} // if
		} // while

		if (strike == BaseballConst.STRIKE) {
			System.out.println("당신은 승리하셨습니다.");
		} else {// 10번 을 넘겼을 경우
			System.out.println("당신은 패배하셨습니다.");
			System.out.printf("Picher의 숫자는? %s \n", pBox.toString());
		}

	}// play

}// class

package com.min.game.play;

import java.util.Scanner;

import com.min.game.comm.BaseballConst;
import com.min.game.user.Hitter;
import com.min.game.user.IGamer;
import com.min.game.user.Picher;

/**
 * 게임의 로직의 진행 및 게임 전체적인 진행을 할 수 있는 클래스
 * 
 * @author LeeInHwan
 *@since 2022.01.14
 */
public class BaseballGame {

<<<<<<< HEAD
	public BaseballGame() {
		
	}
	
	private int len;
	private Picher pBox;
	private Hitter hBox;
	private Umpire ump;
=======
	private int len; // 전체적으로 세팅된 Array의 길이
	private Picher pBox; // Pitcher 클래스를 통해 단 한번 입력된 객체
	private Hitter hBox; // Hitter 클래스를 통해 계속해서 입력 받을 객체
	private Umpire ump; // 멤버필드의 pBox와 hBox를 판단하는 객체

	private static BaseballGame instance;

	public static BaseballGame getInstance(int n) {
		if (instance == null) {
			instance = new BaseballGame(n);
		}
		return instance;
	}

//	private BaseballGame() {
//		this(3);
//	}
>>>>>>> bf2d9e4bf42ae28eedb8c4938a45b7c2076a0c3a

	public void newGame() {
		Scanner sc = new Scanner(System.in);
		String answer = "Y";

		do {
			play();

			System.out.println("게임을 다시 진행하시겟습니까? Y or N");
			answer = sc.nextLine();
			if (answer.toUpperCase().trim().compareTo("N") == 0) {
				System.out.println("종료 하겠습니다.");
			}
		} while (answer.toUpperCase().trim().equals("Y"));
	}

	public BaseballGame(int n) {
		this.len = n;
		pBox = new Picher(n); // -1-1-1
		hBox = new Hitter(n);
		ump = new Umpire();

	}

	private void play() {
		int num = 0;
		int strike = 0;
		int ball = 0;

		pBox.make();
		pBox.print();

		ump.setpBox(pBox.getBox());

		/**
		 * 게임을 시작해줌
		 * 
		 * @author LeeInHwan
		 */
		while (num != BaseballConst.ITERATOR) {
			num++;
<<<<<<< HEAD
			hBox.make();
			System.out.println("현재 남은 게임 횟수 : " + (BaseballConst.ITERATOR - num));

			/**
			 * 비교판단에 객체를 넣어줌
			 * 
			 * @author LeeInHwan
			 */
			ump.sethBox(hBox.getBox());
=======
			hBox.make(); // 사용자 입력해줄 수 있도록 함.
			System.out.println("현재 남은 게임 횟수 : " + (IGamer.ITERATOR - num));

			// 비교판단에 객체를 넣어 줌
			ump.sethBox(hBox.getBox());// BaseballGame에서 선언 pbox, hbox 연결을 ump에있는 pbox, hbox에
>>>>>>> bf2d9e4bf42ae28eedb8c4938a45b7c2076a0c3a

			strike = ump.getStrike();
			ball = ump.getBall();

<<<<<<< HEAD
			System.out.printf("당신의 결과는? Strike : %d / Ball : %d \n", strike, ball);

			/**
			 * 두번 째 종료 조건 게임이 진행 되는 중간에 모든 배열의 숫자값을 맞췄을 경우 종료
			 */
			if (strike == BaseballConst.STRIKE) {
=======
			System.out.printf("당신의 결과는? Strike : %d /Ball : %d \n", strike, ball);
 
			// 두번 째 종료 조건
			// 게임이 진행 되는 중간에 모든 배열의 숫자값을 맞췄을 경우 종료
			if (strike == IGamer.STRIKE) {
>>>>>>> bf2d9e4bf42ae28eedb8c4938a45b7c2076a0c3a
				break;
			}
		}

		if (strike == BaseballConst.STRIKE) {
			System.out.println("당신은 승리하셨습니다.");
		} else {
			System.out.println("당신은 패배하셨습니다.");
			System.out.printf("Picher의 숫자는? %s \n", pBox.toString());
		}
	}
}

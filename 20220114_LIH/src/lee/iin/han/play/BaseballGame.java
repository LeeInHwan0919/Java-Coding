package lee.iin.han.play;

import java.util.Scanner;

import lee.iin.han.comm.BaseballConst;
import lee.iin.han.user.Hitter;
import lee.iin.han.user.IGamer;
import lee.iin.han.user.Picher;

/**
 * 게임의 로직의 진행 및 게임 전체적인 진행을 할 수 있는 클래스
 * @author LeeInHwan
 *@since 2022.01.14
 */
public class BaseballGame {

	private int len;
	private Picher pBox;
	private Hitter hBox;
	private Umpire ump;

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
		pBox = new Picher(n);
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
			hBox.make();
			System.out.println("현재 남은 게임 횟수 : " + (BaseballConst.ITERATOR - num));

			/**
			 * 비교판단에 객체를 넣어줌
			 * 
			 * @author LeeInHwan
			 */
			ump.sethBox(hBox.getBox());

			strike = ump.getStrike();
			ball = ump.getBall();

			System.out.printf("당신의 결과는? Strike : %d / Ball : %d \n", strike, ball);

			/**
			 * 두번 째 종료 조건 게임이 진행 되는 중간에 모든 배열의 숫자값을 맞췄을 경우 종료
			 */
			if (strike == BaseballConst.STRIKE) {
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

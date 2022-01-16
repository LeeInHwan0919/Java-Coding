package lee.iin.han;

import lee.iin.han.play.BaseballGame;

/**
 * 게임을 실행 시키는 메인 메소드
 * @author LeeInHwan
 *@since 2022.01.14
 */
public class BaseballMain {
	public static void main(String[] args) {

		// 최종 실행
		BaseballGame game = new BaseballGame(3);
		game.newGame();
	}
}

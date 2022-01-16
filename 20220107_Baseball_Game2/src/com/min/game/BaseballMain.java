package com.min.game;

import com.min.game.play.BaseballGame;

public class BaseballMain {
	public static void main(String[] args) {
<<<<<<< HEAD

		// 최종 실행
		BaseballGame game = new BaseballGame(3);
		game.newGame();
=======
		
		// 베이스볼 클래스에있는 getInstance메소드에 3을 넣어준다.
		BaseballGame game = BaseballGame.getInstance(3); 
		game.newGame(); //Baseball  클래스에 newGame()이라는 메소드를
>>>>>>> bf2d9e4bf42ae28eedb8c4938a45b7c2076a0c3a
	}
}

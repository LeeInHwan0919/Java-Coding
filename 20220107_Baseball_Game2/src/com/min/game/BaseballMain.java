package com.min.game;

import com.min.game.play.BaseballGame;

public class BaseballMain {
	public static void main(String[] args) {

		// 최종 실행
		BaseballGame game = new BaseballGame(3);
		game.newGame();
	}
}

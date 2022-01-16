package com.min.game;

import com.min.game.play.BaseballGame;

public class BaseballMain {
	public static void main(String[] args) {

		// 베이스볼 클래스에있는 getInstance메소드에 3을 넣어준다.
		BaseballGame game = BaseballGame.getInstance(3); 
		game.newGame(); //Baseball  클래스에 newGame()이라는 메소드를

	}
}

package com.min.game;

import java.util.Arrays;

import com.min.game.play.BaseballGame;
import com.min.game.play.Umpire;
import com.min.game.user.Hitter;
import com.min.game.user.Picher;

public class BaseballMain {
	public static void main(String[] args) {


		// 최종 실행
		BaseballGame game = new BaseballGame();
		game.newGame();
	}
}

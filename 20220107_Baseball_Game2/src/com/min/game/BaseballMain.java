package com.min.game;

import java.util.Arrays;

import com.min.game.play.BaseballGame;
import com.min.game.play.Umpire;
import com.min.game.user.Hitter;
import com.min.game.user.Picher;

public class BaseballMain {
	public static void main(String[] args) {
		
		// 베이스볼 클래스에있는 getInstance메소드에 3을 넣어준다.
		BaseballGame game = BaseballGame.getInstance(3); 
		game.newGame(); //Baseball  클래스에 newGame()이라는 메소드를
	}
}

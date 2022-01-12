package com.min.game;

import java.util.Arrays;

import com.min.game.play.BaseballGame;
import com.min.game.play.Umpire;
import com.min.game.user.Hitter;
import com.min.game.user.Picher;

public class BaseballMain {
	public static void main(String[] args) {
//		Picher p = new Picher();
//		System.out.println(Arrays.toString(p.getBox()));
//		System.out.println(p.makeNum());
//		System.out.println(p.isDuplicate(0));
//		p.make();
//		System.out.println(Arrays.toString(p.getBox()));
//		System.out.println(p.toString());
//		p.print();

//		Hitter h = new Hitter();
//		int[] tmp = h.getBox();
//		System.out.println(Arrays.toString(tmp));
//
//		h.setBox(new int[] {1,2,3});
//		int[] tmp1 = h.getBox();
//		System.out.println(Arrays.toString(tmp1));
//		
//		System.out.println(h.isSame());
//		int[] t = h.makeNum();
//		System.out.println(Arrays.toString(t));
//		h.make();
//		System.out.println(h.getBox());
//		System.out.println(h);
//		h.print();

//		int[] p = { 1, 2, 3 };
//		int[] h = { 3, 2, 1 };

//		Umpire u = new Umpire(p, h);

//		System.out.println("스트라이크 개수는 : " + u.getStrike());
//		System.out.println("볼의 개수는 : " + u.getBall());

		// 최종 실행
		BaseballGame game = BaseballGame.getInstance(3);
		game.newGame();
	}
}

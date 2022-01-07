package com.min.game;

import java.util.Arrays;

import com.min.game.user.Picher;

public class BaseballGame {
	public static void main(String[] args) {
		Picher p = new Picher();
//		System.out.println(Arrays.toString(p.getBox()));
//		System.out.println(p.makeNum());
//		System.out.println(p.isDuplicate(0));
		p.make();
		System.out.println(Arrays.toString(p.getBox()));
		System.out.println(p.toString());
	}
}

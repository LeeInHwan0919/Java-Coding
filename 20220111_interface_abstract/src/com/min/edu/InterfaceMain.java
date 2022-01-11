package com.min.edu;

public class InterfaceMain {

	public static void main(String[] args) {
		
		
		System.out.println(IGame.age);
		System.out.println(IGame.name);
		System.out.println(IGame.val);
		System.out.println(IGame_Bin.val);
		System.out.println(IGame.sum(10));
		
		
		GameImpl g = new GameImpl();
		IGame ig = g;
		IGame_Bin = g;
		IGame_Conf cg = g;
		
		ig.makeA();
		ig.makeB();
		ig.printConf();
		//		System.out.println(IGame.age);
//		System.out.println(IGame.name);
//		System.out.println(IGame.val);
//		System.out.println(IGame_Bin.val);
		
	

}

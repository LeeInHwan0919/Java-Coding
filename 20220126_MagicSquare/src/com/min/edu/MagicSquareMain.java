package com.min.edu;

public class MagicSquareMain {

	public static void main(String[] args) {
//		OddMagicSquare odd = new OddMagicSquare(5);
//		int[][] magic = odd.getMagic();
		
		EvenMagicSquare even = new EvenMagicSquare(8);
		int[][] magic = even.getMagic();
		
		even.makeMagic();
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				System.out.print(magic[i][j]+"\t");				
			}
			System.out.println();
		}
	}

}

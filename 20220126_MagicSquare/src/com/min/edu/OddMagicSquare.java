package com.min.edu;

public class OddMagicSquare {

	private int[][] magic;

	public OddMagicSquare() {
		this(3);
	}

	public OddMagicSquare(int n) {
		magic = new int[n][n];

	}

	public void makeMagic() {
		int n = magic.length; // 가로길이, 세로길이 magic[0].length;

		// 첫번째 줄에 가운데에 1을 넣고 시작한다.
		int x = 0;
		int y = n / 2;
		magic[x][y] = 1;

		for (int i = 2; i <= n * n; i++) { // 값으로 사용되는 for문
			int tmpX = x;
			int tmpY = y;

			if (x - 1 < 0) {
				x = n - 1;
			} else {
				x--;
			}
			if (y - 1 < 0) {
				y = n - 1;
			} else {
				y--;
			}
			if (magic[x][y] != 0) {
				x = tmpX + 1;
				y = tmpY;
			}
			magic[x][y] = i;
		}
	}

	public int[][] getMagic() {
		return magic;
	}

}

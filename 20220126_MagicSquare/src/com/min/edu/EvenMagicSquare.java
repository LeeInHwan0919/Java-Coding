package com.min.edu;

public class EvenMagicSquare {

	private int[][] magic;

	public EvenMagicSquare() {
		this(4);
	}

	public EvenMagicSquare(int n) {
		magic = new int[n][n];
	}

	public int[][] getMagic() {
		return magic;
	}

	public void makeMagic() {
		makeA();
		makeB();
	}

	private void makeB() {
		int n = magic.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= 0 && i < (n / 4) || i >= n / 4 * 3 && i < n) {
					if (i >= n / 4 && j < n / 4 * 3) {
						magic[i][j] = n*n - (i*n+j);
					}else if(j >= 0 && j < (n / 4) || j >= n / 4 * 3 && j < n) {
						magic[i][j] = n*n - (i*n+j);
					}
				}
			}
		}
	}

	// 전체 2차원 Array에 n*n의 값을 순서대로 입력
	// 1차원의 값을 2차원으로 변경 + for문의 i값을 값으로 입력
	private void makeA() {
		int n = magic.length;
		for (int i = 0; i < n * n; i++) {
			magic[i / n][i % n] = i + 1;
		}
	}
}

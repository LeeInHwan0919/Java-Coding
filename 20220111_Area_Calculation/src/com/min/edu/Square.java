package com.min.edu;

public class Square extends AreaImpl {
	@Override
	public void cal(int x, int y) {
		super.x = x;
		super.y = y;
		result = x * y;

	}
}

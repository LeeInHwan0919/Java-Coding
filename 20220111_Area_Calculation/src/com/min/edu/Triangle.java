package com.min.edu;

public class Triangle extends AreaImpl{

	@Override
	public void cal(int x, int y) {
		super.x = x;
		super.y = y;
		super.result = x * y * 0.5;
	}

}

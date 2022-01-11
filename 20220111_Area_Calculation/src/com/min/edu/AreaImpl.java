package com.min.edu;

/**
 * 면적 계산에 필요한 공통 멤버를 선언한다<br>
 * 값 x, y <br>
 * 
 * @author GDJ44
 *
 */
public abstract class AreaImpl implements IArea {// 추상메소드를 포함하는 추상 클래스

	protected int x;
	protected int y;

	protected double result;

	@Override
	public abstract void cal(int x, int y);

	@Override
	public void print() {
		System.out.printf("%d와 %d의 면적결과는 %f\n", x, y, result);

	}

}

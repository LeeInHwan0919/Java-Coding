package com.min.edu;

public interface IArea {

	/**
	 * 원주율 3.14
	 */
	public double PI = 3.14;
	
	/**
	 * 각 다른 면적을 계산하는 클래스에서 구현
	 */
	public void cal(int x, int y);
	
	/**
	 * 상위 부모에서 공통 메소드로 구현
	 */
	public void print();
	
}

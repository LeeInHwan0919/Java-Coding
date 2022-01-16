package lee.iin.han.user;

import java.util.Arrays;

/**
 * 인터페이스, 추상화 메소드를 포함한 추상화 클래스
 * box값을 초기화 시킨다.
 * @author LeeInHwan
 *@since 2022.01.14
 */
public abstract class GamerImpl implements IGamer {

	protected int[] box;

	public GamerImpl(int n) {
		box = new int[n];
		Arrays.fill(box, -1);
	}

	@Override
	public void print() {
		System.out.printf("[");
		for (int i = 0; i < box.length - 1; i++) {
			System.out.printf("%s,", box[i]);
		}
		System.out.printf("%s]", box[box.length - 1]);
	}

	@Override
	public String toString() {
		String s = "[";
		int n = box.length;
		for (int i = 0; i < n - 1; i++) {
			s += String.format("%s,", box[i]);
		}
		s += String.format("%s]", box[n - 1]);
		return s;
	}

	@Override
	public abstract void make();

	public int[] getBox() {
		return box;
	}

}

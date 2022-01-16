package lee.iin.han.user;

/**
 * <b>숫자를 자동으로 생성해 주는 클래스</b>
 * @author LeeInHwan
 *@since 2022.01.14
 */
public class Picher extends GamerImpl {

	public Picher(int b) {
		super(b);
	}

	private int makeNum() {
		int num = 0;
		num = (int) (Math.random() * 9) + 1;
		return num;
	}

	/**
	 * 멤버필드의 중복 값을 확인함
	 * 
	 * @param tmp 랜덤숫자
	 * @return true 중복 /false 사용
	 */
	private boolean isDuplicate(int tmp) {
		boolean isc = false;
		for (int i = 0; i < box.length; i++) {
			if (box[i] == tmp) {
				isc = true;
			}
			break;
		}
		return isc;
	}

	@Override
	public void make() {
		int idx = 0;
		int n = box.length;
		while (idx != n) { 
			int num = makeNum();
			if (!isDuplicate(num)) { //
				this.box[idx++] = num;
			} 
		}
	}
}

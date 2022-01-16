package lee.iin.han.user;

import java.util.regex.Pattern;

import lee.iin.han.*;

/**
 * 사용자가 입력 Stream을 통해서 키보드로 입력받는 클래스
 * @author LeeInHwan
 * @since 2022.01.14
 */
public class Hitter extends GamerImpl {

	public Hitter(int n) {
		super(n);
	}

	private int[] makeNum() {
		int[] tmp = new int[box.length];
		System.out.println("정수 3개를 붙여서 입력해 주세요");
		String str = lih_Util.inputString();
		System.out.println("입력하신 숫자는! " + str);
		String pattern = "^[1-9]*$";
		boolean regex = Pattern.matches(pattern, str);

		/**
		 * 비교판단 및 유효성을 검사해서 다시 입력을 받을 건지, 정확한 값 입력값이 없거나 길이가 체워야할 배열과 같지 않거나 숫자로만 구성이
		 * 되어있지 않다면 다시 입력 받아야 한다.
		 */
		while (str.trim().equals("") || str.trim().length() != box.length || !Pattern.matches(pattern, str)) {
			System.out.println("다시 입력해 주세요");
			str = lih_Util.inputString();
		}

		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = Character.getNumericValue(str.charAt(i));
		}

		return tmp;
	}

	/**
	 * 같은 값을 가지고 있는 배열의 값이 있다면 true
	 * @return true중복 / false 사용
	 */
	private boolean isSame() {
		boolean isc = false;
		int n = box.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && box[i] == box[j]) {
					isc = true;
				}
			}
		}
		return isc;
	}

	public void make() {
		int n = box.length;
		System.arraycopy(makeNum(), 0, box, 0, n);
		while (true) {
			if (isSame()) {
				System.out.println("중복이 되었습니다. 중복 없이 입력해 주세요");
				System.arraycopy(makeNum(), 0, box, 0, n);
			} else {
				break;
			}
		}

	}

}

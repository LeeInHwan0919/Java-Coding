package lee.iin.han.play;

/**
 *	두개의 box(pitcher, Hitter)를 받아서 get 메소드를 통해서 결과를 반환함
 * 	strike	:	같은	index 같은 값
 * ball	:	다른 index 같은 값
 * @author LeeInHwan
 *@since 2022.01.14
 */
public class Umpire {

	private int[] pBox;
	private int[] hBox;


	public void setpBox(int[] pBox) {
		this.pBox = pBox;
	}

	public void sethBox(int[] hBox) {
		this.hBox = hBox;
	}

	public int getStrike() {
		int cnt = 0;
		for (int i = 0; i < pBox.length; i++) {
			if (pBox[i] == hBox[i]) {
				cnt++;
			}
		}
		return cnt;
	}

	public int getBall() {
		int cnt = 0;
		for (int i = 0; i < pBox.length; i++) {
			for (int j = 0; j < hBox.length; j++) {
				if (i != j && pBox[i] == hBox[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}

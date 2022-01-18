package com.lotto.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 번호를 한줄 만들어내는 클래스
 * 
 * @author ldkko
 *
 */
public class LottoMake {
	
	private List<LottoNum> lottoRow;

	public List<LottoNum> getLottoRow() {
		return lottoRow;
	}

	public LottoMake() {
		lottoRow = new ArrayList<LottoNum>();
		make();
	}

	private void make() {
		int cnt = 0; // 종료조건
		while (true) {
			LottoNum num = new LottoNum();
			if (!lottoRow.contains(num)) {
				lottoRow.add(num);
				cnt++;
			}
			
			if (cnt == 6) {
				break;
			}
			
		}
		
	}
	
}

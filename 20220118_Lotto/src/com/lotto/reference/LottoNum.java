package com.lotto.reference;
/**
 * 로또 번호를 한개 만들어내는 클래스
 * @author ldkko
 *
 */
public class LottoNum {
	private String one;
	
	public LottoNum() {
		String tmp =String.valueOf((int)(Math.random()*45)+1);
		one = tmp.length() == 2?tmp:"0"+tmp;
	}
	
	

	@Override
	public int hashCode() {

		return one.hashCode()+137;
	}



	@Override
	public boolean equals(Object obj) {
		boolean isc = false;
		LottoNum other = (LottoNum)obj;
		if(one.equals(other.getOne())) {
			isc =true;
		}
		return isc;
	}



	public String getOne() {
		return one;
	}

	@Override
	public String toString() {
		return "["+ one + "]";
	}
	
	
}

package com.min.edu;

public class StringMethod {
	
	
		
	public void concat() {
		//Concatnation 연쇄적인 순서가 연산자 + 문자열과 타입이 연산된다면.. 문자열로 변화된다.
		String str1 = "hap";
		String str2 = "py";
		String strTotal = str1 + str2 ;	// concat => new String() => 하드웨어 부하가 심하다.
		String strTotal2 = str1.concat(str2).concat("val");
		System.out.println(strTotal);
		System.out.println(strTotal2);
		
		//StringBuffer
		String strTotal3 = "hap" + "py";
		
		StringBuffer sb = new StringBuffer();
		sb.append("맞아요").append("날씨가 추워요").append(true);
//		System.out.println(sb.toString());
		String t = sb.toString();
		
		StringBuffer  sbu = new StringBuffer();
		sbu.append("사용");
		String tu = sbu.toString();
		System.out.println(tu);
		
		str1.length();
		System.out.println(str1.length());
		
	}
}

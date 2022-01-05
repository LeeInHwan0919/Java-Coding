package com.min.edu;

public class YacsuMain {

	public static void main(String[] args) {
		
//		YacSu yy = new YacSu();
//		boolean isc = yy.isCheck(6, 3);
//		System.out.println(isc);
//		
//		yy.yacsu_print(10);
//		System.out.println();

		// Perfect pp = new Perfect();
		// pp.perfectNum(500);
		Friendly f = new Friendly();
		long start = System.currentTimeMillis();
		f.friendlyNum(5000);
		long finish = System.currentTimeMillis();
		System.out.println("총 소요시간은 : " + (finish - start));
	}

}

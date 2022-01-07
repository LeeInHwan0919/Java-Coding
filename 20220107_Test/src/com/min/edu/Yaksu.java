package com.min.edu;

public class Yaksu {
//진약수 확인하기
	public boolean ischeck(int Num, int chkNum) {
		boolean isc = false;
		if(Num%chkNum ==0) {
			isc = true;
		}
		return isc;
	}

	// 진약수의 합과 개수 구하기
	public void Yacsu_print(int Num) {
		int sum = 0; int cnt = 0;
		for(int i=1; i<Num; i++) {
			if(ischeck(Num, i)) {
				sum += i;
				cnt ++;
			}
		}
		System.out.printf("진약수의 합은 %d이고, 개수는 %d이다.", sum, cnt);
	}
}

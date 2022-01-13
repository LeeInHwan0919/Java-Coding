package com.min.edu;

import com.goo.dee.ScannerInputValue;

public class AntQuizMain {

	public static void main(String[] args) {
		AntQuiz play = new AntQuiz();
		int stage = ScannerInputValue.inputInteger();
//		String result = play.antProcess(String.valueOf(val));
//		System.out.println(result);
		
		play.antQuizIterator(stage);
	}
}

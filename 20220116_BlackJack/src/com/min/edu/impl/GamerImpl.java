package com.min.edu.impl;

import java.util.Arrays;

public abstract class GamerImpl implements IBlackJack {

	protected int[] numCard;
	protected int[] patternCard;
	
	
	public GamerImpl(int n) {
		numCard = new int[n];
		patternCard = new int[n];
		Arrays.fill(numCard, 0);
		Arrays.fill(patternCard, 0);
	}
	
	@Override
	public abstract void make();
	
	
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		String s = "[";
		int n = numCard.length;
		int n2 = patternCard.length;
		for (int i = 0; i < n-1 ; i++) {
			s += String.format("%s", numCard[i]);			
		}
		for (int i = 0; i < patternCard.length; i++) {
			s += String.format("%s", patternCard[i]);	
		}
		
		
		return super.toString();
	}
	
}

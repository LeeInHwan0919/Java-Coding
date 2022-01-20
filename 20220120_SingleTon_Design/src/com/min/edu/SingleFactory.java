package com.min.edu;

public final class SingleFactory {
	
	private static SingleFactory single;
	
	private SingleFactory() {
		
	}
	
	public static SingleFactory getInstance() {
		if(single == null) {
			single = new SingleFactory();
		}
		return single;
	}
	
}

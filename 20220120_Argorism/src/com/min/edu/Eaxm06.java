package com.min.edu;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Eaxm06 {
	
	public void queue() {
		Queue<String> like = new LinkedList<String>();
		
		String str1 = "ÀÚ¹Ù";
		String str2 = "µðºñ";
		String str3 = "¾¾¼¥";
		String str4 = "¹ä¼¥";
		
		//°ªÀ» ÀÔ·Â offer add
		
		like.offer(str1);
		like.offer(str2);
		like.offer(str3);
		like.offer(str4);
		
//		like.remove(str1);
		
//		System.out.println(like.peek()+" : peek");
//		while(like.peek() != null) {
//			System.out.println(like.element());
//		}
		
		System.out.println(like.peek()+" : peek");
		while(like.peek() != null) {
			System.out.println(like.poll() + "//");
		}
	}
	
	public void linked() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(3);
		list.addFirst(1);
		list.addLast(10);
		list.add(1,5);
		System.out.println(list);
		
		
	}
}

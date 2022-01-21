package com.min.edu;

import java.util.Iterator;

public class Iterator_main {

	public static void main(String[] args) {
		UserList ul = new UserList();
		ul.add(new User("왕눈이"));
		ul.add(new User("아름이"));
		
		Iterator iter = ul.iterator();
		while(iter.hasNext()) {
			User user = (User) iter.next();
			System.out.println(user.getName());
		}

	}

}

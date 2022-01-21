package com.min.edu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserList implements Agreegate {
	
	private List<User> userList;
	public UserList() {
		userList = new ArrayList<User>();
		
	}
	
	//멤버필드의 List에 User를 담는 기능
	
	public void add (User user) {
		userList.add(user);
	}
	
	//입력되어 있는 멤버필드의 List를 index를 통해서 해당 값을 반환
	public User get(int index) {
		return userList.get(index);
	}
	//입력 되어 있는 멤버필드의 전체 크기
	public int size() {
		return userList.size();
	}
	

	@Override
	public Iterator iterator() {
		return new UserIterator(this);
	}

}

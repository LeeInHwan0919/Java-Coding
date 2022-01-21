package com.min.edu;

import java.util.Iterator;

public class UserIterator implements Iterator {

	private UserList UserList;
	private int index;//자료형 구조의 index

	public UserIterator(UserList userList) {
		this.UserList = userList;
		this.index = 0;
	}
	//객체 안의 객체가 있는지 확인
	@Override
	public boolean hasNext() {
		if(index<UserList.size()) {
			return true;
		}else {
			return false;	
		}
	}
	//hasNext()에 의해 안의 객체가 있다면 현재 선택된 객체를 출력
	@Override
	public Object next() {
		User user = UserList.get(index++);
		return user;
	}

	@Override
	public void remove() {

	}

}

package com.min.edu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map_Feature {

	// key와 value로 입력해야 한다
	// key는 중복이 안됨, value 중복이 가능
	// key가 중복이 되면 마지막에 입력된 값이 입력됨
	public void map_check() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("가", 10);
		map.put("나", 20);
		map.put("다", 30);
		map.put("다", 1000);

		System.out.println(map.get("다"));
	}

	public void map() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("가", 10);
		map.put("나", 20);
		map.put("다", 30);
		map.put("라", 40);
		map.put("마", 50);

		// key로만 값을 출력 할 수 있음
		System.out.println(map.get("가"));

		// 삭제는??
		String rm = "10";
//		Integer rm = 10;
		// 처음에 선언된 Generic의 타입으로만 삭제 대상이 된다.
		map.remove(rm);// key로 인식 한다. 리터럴의 값은 인식하지 않음

		map.remove("마", 50);

		System.out.println(map.containsKey("가"));
		System.out.println(map.containsValue(50));

		// 출력
		// 1) Map객체가 가지고 있는 key를 모두 Set으로 만듬
		// 2) set를 Iterator로 만듬
		// 3) 2)번의 출력에 map.get(key) 통해서 출력

		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
//			System.out.println(iter.next() + " : " +map.get(iter.next()));
			String tmp = iter.next();
			System.out.println(tmp + " : " + map.get(tmp));
		}
	}
}

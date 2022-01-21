package com.min.edu;
/**
 * Dependency를 이용해서 Iterator 클래스를 강제적으로 사용하기 위한 집합체를 만들어 준다<br>
 * Interface 로 선언하여 implements한 객체가 반드시 iterator()를 구현하도록 만든다 
 * @author HIK
 *
 */

import java.util.Iterator;

public interface Agreegate {
	public Iterator iterator();
}

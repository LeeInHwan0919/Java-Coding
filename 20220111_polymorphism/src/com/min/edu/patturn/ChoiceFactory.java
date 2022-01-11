package com.min.edu.patturn;

import com.min.edu.H2O;
import com.min.edu.sub.Ice;
import com.min.edu.sub.Steam;
import com.min.edu.sub.Water;

public class ChoiceFactory {

	private static ChoiceFactory choice; // == main에서 ChoiceFactory choice = new ChoiceFactory(); // static에 getInstance와 공유되면서 보안성올라간다
	
	private ChoiceFactory() {	
	}
	
	public static ChoiceFactory getInstance() {
		if(choice == null) {
			choice = new ChoiceFactory();
		}
		return choice;
	}
	
	/**
	 * 객체는 입력된 값에 의해서 자동으로 인스턴스되고 각 객체를 상위 부모의 클래스를 통해 반환 시킨다. 반환된 객체는VMI에 의해서 같은
	 * 메소드로 실행 시킴
	 */

	public H2O factory(int choice) {
		H2O h = null;
		switch (choice) {
		case 1: h = new Ice();				break;
		case 2: h = new Water();			break;
		case 3: h = new Steam();		break;
		}

		return h;
	}
}

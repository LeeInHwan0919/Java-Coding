package com.min.edu.main;

import java.util.Scanner;

import com.min.edu.H2O;
import com.min.edu.patturn.ChoiceFactory;
import com.min.edu.sub.Ice;
import com.min.edu.sub.Steam;
import com.min.edu.sub.Water;

public class H2OMain {

	public static void main(String[] args) {

		for (int i = 0; i < Integer.parseInt(args[2]); i++) {

			ChoiceFactory ch = ChoiceFactory.getInstance();
			System.out.println(ch);
			Scanner scan = new Scanner(System.in);
			int c = scan.nextInt();
			H2O obj = ch.factory(c);
			obj.print();
			obj.make();
		}

//		H2O h = new Ice();//타입에 따라서 보여지는 멤버가 다르다	//UpCasting
//		h.make();
//		h.print();
//		Water w = (Water)h;	//Down Casting	//응용>> Wrapper Class
//		System.out.println(w);

//		h.num은 안됨 
//		Ice ice = new Ice();
//		ice.num = 10;	//	부모
//		System.out.println(ice.num);
//		Steam steam = new Steam();
//		steam.num = 20;//	부모
//		System.out.println(steam.num);
//		Water water = new Water();
//		water.num = 30;//	부모
//		System.out.println(water.num);
	}

}

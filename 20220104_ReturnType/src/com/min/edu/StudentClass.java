package com.min.edu;

//기본타입은? immutable, pass by value
//참조타입은? mutable, pass by reference
public class StudentClass {

	//객체를 생성하면 주소로 값을 변경할 수 있더라
	//객체를 생성할 때 생성자를 통해서 단 1회 입력
	//외부에서 접근이 되지 않도록 입력 메소드 만들지 않고
	//멤버필드는 private
	
	public static void main(String[] args) {
		//어떠한 메소드를 실행하기 위해서 필요한 값 => Argument
		//Student를 생성하기 위해서 필요한 값 String, int, String
		Student st = new Student("고길동", 80, "서울시");
		String add = st.getAddress();
		int age = st.getAge();
		String name = st.getName();
		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(add);
//		
//		st.student_print();
		
		
		Student stu = new Student("이상해씨", 20, "태초마을");
		StudentPrint.studentView01(stu);
		String result = StudentPrint.studentView02(stu);
		System.out.println(result);
	}
	
}

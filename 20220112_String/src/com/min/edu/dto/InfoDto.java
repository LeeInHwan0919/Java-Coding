package com.min.edu.dto;

public class InfoDto {

	private String name;
	private int age;
	private String address;

	public InfoDto() {

	}

	public InfoDto(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "InfoDto [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	// 객체의 새로운 hashcode를 재생성한다면
	// 부모의 hashcode 메소드를 Override 하면 된다.
	// 멤버필드의 hashcode 값을 사용하고 + 소수
	@Override
	public int hashCode() {

		return name.hashCode() + age + address.hashCode() + 137;
	}

	@Override
	public boolean equals(Object obj) { // Object up casting이 되어 있는 객체
//		if (this == obj)	//	obj가 현재의 설계도로 작성된 객체인지를 확인
//			return true;
//		if (obj == null)	//	비교 대상이 되는 객체가 null 판단
//			return false;
//		if (getClass() != obj.getClass())	//	 이름이 같고 설계도가 같은 것을 구분
//			return false;
//		InfoDto other = (InfoDto) obj;	//	Object를 원래상태로 Casting
//		if (address == null) {	//	값을 확인
//			if (other.address != null)
//				return false;
//		} else if (!address.equals(other.address))	//	값을 확인
//			return false;
//		if (age != other.age)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
		boolean isc = false;
		InfoDto info = (InfoDto) obj;
		if (name.equals(info.name) && age == info.age && address.equals(info.address)) {
			isc = true;
		}
		return isc;
	}

}

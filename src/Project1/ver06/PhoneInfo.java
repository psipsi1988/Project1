package Project1.ver06;

import java.io.Serializable;



public class PhoneInfo implements Serializable{

	//멤버변수 
	String name; //멤버1 : 이름 
	String phoneNumber; //멤버2 : 전화번호 String 


	//생성자
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;

	}




	//정보 출력용 메소드
	public void dataAllShow() {
		System.out.println("--------------------");
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
	}
}



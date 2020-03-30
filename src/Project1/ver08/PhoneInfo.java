package Project1.ver08;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo comparecomparePhoneInfo = (PhoneInfo) obj;
		if (comparecomparePhoneInfo.name.equals(this.name)) {
			return true;
		}else {
			return false;
		}
	}
}



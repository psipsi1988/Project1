package Project1.ver02;

public class PhoneInfo {



	public PhoneInfo() {
	}




	//멤버변수 
	String name; //멤버1 : 이름 
	String phoneNumber; //멤버2 : 전화번호 String 
	String birthday; //멤버3 : 생년월일 

	//생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	//생년월일은 필수사항 아니므로 인자가 없는 경우 null로 초기화
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = null;
	}




	//정보 출력용 메소드
	public void showPhoneInfo(String name, String phoneNumber, String birthday) {
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);

		System.out.println("생년월일:"+birthday);

	}

}

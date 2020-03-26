package Project1;
import java.util.Scanner;

import Project1.ver02.PhoneInfo;


class addphoneNumber{
	public void addphoneNumber() {

		//사용자로부터 친구정보를 입력받기위한 준비
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, birthday;
		PhoneInfo p1 = new PhoneInfo();


		System.out.print("이름:");name = scan.nextLine();
		System.out.print("전화번호:");phoneNumber = scan.nextLine();
		System.out.print("생년월일:");birthday = scan.nextLine();


		System.out.println("입력된 정보 출력");

		p1.showPhoneInfo(name, phoneNumber, birthday);
		System.out.println("친구정보 입력이 완료되었습니다.");
	}////end of addphoneNumber 
}
public class PhoneBookVer02 {




	public void showdata() {
		
	}
	

	public static void menuShow() {

		System.out.println("선택하세요. ");
		System.out.println("1.폰번호입력");
		System.out.println("2.프로그램 종료");
		System.out.println("선택 : ");
	}

	public static void main(String[] args) {

		PhoneInfo p1 = new PhoneInfo();
		addphoneNumber add = new addphoneNumber();
		while(true) {
			//메뉴출력을 위한 메소드호출
			menuShow();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1: //정보 입력
				add.addphoneNumber();
				
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;//main함수의 종료는 프로그램 종료로 이어진다.
			}
		}









		//		PhoneInfo p1 = new PhoneInfo("토니스타크", "010-1111-1111", 
		//				"70-01-01");
		//		PhoneInfo p2 = new PhoneInfo("브루스배너", "010-2222-2222");
		//		
		//		p1.showPhoneInfo();
		//		p2.showPhoneInfo();//생년월일 입력되지 않음
		//
	}

}

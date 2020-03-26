package Project1;
import java.util.Scanner;

import Project1.ver04.PhoneBookManager;
import Project1.ver04.PhoneInfo;

public class PhoneBookVer04 {


	public void showdata() {
		
	}
	

	public static void printMenu() {

		System.out.println("선택하세요. ");
		System.out.println("1.데이터입력");
		System.out.println("2.데이터검색");
		System.out.println("3.데이터삭제");
		System.out.println("4.주소록출력");
		System.out.println("5.프로그램 종료");
		System.out.println("선택 : ");
	}

	

	public static void main(String[] args) {

		PhoneBookManager pbmanager= new PhoneBookManager(100);
		while(true) {
			//메뉴출력을 위한 메소드호출
			printMenu();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1:		 //데이터 입력
				pbmanager.dataInput01();
				break;
			case 2:		//친구정보검색
				pbmanager.dataSearch();
				break;	
			case 3:		//친구정보삭제
				pbmanager.dataDelete();
				break;	
			case 4:		//전체정보출력
				pbmanager.dataAllShow();
				break;
			case 5:
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

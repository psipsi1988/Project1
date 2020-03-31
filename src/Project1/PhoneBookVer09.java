package Project1;
import java.util.Scanner;

import Project1.ver09.PhoneBookManager;
import Project1.ver09.PhoneInfo;

public class PhoneBookVer09 {


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

		PhoneBookManager pbmanager= new PhoneBookManager();
		while(true) {
			//메뉴출력을 위한 메소드호출
			printMenu();

			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch(choice) {
			case 1: //정보 입력
				pbmanager.addphoneNumber();
				System.out.println("입력된 정보 출력");
				break;
			case 2:
				//친구정보검색
				pbmanager.dataSearch();
				break;	
			case 3:
				//친구정보삭제
				pbmanager.dataDelete();
				break;	
			case 4:
				//전체정보출력
				pbmanager.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;//main함수의 종료는 프로그램 종료로 이어진다.
			}
		}

	}

}

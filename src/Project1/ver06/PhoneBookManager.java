package Project1.ver06;
import java.util.InputMismatchException;
import java.util.Scanner;
public class PhoneBookManager {

	public PhoneBookManager(PhoneInfo[] myPhone, int numOfPhones) {
		super();
		this.myPhone = myPhone;
		this.numOfPhones = numOfPhones;
	}


	private PhoneInfo[] myPhone;
	private int numOfPhones;//친구정보를 추가할때마다 +1 증가
	//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
	public PhoneBookManager(int num) {
		myPhone = new PhoneInfo[num];
		numOfPhones = 0;
	}




	public void printMenu() {

		System.out.println("선택하세요. ");
		System.out.println("1.데이터입력");
		System.out.println("2.데이터검색");
		System.out.println("3.데이터삭제");
		System.out.println("4.주소록출력");
		System.out.println("5.프로그램 종료");
		System.out.println("선택 : ");

		while(true) {
			//메뉴출력을 위한 메소드호출			

			Scanner scan = new Scanner(System.in);
			try {
				int choice = scan.nextInt();

				if(choice<1 || choice>5) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}


				switch(choice) {
				case MenuItem.INPUT:		 //데이터 입력
					dataInput01();
					break;
				case MenuItem.SEARCH:		//친구정보검색
					dataSearch();
					break;	
				case MenuItem.DELETE:		//친구정보삭제
					dataDelete();
					break;	
				case MenuItem.SHOW:		//전체정보출력
					dataAllShow();
					break;
				case MenuItem.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;//main함수의 종료는 프로그램 종료로 이어진다.

				}

			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("숫자를 입력하세요. ");
			}
		}
	}


	public void printMenu1() {
		System.out.println("데이터 입력을 시작합니다. ");
		System.out.println("일반=1 / 동창=2 / 회사동료=3");
		System.out.println("선택 : ");

	}





	public void dataInput01() {
		System.out.println("데이터 입력을 시작합니다. ");
		System.out.println("일반=1 / 동창=2 / 회사동료=3");
		System.out.println("선택 : ");
		int grade;
		String name, phoneNumber, major, company;

		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.nextLine();

		try {
			if(choice<1 || choice>3) {
				MenuSelectException ex = new MenuSelectException();
				throw ex;
			}
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();

			switch (choice) {
			case SubMenuItem.NOMAL:

				PhoneInfo p1 = new PhoneInfo(name, phoneNumber);
				myPhone[numOfPhones++] = p1;
				System.out.println("친구정보 입력이 완료되었습니다.");
				break;

			case SubMenuItem.SCHOOL :
				System.out.print("전공:");major = scan.nextLine();
				System.out.print("학년:");grade = scan.nextInt();
				PhoneSchoolInfo sch1 = 
						new PhoneSchoolInfo(name, phoneNumber, major, grade);
				myPhone[numOfPhones++] = sch1;
				System.out.println("친구정보 입력이 완료되었습니다.");
				break;

			case SubMenuItem.COMPANY : 
				System.out.print("회사:");company = scan.nextLine();
				PhoneCompanyInfo com1 = 
						new PhoneCompanyInfo(name, phoneNumber, company);
				myPhone[numOfPhones++] = com1;
				System.out.println("친구정보 입력이 완료되었습니다.");
				break;

			default :  
				System.out.println("다시  입력하세요.");
			}

		}
		catch(MenuSelectException e) {
			System.out.println(e.getMessage());
			return;
		}
		catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요. ");
			return;
		}
	}////end of addphoneNumber 

	//새로운 친구 입력
	//	public void dataInput() {
	//		//사용자로부터 친구정보를 입력받기 위한 준비
	//		printMenu1();
	//		Scanner scan = new Scanner(System.in);
	//		String name, phoneNumber;
	//
	//
	//		System.out.print("이름:");name = scan.nextLine();
	//		System.out.print("전화번호:");phoneNumber = scan.nextLine();
	//		PhoneInfo p1 = new PhoneInfo(name, phoneNumber);
	//		myPhone[numOfPhones++] = p1;
	//
	//		System.out.println("친구정보 입력이 완료되었습니다.");
	//
	//	}////end of addphoneNumber 




	//친구정보 전체보기
	public void dataAllShow() {
		for(int i=0 ; i<numOfPhones ; i++) {
			myPhone[i].dataAllShow();
		}

		System.out.println("==전체정보가 출력되었습니다==");

	}////end of showPhoneInfo




	//주소록 검색
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();

		try {
			for(int i=0 ; i<numOfPhones ; i++) {			
				System.out.println("검색중인이름:"+ myPhone[i].name);
	
				//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
				if(searchName.compareTo(myPhone[i].name)==0) {
					myPhone[i].dataAllShow();
					System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
				}
				else {
					NullPointerException ex = new NullPointerException();
					throw ex;
				}
				
			}
		}
		catch (NullPointerException e) {
			System.out.println("찾는 데이터가 없습니다. ");
		}
	}////end of dataSearch

	
	
	
	
	
	
	
	//데이터 삭제
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();

		/*
		배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수.
		요소를 삭제한후 빈자리를 채울때 사용할 예정임.
		 */
		int deleteIndex = -1;

		for(int i=0 ; i<numOfPhones ; i++) {
			if(deleteName.compareTo(myPhone[i].name)==0) {
				//요소를 삭제하기 위해 참조값을 null로 변경
				myPhone[i] = null;
				//삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				//전체카운트 변수 -1 차감
				numOfPhones--;
			}
		}

		if(deleteIndex==-1) {
			//검색된 데이터가 없는경우...
			System.out.println("==삭제된 데이터가 없습니다==");

		}
		else {
			/*
			객체배열에서 검색된 요소를 삭제한후 입력된 위치의 바로뒤 요소를
			앞으로 하나씩 교환한다. 
			 */
			for(int i=deleteIndex ; i<numOfPhones ; i++) {
				myPhone[i] = myPhone[i+1];
			}
			System.out.println("==데이터("+ deleteIndex
					+"번)가 삭제되었습니다==");

		}
	}////end of deleteInfo
	/*	
	//친구정보를 파일형태로 저장하기
	public void saveFriendInfo() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ex20io/friend_info.obj")
				);

			//myFriends 객체배열에 저장된 친구의 정보만큼 반복
			for(int i=0 ; i<numOfFriends ; i++) {
				//객체배열의 i번째 요소를 파일로 저장
				out.writeObject(myFriends[i]);
			}			
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}		
	}*/
}

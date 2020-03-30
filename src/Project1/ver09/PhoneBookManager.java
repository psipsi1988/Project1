package Project1.ver09;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

import Project1.ver09.IConnectImpl;
public class PhoneBookManager extends IConnectImpl{

	
	public static PreparedStatement psmt;
	public Statement stmt;
	public CallableStatement csmt;
	
	public PhoneBookManager(PhoneInfo[] myPhone, int numOfPhones) {
		super();
		this.myPhone = myPhone;
		this.numOfPhones = numOfPhones;
		

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
			int choice = scan.nextInt();

			switch(choice) {
			case 1: //정보 입력
				dataInput();
				System.out.println("입력된 정보 출력");
				break;
			case 2:
				//친구정보검색
				dataSearch();
				break;	
			case 3:
				//친구정보삭제
				dataDelete();
				break;	
			case 4:
				//전체정보출력
				dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;//main함수의 종료는 프로그램 종료로 이어진다.
			}
		}
	}


	private static PhoneInfo[] myPhone;
	private static int numOfPhones;//친구정보를 추가할때마다 +1 증가

	//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
	public PhoneBookManager(int num) {
		myPhone = new PhoneInfo[num];
		numOfPhones = 0;
	}

	//새로운 친구 입력
	public static void dataInput() {

		try {
			//1. 쿼리문 준비 : 값의 세팅이 필요한 부분을 ?로 대체한다. 
			String query = "INSERT INTO member VALUES (?,?,?,?)";
			
			//2. prepared객체 생성 : 생성 시 준비한 쿼리문을 인자로 전달한다. 
			psmt  = con.prepareStatement(query);
			
			//3. DB에 입력할 값을 사용자로부터 입력받음. 
			Scanner scan = new Scanner(System.in);
			System.out.println("이름:");
			String name = scan.nextLine();
			System.out.println("전화번호:");
			String phoneNumber= scan.nextLine();
			System.out.println("생년월일:");
			String birthday = scan.nextLine();
			
			//4. 인파라미터 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작. 
			psmt.setString(1, name);
			psmt.setString(2, phoneNumber);
			psmt.setString(3, birthday);
			
			//psmt.setString(4, "2018-11-20");//날짜를 문자열로 입력하는 경우
			/*
			현재 날짜를 JAVA단에서 입력하는 경우 아래와 같은 변환 과정을 거쳐야 한다. 
			util패키지로 시간을 가져온 후 sql패키지 형태로 변환한다. 
			이때는 date형으로 입력되기 때문에 stDate()메소드를 사용해서 
			인파라미터를 설정해야 한다. 
			 */
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			psmt.setDate(4, sqlDate);
			
			/*
			인파라미터 설정 시 사용하는 메소드
				쿼리문에 ?가 있는 부분에 인덱스로 접근해서 설정한다. 
				자료형이
					숫자면 setInt()
					문자면 setString()
					날짜면 setDate()를 사용한다. 
				해당 메소드 사용 시 '(싱글쿼테이션)은 자동으로 삽입된다. 
			 */
			
			
			
			//5. 쿼리실행을 위해 prepared객체를 실행한다. 
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다. ");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		
		
		
		
		
		
		/*
		//사용자로부터 친구정보를 입력받기 위한 준비
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, birthday;


		System.out.print("이름:");name = scan.nextLine();
		System.out.print("전화번호:");phoneNumber = scan.nextLine();
		System.out.print("생년월일:");birthday = scan.nextLine();
		PhoneInfo p1 = new PhoneInfo(name, phoneNumber, birthday);
		myPhone[numOfPhones++] = p1;

		System.out.println("친구정보 입력이 완료되었습니다.");*/
	}////end of addphoneNumber 

	//친구정보 전체보기
	public static void dataAllShow() {
		for(int i=0 ; i<numOfPhones ; i++) {
			myPhone[i].showPhoneInfo();
		}

		System.out.println("==전체정보가 출력되었습니다==");
	}////end of showPhoneInfo


	//주소록 검색
	public static void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();

		for(int i=0 ; i<numOfPhones ; i++) {			
			System.out.println("검색중인이름:"+ myPhone[i].name);

			//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
			if(searchName.compareTo(myPhone[i].name)==0) {
				myPhone[i].showPhoneInfo();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
			}
		}
	}////end of dataSearch

	//데이터 삭제
	public static void dataDelete() {
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

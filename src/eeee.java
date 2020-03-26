//import java.util.Scanner;
//
///*
//연습문제] 해당 프로그램은 친구의 정보를 저장하게 된다. 프로그램
//종료시 Friend타입의 객체배열에 저장된 친구의 정보를 파일의 형태로
//저장할 수 있도록 직렬화 하시오.
//-저장될파일명 : friend_info.obj
// */
//class Friend implements Serializable {
//	
//	String name;	//이름
//	String phone;	//전화번호
//	String birthday;	//생년월일
//
//	public Friend(String name, String phone, String birthday) {
//		this.name = name;
//		this.phone = phone;
//		this.birthday = birthday;
//	}
//	//멤버메소드
//	/*
//	멤버변수 전체 정보를 출력하는 메소드
//	 */
//	public void showAllData() {
//		System.out.println("이름:"+ name);
//		System.out.println("전화번호:"+ phone);
//		System.out.println("생년월일:"+ birthday);
//	}
//	/*
//	간략한 정보만을 출력하는 메소드로, 현재 실행부가 없는 상태로
//	정의되었다. 여기서는 오버라이딩을 할 목적으로 정의되었다. 
//	 */
//	public void showBasicInfo() { }
//}
// 
//
////고딩친구
//class HighFriend extends Friend {
//	
//	String nickname;//자식에서 확장한 멤버변수
//	public HighFriend(String name, String phone, String birthday,
//			String nickname) {
//		super(name, phone, birthday);
//		this.nickname = nickname;
//	}
//
//	/*
//	고딩친구의 전체정보 출력을 위해 부모에서 정의된 메소드를
//	super를 통해 호출하고, 자식에서 확장한 변수를 별도의 
//	print문을 통해 출력하고있다.
//	 */
//	@Override
//	public void showAllData() {
//		System.out.println("==고딩친구(전체정보)==");
//		super.showAllData();
//		System.out.println("별명:"+ nickname);
//	}
//	/*
//	자식에서 오버라이딩 하여 재정의한 메소드로 고딩친구의
//	간략정보를 출력한다. 
//	 */
//	@Override
//	public void showBasicInfo() {
//		System.out.println("==고딩친구==");
//		System.out.println("별명:"+ nickname);
//		System.out.println("전번:"+ phone);
//	}
//}
//class UnivFriend extends Friend	{
//	String major; 
//	public UnivFriend(String name, String phone, String birthday,
//			String major) {
//		super(name, phone, birthday);
//		this.major = major;
//	}
//	@Override
//	public void showAllData() {
//		System.out.println("==대딩친구(전체정보)==");
//		super.showAllData();
//		System.out.println("전공:"+ major);
//	}
//	@Override
//	public void showBasicInfo() {
//		System.out.println("==대딩친구==");
//		System.out.println("이름:"+ name);
//		System.out.println("전화번호:"+ phone);
//	}
//}
//
//
//
//
//
//
//
///*
//프로그램의 흐름을 제어하는 목적으로 생성하는 클래스로
//주로 컨트롤클래스 혹은 핸들러클래스라고 한다.
//해당 프로그램에서 기능을 담당하게 된다.
// */
//class FriendInfoHandler {
//	//멤버변수
//	/*
//	Friend타입의 객체배열은 하위클래스인 High, Univ객체를 
//	모두 저장할수 있으므로, 하나의 배열내에 2개의 객체를 
//	동시에 저장하여 관리할 수 있다.   
//	 */
//	private Friend[] myFriends;
//	private int numOfFriends;//친구정보를 추가할때마다 +1 증가
// 
//	//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
//	public FriendInfoHandler(int num) {
// 		myFriends = new Friend[num];
//		numOfFriends = 0;
//	}
//	
//	//새로운 친구 입력
//	public void addFriend(int choice) {
//		
//		//사용자로부터 친구정보를 입력받기위한 준비
//		Scanner scan = new Scanner(System.in);
//		String iName,iPhone,ibirthday,iNickname,iMajor;
//
//		//공통사항 입력받기
//		System.out.print("이름:");iName = scan.nextLine();
//		System.out.print("전화번호:");iPhone = scan.nextLine();
//		System.out.print("생년월일:");ibirthday = scan.nextLine();
//
//		
//		/*
//		1.친구정보를 입력받은후...
//		2.객체배열 0번방에 객체를 저장하고...
//		3.numOfFriends 변수를 1 증가시킨다.(후위증가)
//		 */
//		if(choice==1) {			
//			//고딩친구 입력
//			System.out.print("별명:"); iNickname = scan.nextLine();
//			HighFriend high =
//					new HighFriend(iName, iPhone, ibirthday, iNickname);
//			myFriends[numOfFriends++] = high;
//		}
//		else if(choice==2) {
//			//대딩친구 입력
//			System.out.print("전공:"); iMajor = scan.nextLine();
//			myFriends[numOfFriends++] =
//					new UnivFriend(iName, iPhone, ibirthday, iMajor);
//		}
//
//		System.out.println("친구정보 입력이 완료되었습니다.");
//	}////end of addFriend 
//	
//	//친구정보 전체보기
//	public void showAllData() {
//		for(int i=0 ; i<numOfFriends ; i++) {
//			myFriends[i].showAllData();
//		}
//
//		System.out.println("==전체정보가 출력되었습니다==");
//	}////end of showAllData
//
//	//친구정보 간략보기
//	/*
//	1. 고딩친구 정보를 Friend 추가
//	2. High객체가 Friend타입으로 자동형변환되어 저장
//	3. 객체배열에 저장된 객체들을 for문을 통해 순차적으로 출력
//		이때 오버라이딩된 메소드를 통해 항상 해당 객체의 
//		정보를 출력할수 있음. (참조변수의 타입에 영향을 
//		받지않음)
//	 */
//	public void showSimpleData() {
//		for(int i=0 ; i<numOfFriends ; i++) {
//			myFriends[i].showBasicInfo();
//		}
//
//		System.out.println("==간략정보가 출력되었습니다==");
//	}////end of showSimpleData
//	
//	
//	//생년월일록 검색
//	public void searchInfo() {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("검색할 이름을 입력하세요:");
//		String searchName = scan.nextLine();
//
//		for(int i=0 ; i<numOfFriends ; i++) {			
//			System.out.println("검색중인이름:"+ myFriends[i].name);
//			
//			//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
//			if(searchName.compareTo(myFriends[i].name)==0) {
//				myFriends[i].showAllData();
//				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
//			}
//		}
//	}////end of searchInfo
//
//	//생년월일 항목 삭제
//	public void deleteInfo() {
//		Scanner scan = new Scanner(System.in);
//		System.out.print("삭제할 이름을 입력하세요:");
//		String deleteName = scan.nextLine();
//		
//		/*
//		배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수.
//		요소를 삭제한후 빈자리를 채울때 사용할 예정임.
//		 */
//		int deleteIndex = -1;
//
//		for(int i=0 ; i<numOfFriends ; i++) {
//			if(deleteName.compareTo(myFriends[i].name)==0) {
//				//요소를 삭제하기 위해 참조값을 null로 변경
//				myFriends[i] = null;
//				//삭제된 요소의 인덱스값 저장
//				deleteIndex = i;
//				//전체카운트 변수 -1 차감
//				numOfFriends--;
//			}
//		}
//
//		if(deleteIndex==-1) {
//			//검색된 데이터가 없는경우...
//			System.out.println("==삭제된 데이터가 없습니다==");
//		}
//		else {
//			/*
//			객체배열에서 검색된 요소를 삭제한후 입력된 위치의 바로뒤 요소를
//			앞으로 하나씩 교환한다. 
//			 */
//			for(int i=deleteIndex ; i<numOfFriends ; i++) {
//				myFriends[i] = myFriends[i+1];
//			}
//			System.out.println("==데이터("+ deleteIndex
//					+"번)가 삭제되었습니다==");
//		}
//	}////end of deleteInfo
//	
//	//친구정보를 파일형태로 저장하기
//	public void saveFriendInfo() {
//		
//		try {
//			ObjectOutputStream out = new ObjectOutputStream(
//					new FileOutputStream("src/ex20io/friend_info.obj")
//				);
//			
//			//myFriends 객체배열에 저장된 친구의 정보만큼 반복
//			for(int i=0 ; i<numOfFriends ; i++) {
//				//객체배열의 i번째 요소를 파일로 저장
//				out.writeObject(myFriends[i]);
//			}			
//		}
//		catch (Exception e) {
//			System.out.println("예외발생");
//			e.printStackTrace();
//		}		
//	}
//}
//
//public class E13MyFriendSerializableT {
//
//	//프로그램에서의 입력메뉴 출력
//	public static void menuShow() {
//		System.out.println("***메뉴를 선택하세요***");
//		System.out.println("1.고딩친구입력");
//		System.out.println("2.대딩친구입력");
//		System.out.println("3.전체정보출력");
//		System.out.println("4.간략정보출력");
//		System.out.println("5.검색");
//		System.out.println("6.삭제");
//		System.out.println("7.프로그램종료");
//		System.out.print("메뉴선택>>>");
//	}
//
//	public static void main(String[] args) {
//		
//		//프로그램 전반에 대한 비즈니스로직을 가진 핸들러 객체 생성
//		FriendInfoHandler handler =
//				new FriendInfoHandler(100);
//
//		while(true) {
//			//메뉴출력을 위한 메소드호출
//			menuShow();
//
//			Scanner scan = new Scanner(System.in);
//			int choice = scan.nextInt();
//
//			switch(choice) {
//			case 1:case 2:
//				handler.addFriend(choice);
//				break;
//			case 3:
//				//전체정보출력
//				handler.showAllData();
//				break;
//			case 4:
//				//간략정보출력
//				handler.showSimpleData();
//				break;
//			case 5:
//				//친구정보검색
//				handler.searchInfo();
//				break;
//			case 6:
//				//친구정보삭제
//				handler.deleteInfo();
//				break;
//			case 7:
//				handler.saveFriendInfo();
//				System.out.println("프로그램을 종료합니다.");
//				return;//main함수의 종료는 프로그램 종료로 이어진다.
//			}
//		}
//	}
//}

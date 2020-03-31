package Project1.ver09;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class PhoneBookManager {


	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement psmt;




	public PhoneBookManager() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:orcl", "kosmo", "1234");
			System.out.println("오라클 DB 연결성공");
		}
		catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 예외발생");
		}
	}





	private PhoneInfo[] myPhone;
	private int numOfPhones;//친구정보를 추가할때마다 +1 증가

	//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
	public PhoneBookManager(int num) {
		myPhone = new PhoneInfo[num];
		numOfPhones = 0;
	}

	//새로운 친구 입력
	public void addphoneNumber() {

		try {

			String query = "INSERT INTO phonebook_tb VALUES (?,?,? )";

			psmt = con.prepareStatement(query);

			Scanner scan = new Scanner(System.in);
			String name, phoneNumber, birthday;


			System.out.print("이름:");name = scan.nextLine();
			System.out.print("전화번호:");phoneNumber = scan.nextLine();
			System.out.print("생년월일:");birthday = scan.nextLine();

			System.out.println("친구정보 입력이 완료되었습니다.");

			psmt.setString(1,  name);
			psmt.setString(2,  phoneNumber);
			psmt.setString(3,  birthday);

			psmt.executeUpdate();


		}

		catch(Exception e) {
			e.printStackTrace();
		}





		//사용자로부터 친구정보를 입력받기 위한 준비
	}////end of addphoneNumber 

	//친구정보 전체보기
	public void dataAllShow() {
		for(int i=0 ; i<numOfPhones ; i++) {
			myPhone[i].showPhoneInfo();
		}

		System.out.println("==전체정보가 출력되었습니다==");
	}////end of showPhoneInfo


	//주소록 검색
	public void dataSearch() {

		System.out.print("검색할 이름을 입력하세요:");
		Scanner scan = new Scanner(System.in);
		String searchName = scan.nextLine();
		try {

			String sql = 
					"select * from phonebook_tb where name like '"+searchName+"'";
			stmt = con.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(1);
				int phoneNumber = rs.getInt(2);
				String birthday = rs.getString(3);

				System.out.printf("%s, %s, %s", name, phoneNumber, birthday);
				System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");

			}
		



	}
	catch(SQLException e) {
		e.printStackTrace();
	}


}////end of dataSearch

//데이터 삭제
public void dataDelete() {
	
	Scanner scan = new Scanner(System.in);
	System.out.print("삭제할 이름을 입력하세요:");
	String deleteName = scan.nextLine();
	try {
		
		String query = "delete from phonebook_tb where name = ? "; 
		psmt = con.prepareStatement(query);
		
		psmt.setString(1, deleteName);
		psmt.executeUpdate();
		
		
		
		/*
		배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수.
		요소를 삭제한후 빈자리를 채울때 사용할 예정임.
		 */
		}
	catch(Exception e) {
		e.printStackTrace();
	}

		
	}
}

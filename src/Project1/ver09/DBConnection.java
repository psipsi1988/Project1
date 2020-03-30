package Project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException 
	{
		
		/*
		JDBC 프로그래밍 절차
		
		1] 오라클용 JDBC드라이버를 메모리에 로드함
			: new를 사용하지 않고 클래스명으로 직접 찾아서 객체 생성 후 
			메모리에 로드하는 forName()메소드를 사용한다. 
			메모리에 로딩된 드라이버가 DriverManager라는 클래스에 등록된다. 
		 */
		Class.forName("oracle.jdbc.OracleDriver");
		
		
		/*
		2] 오라클에 연결하기 위한 커넥션URL, 계정ID, 패스워드를 준비한다. 
			커넥션URL =>
				jdbc:oracle:thin://@IP주소:포트번호:SID
			※서버 환경에 따라 ip주소, 포트번호, sid는 변경될 수 있다. 
		 */
		String url = "jdbc:oracle:thin://@localhost:1521:orcl";
		String userid = "KOSMO";
		String userpw = "1234";
		
		/*
		2-1] DriverManager클래스의 getConnection()메소드를 호출하여 
		오라클에 연결을 시도한다. 연결에 성공할 경우 연결된 주소를 반환한다. 
		 */
		Connection con = DriverManager.getConnection(url, 
				userid, userpw);
		
		if(con!=null) {
			System.out.println("Oracle DB 연결 성공");
			
			/*
			3] 쿼리문 작성
				: 쿼리문을 작성할 때 주의할 점은 줄바꿈을 할 때 앞뒤로 
				스페이스를 삽입하는 것이 좋다. 
				그렇지 않으면 서로 문장이 이어지게 되어 SyntaxError가 발생하게 된다. 
			 */
			String sql = "select * from employees where "
					+ " department_id=50 "
					+ " order by employee_id asc ";
			
			
			/*
			4] 쿼리문 전송을 위한 Statement계열의 객체를 생성한다. 
			해당 객체는 주로 정적인 쿼리를 실행할 때 사용된다. 
			 */
			Statement stmt = con.createStatement();
			
			/*
			5] Statement 객체를 사용하여  오라클로 작성된 쿼리문을 전송한다.
				오라클은 전송받은 쿼리를 실행 후 결과를 반환하는데 
				이를 ResultSet객체를 통해 받는다. 
			 */
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				/*
				오라클이 반환해준 ResultSet객체의 개수만큼 반복하면서 
				콘솔에 출력한다. getXXX()계열의 함수의 인자로는 
				select절의 순서대로 '인덱스'를 쓸 수도 있고 
				'컬럼명'을 쓸 수도 있다. 
				 */
				String emp_id = rs.getString(1);//employee_id컬럼
				String f_name = rs.getString("first_name");//컬럼명을 그대로 이용함
				String l_name = rs.getString(3);
				java.sql.Date h_date = rs.getDate("hire_date");
				int sal = rs.getInt("salary");
				
				System.out.printf("%s %s %s %s %s %n", 
						emp_id, f_name, l_name, h_date, sal);
			}
			/*
			6] 자원 반납 : 모든  작업을 마친 후에는 메모리 절약을 위해 
				연결했던 자원을 반납한다. 
			 */
			rs.close();//ResultSet객체
			stmt.close();//Statement객체
			con.close();//Connection객체
		}
		else {
			System.out.println("연결 실패");
		}
		
		

	}

}

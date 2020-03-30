package Project1.ver09;

public interface IConnect {

	
	/*
	멤버 상수
		: interface에 선언된 변수는 무조건 public static final이  붙어
		정적 상수로 선언된다. 
	 */
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
	
	/*
	멤버 추상 메소드
		: public abstract가 붙어 추상메소드로 선언된다. 
	 */
	void connect(String user, String pass);//DB연결
	void execute();//쿼리실행
	void close();//자원반납
	//사용자 입력을 위한 추상메소드 선언
	String scanValue(String title);
	
}

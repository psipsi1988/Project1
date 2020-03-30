package Project1.ver08;

public class MenuSelectException extends Exception{
	
	public MenuSelectException() {
		super("메뉴에 없는 숫자를 입력하셨습니다.\n 메뉴에 있는 숫자를 입력해주세요.");
	}
	
}

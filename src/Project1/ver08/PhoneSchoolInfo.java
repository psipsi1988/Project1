package Project1.ver08;

public class PhoneSchoolInfo extends PhoneInfo{
	String major; //전공
	int grade;	//학년
	
	public PhoneSchoolInfo(String name, String phoneNumber, 
			String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	
	@Override
	public void dataAllShow() {
		super.dataAllShow();
		System.out.println("전공:" + major);
		System.out.println("학년:" + grade);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result  =super.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}



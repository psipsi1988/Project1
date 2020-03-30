package Project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo{

	String company; //회사

	public PhoneCompanyInfo(String name, String phoneNumber, String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	@Override
	public void dataAllShow() {
		super.dataAllShow();
		System.out.println("회사:"+ company);
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

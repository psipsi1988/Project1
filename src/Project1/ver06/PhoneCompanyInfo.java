package Project1.ver06;

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
}

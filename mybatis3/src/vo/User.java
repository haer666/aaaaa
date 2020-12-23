package vo;

public class User {
	private String userId;
	private String userName;
	private String password;
	private String phone;//�绰
	private double balance;//���
	private double payment;//����,Ϊ�����統payment=10000,��ʾ����10000��������payment
	private boolean effectiveness;//�Ƿ��ʧ
	
	public User() {
		super();
	}
	
	

	public User(String userId, String userName, String password, String phone, double balance, double payment,
			boolean effectiveness) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.balance = balance;
		this.payment = payment;
		this.effectiveness = effectiveness;
	}
	
	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+"\n" + ", balance=" + balance + ", payment=" + payment + ", effectiveness=" + effectiveness + "]";
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public boolean isEffectiveness() {
		return effectiveness;
	}

	public void setEffectiveness(boolean effectiveness) {
		this.effectiveness = effectiveness;
	}
	
	
	

}
package vo;

public class User {
	private String userId;
	private String userName;
	private String password;
	private String phone;//电话
	private double balance;//金额
	private double payment;//货款,为正，如当payment=10000,表示货款10000，还款则payment
	private boolean effectiveness;//是否挂失
	
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
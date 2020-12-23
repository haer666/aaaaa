package vo;

public class Staff {
	private String userId;
	private String userName;
	private String password;
	private String phone;//电话
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
	
	public Staff(String userId, String userName, String password, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Staff [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ "]";
	}
	public Staff() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
}

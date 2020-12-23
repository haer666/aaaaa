package dao;

import vo.User;


public interface IUserDAO {
	public User getByUserId(String userId);
	
	public void updateUser(User user);
	
	public void deleteUser(String userId);
	
	public void insertUser(User user);
	
	
}

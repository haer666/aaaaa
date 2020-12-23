package sevice;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.IUserDAO;
import util.MybatisUtils;
import vo.User;

public class CustomService {
	private static Scanner inScanner = new Scanner(System.in);
	
	public static String theUserId =""; 
	
	public static boolean entry() {//用户登录
		int count = 0;
		while(count < 3) {
			System.out.println("请输入userId:");
			theUserId = inScanner.nextLine();
			System.out.println("请输入password:");
			String password = inScanner.nextLine();
			
			SqlSession session = MybatisUtils.getSqlSession();
			IUserDAO dao = session.getMapper(IUserDAO.class);
			User user = dao.getByUserId(theUserId);
			
			System.out.println(user.toString());
			session.close();
			if(password.equals(user.getPassword())) {
				System.out.println("密码正确，登陆成功");
				return true;
			}
			System.out.println("userId或password错误，请重新输入！");
			count++;
		}
		System.out.println("userId或password输入错误三次，请退出！！！");
		return false;
	}
	
	public static void updateBalance(String userId,double amount,boolean choose ) {//choose为true存款,false取款，amount为金额
		if(!choose) amount=-amount;
		
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user = dao.getByUserId(userId);
		System.out.println("请输入密码：");
		if(!inScanner.nextLine().equals(user.getPassword())) {
			System.out.println("密码错误，即将推出！！");
			return;
		}
		user.setBalance(user.getBalance()+amount);//修改金额
		dao.updateUser(user);
		session.close();
	}
	
	public static void updatePayment(String userId,double amount,boolean choose ) {//choose为true货款,false还款，amount为金额
		if(!choose) amount=-amount;
		
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user = dao.getByUserId(userId);
		System.out.println("请输入密码：");
		if(!inScanner.nextLine().equals(user.getPassword())) {
			System.out.println("密码错误，即将推出！！");
			return;
		}
		user.setPayment(user.getPayment()+amount);//修改金额
		dao.updateUser(user);
		session.close();
	}
	
	public static void query(String userId) {//查询
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user = dao.getByUserId(userId);
		System.out.println(user.toString());
		session.close();
	}
	
	public static void updatePassword(String userId) {
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user = dao.getByUserId(userId);
		String newPassword = "";
		System.out.println("请输入原密码：");
		if(inScanner.nextLine().equals(user.getPassword())) {
			System.out.println("请输入新密码：");
			newPassword = inScanner.nextLine();
			System.out.println("请确认新密码");
			while(!newPassword.equals(inScanner.nextLine())) {
				System.out.println("新密码输入不一致");
				System.out.println("新密码为："+newPassword);
				System.out.println("请重新输入新密码");
			}
		}
		user.setPassword(newPassword);
		dao.updateUser(user);	
		session.close();
		System.out.println("密码修改成功");
	}
	
	public static void transferAccounts(String yourUserId,String otherUserId) {//转帐
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user1 = dao.getByUserId(yourUserId);
		User user2 = dao.getByUserId(otherUserId);
		
		System.out.println("请输入密码：");
		if(!inScanner.nextLine().equals(user1.getPassword())) {
			System.out.println("密码错误，即将推出！！");
			return;
		}
		System.out.println("请输入转账金额（余额为"+user1.getBalance()+"）：	");
		double amount = inScanner.nextDouble();
		user1.setBalance(user1.getBalance()-amount);
		user2.setBalance(user2.getBalance()+amount);
		dao.updateUser(user1);
		dao.updateUser(user2);
		session.close();
		System.out.println("转账成功");
	}
	
	
	public static void main(String[] args) {
		transferAccounts("456", "123");
	}
}


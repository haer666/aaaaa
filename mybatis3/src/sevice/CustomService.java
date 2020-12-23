package sevice;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.IUserDAO;
import util.MybatisUtils;
import vo.User;

public class CustomService {
	private static Scanner inScanner = new Scanner(System.in);
	
	public static String theUserId =""; 
	
	public static boolean entry() {//�û���¼
		int count = 0;
		while(count < 3) {
			System.out.println("������userId:");
			theUserId = inScanner.nextLine();
			System.out.println("������password:");
			String password = inScanner.nextLine();
			
			SqlSession session = MybatisUtils.getSqlSession();
			IUserDAO dao = session.getMapper(IUserDAO.class);
			User user = dao.getByUserId(theUserId);
			
			System.out.println(user.toString());
			session.close();
			if(password.equals(user.getPassword())) {
				System.out.println("������ȷ����½�ɹ�");
				return true;
			}
			System.out.println("userId��password�������������룡");
			count++;
		}
		System.out.println("userId��password����������Σ����˳�������");
		return false;
	}
	
	public static void updateBalance(String userId,double amount,boolean choose ) {//chooseΪtrue���,falseȡ�amountΪ���
		if(!choose) amount=-amount;
		
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user = dao.getByUserId(userId);
		System.out.println("���������룺");
		if(!inScanner.nextLine().equals(user.getPassword())) {
			System.out.println("������󣬼����Ƴ�����");
			return;
		}
		user.setBalance(user.getBalance()+amount);//�޸Ľ��
		dao.updateUser(user);
		session.close();
	}
	
	public static void updatePayment(String userId,double amount,boolean choose ) {//chooseΪtrue����,false���amountΪ���
		if(!choose) amount=-amount;
		
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user = dao.getByUserId(userId);
		System.out.println("���������룺");
		if(!inScanner.nextLine().equals(user.getPassword())) {
			System.out.println("������󣬼����Ƴ�����");
			return;
		}
		user.setPayment(user.getPayment()+amount);//�޸Ľ��
		dao.updateUser(user);
		session.close();
	}
	
	public static void query(String userId) {//��ѯ
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
		System.out.println("������ԭ���룺");
		if(inScanner.nextLine().equals(user.getPassword())) {
			System.out.println("�����������룺");
			newPassword = inScanner.nextLine();
			System.out.println("��ȷ��������");
			while(!newPassword.equals(inScanner.nextLine())) {
				System.out.println("���������벻һ��");
				System.out.println("������Ϊ��"+newPassword);
				System.out.println("����������������");
			}
		}
		user.setPassword(newPassword);
		dao.updateUser(user);	
		session.close();
		System.out.println("�����޸ĳɹ�");
	}
	
	public static void transferAccounts(String yourUserId,String otherUserId) {//ת��
		SqlSession session = MybatisUtils.getSqlSession();
		IUserDAO dao = session.getMapper(IUserDAO.class);
		User user1 = dao.getByUserId(yourUserId);
		User user2 = dao.getByUserId(otherUserId);
		
		System.out.println("���������룺");
		if(!inScanner.nextLine().equals(user1.getPassword())) {
			System.out.println("������󣬼����Ƴ�����");
			return;
		}
		System.out.println("������ת�˽����Ϊ"+user1.getBalance()+"����	");
		double amount = inScanner.nextDouble();
		user1.setBalance(user1.getBalance()-amount);
		user2.setBalance(user2.getBalance()+amount);
		dao.updateUser(user1);
		dao.updateUser(user2);
		session.close();
		System.out.println("ת�˳ɹ�");
	}
	
	
	public static void main(String[] args) {
		transferAccounts("456", "123");
	}
}


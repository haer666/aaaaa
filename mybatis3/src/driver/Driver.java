package driver;


import java.util.Scanner;


import sevice.CustomService;

public class Driver {
	static private void customDisplay() {
		System.out.println("==================DD===================");
		System.out.println("1.���                     2.ȡ��                      3.ת��	");
		System.out.println("4.����       		5.����		6.��ѯ "	);
		System.out.println("7.�޸�����		8.�˳�");
		System.out.println("======================================");
		System.out.println("����������ѡ��");
		
	}
	
	static private void  staffDisplay() {
		System.out.println("==================DDϵͳ===================");
		System.out.println("1.���                     2.ȡ��                      3.ת��	");
		System.out.println("4.����       		5.����		6.��ѯ "	);
		System.out.println("7.�޸�����		8.�˳�");
		System.out.println("======================================");
		System.out.println("����������ѡ��");
	}
	
	private static Scanner in = new Scanner(System.in);
	// TODO �Զ����ɵĹ��캯�����
	public static void main(String[] args) throws Exception {
		System.out.println("��ӭʹ��DD����ϵͳ����ѡ���ɫ,1.�ͻ���2.������Ա");
		if (in.nextInt()==1) {
			if(CustomService.entry()) {
				customDisplay();
				int choose=in.nextInt();
				while(choose!=8) {
					switch(choose){
						case 1:
							System.out.println("���������");
							CustomService.updateBalance(CustomService.theUserId,in.nextDouble(),true);
							System.out.println("���ɹ���");
							break;
						case 2:
							System.out.println("������ȡ���");
							CustomService.updateBalance(CustomService.theUserId,in.nextDouble(),false);
							System.out.println("ȡ��ɹ���");
							break;
						case 3:
							System.out.println("������Է���userId:");
							String otherUserId = in.next();
							CustomService.transferAccounts(CustomService.theUserId, otherUserId);
							break;
						case 4:
							System.out.println("����������");
							CustomService.updatePayment(CustomService.theUserId,in.nextDouble(),false);
							System.out.println("����ɹ���");
							break;
						case 5:
							System.out.println("�����뻹���");
							CustomService.updatePayment(CustomService.theUserId,in.nextDouble(),false);
							System.out.println("����ɹ���");
							break;
						case 6:
							CustomService.query(CustomService.theUserId);
							break;
						case 7:
							CustomService.updatePassword(CustomService.theUserId);
							break;
						case 8:
							break;
						default:
							System.out.println("��������ȷ��ѡ��1-8����");
							break;
					}
					System.out.println("����������ѡ��");
					choose = in.nextInt();
				}
			}
		} else {

		}
	}
}
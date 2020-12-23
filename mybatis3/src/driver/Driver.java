package driver;


import java.util.Scanner;


import sevice.CustomService;

public class Driver {
	static private void customDisplay() {
		System.out.println("==================DD===================");
		System.out.println("1.存款                     2.取款                      3.转账	");
		System.out.println("4.货款       		5.还款		6.查询 "	);
		System.out.println("7.修改密码		8.退出");
		System.out.println("======================================");
		System.out.println("请输入您的选择：");
		
	}
	
	static private void  staffDisplay() {
		System.out.println("==================DD系统===================");
		System.out.println("1.存款                     2.取款                      3.转账	");
		System.out.println("4.货款       		5.还款		6.查询 "	);
		System.out.println("7.修改密码		8.退出");
		System.out.println("======================================");
		System.out.println("请输入您的选择：");
	}
	
	private static Scanner in = new Scanner(System.in);
	// TODO 自动生成的构造函数存根
	public static void main(String[] args) throws Exception {
		System.out.println("欢迎使用DD银行系统，请选择角色,1.客户或2.工作人员");
		if (in.nextInt()==1) {
			if(CustomService.entry()) {
				customDisplay();
				int choose=in.nextInt();
				while(choose!=8) {
					switch(choose){
						case 1:
							System.out.println("请输入存款金额：");
							CustomService.updateBalance(CustomService.theUserId,in.nextDouble(),true);
							System.out.println("存款成功！");
							break;
						case 2:
							System.out.println("请输入取款金额：");
							CustomService.updateBalance(CustomService.theUserId,in.nextDouble(),false);
							System.out.println("取款成功！");
							break;
						case 3:
							System.out.println("请输入对方的userId:");
							String otherUserId = in.next();
							CustomService.transferAccounts(CustomService.theUserId, otherUserId);
							break;
						case 4:
							System.out.println("请输入货款金额：");
							CustomService.updatePayment(CustomService.theUserId,in.nextDouble(),false);
							System.out.println("货款成功！");
							break;
						case 5:
							System.out.println("请输入还款金额：");
							CustomService.updatePayment(CustomService.theUserId,in.nextDouble(),false);
							System.out.println("还款成功！");
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
							System.out.println("请输入正确的选择（1-8）：");
							break;
					}
					System.out.println("请输入您的选择：");
					choose = in.nextInt();
				}
			}
		} else {

		}
	}
}
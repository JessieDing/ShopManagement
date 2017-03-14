package ui;

import java.util.Scanner;

import busi.Goods;
import busi.Provider;
import busi.TransFactory;
import busi.TransInterface;
import db.DBOper;

public class ShopManagementMain {

	public static void main(String[] args) {
		// 1.首先打印菜单主界面
		// 2.客户选择交易后，进入各个交易对应的操作/提示界面
		// 3.客户完成输入后，从界面读取客户输入的数据
		// 4.执行该交易，并且打印执行结果
		Scanner scan = new Scanner(System.in);

		DBOper dbhelper = new DBOper();// 数据操作对象
		/* 添加测试数据 */
		Goods g1 = new Goods("0001", "华为P8", "部", "0");
		Goods g2 = new Goods("0002", "华为麦芒", "部", "0");
		Goods g3 = new Goods("0003", "Iphone7", "部", "0");
		Goods g4 = new Goods("0004", "三星Galaxy", "部", "0");
		dbhelper.insertGoods(g1);
		dbhelper.insertGoods(g2);
		dbhelper.insertGoods(g3);
		dbhelper.insertGoods(g4);

		Provider p1 = new Provider("01", "迅捷通讯", "天府三街", "02812345675", "0");
		Provider p2 = new Provider("02", "迪信通", "天府二街", "02812345676", "0");
		Provider p3 = new Provider("03", "赛格", "太升南路", "02812345677", "0");
		Provider p4 = new Provider("04", "新世界", "天府五街", "02812345678", "0");
		dbhelper.insertProvider(p1);
		dbhelper.insertProvider(p2);
		dbhelper.insertProvider(p3);
		dbhelper.insertProvider(p4);

		/* 添加测试数据结束 */

		while (true) {
			prtMainMenu(); // 打印主菜单

			String strTrans = scan.next();// 读取交易
			if (strTrans.equalsIgnoreCase("q")) {
				break;
			}

			TransInterface trans = null;
			TransFactory tFactory = new TransFactory();
			trans = tFactory.createTrans(strTrans);
			if (trans != null) {
				trans.setDbhelper(dbhelper);
				trans.prtPrompt();// 打印交易提示信息
				if (trans.getInput() != 0) {// 读取输入的数据
					trans.prtResult();
					System.out.println("获取输入数据失败");
				} else {
					if (trans.doTrans() != 0) {
						trans.prtResult();
						continue;
					} else {
						trans.prtResult();
						continue;
					}
				}
			} else {
				System.out.println("创建交易实例出错");
			}
		}

		scan.close();
		System.out.println("系统正常退出");
	}

	public static void prtMainMenu() {
		System.out.println();
		System.out.println("****************商品进销存系统*****************");
		System.out.println("\t1-添加商品信息\t2-修改商品信息");
		System.out.println("\t3-查询商品信息\t4-新增供货商");
		System.out.println("\t5-修改供货商信息\t6-查询供货商信息");
		System.out.println("\t7-采购信息录入\t8-销售信息录入");
		System.out.println("\t9-库存修改\t0-库存查询");
		System.out.println("********************************************");
		System.out.println("请输入您要进行的操作,退出请输入q/Q：");
		System.out.println();
	}
}

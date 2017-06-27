package ui;

import busi.Goods;
import busi.Provider;
import busi.TransFactory;
import busi.TransInterface;
import db.DBOper;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class ShopManagementMain {

    public static void main(String[] args) throws ParseException {
        // 1.首先打印菜单主界面
        // 2.客户选择交易后，进入各个交易对应的操作/提示界面
        // 3.客户完成输入后，从界面读取客户输入的数据
        // 4.执行该交易，并且打印执行结果
        Scanner scan = new Scanner(System.in);
        DBOper dbhelper = new DBOper();// 数据操作对象
//		initTestData(dbhelper);
        dbhelper.loadAllGoods();
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
                trans.printPrompt();// 打印交易提示信息
                if (trans.getInput() != 0) {// 读取输入的数据
                    trans.printResult();
                    System.out.println("获取输入数据失败");
                } else {
                    if (trans.doTrans() != 0) {
                        trans.printResult();
                        continue;
                    } else {
                        trans.printResult();
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

    private static void initTestData(DBOper dbhelper) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2016);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DATE, 30);

        // 添加测试数据
        Goods g1 = new Goods("00010001", "华为P8", "部", "0", 120);
        Goods g2 = new Goods("00020002", "华为麦芒", "部", "0", 120);
        Goods g3 = new Goods("00030003", "Iphone7", "部", "0", 120);
        Goods g4 = new Goods("00040004", "红米2", "部", "0", 120);
        dbhelper.insertGoods(g1);
        dbhelper.insertGoods(g2);
        dbhelper.insertGoods(g3);
        dbhelper.insertGoods(g4);
        Provider p1 = new Provider("0001", "迅捷通讯", "天府三街", "02811111111", "0");
        Provider p2 = new Provider("0002", "迪信通", "天府二街", "02822222222", "0");
        Provider p3 = new Provider("0003", "赛格", "太升南路", "02833333333", "0");
        Provider p4 = new Provider("0004", "新世界", "天府五街", "02844444444", "0");
        dbhelper.insertProvider(p1);
        dbhelper.insertProvider(p2);
        dbhelper.insertProvider(p3);
        dbhelper.insertProvider(p4);
        // 采购 测试数据
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Purchase purchase1 = new Purchase("00010001", "华为P8", 8, "部", 2000, dateFormat.parse("2017-03-13"), "迪信通");
//		Purchase purchase2 = new Purchase("00020002", "华为麦芒", 6, "部", 1765.5, dateFormat.parse("2017-03-16"), "迅捷");
//		Purchase purchase3 = new Purchase("00030003", "Iphone7", 10, "部", 4890.5, dateFormat.parse("2017-03-12"), "赛格");
//		Purchase purchase4 = new Purchase("00040004", "红米2", 10, "部", 275.5, dateFormat.parse("2017-03-15"), "新世界");
//		dbhelper.insertPurchase(purchase1);
//		dbhelper.insertPurchase(purchase2);
//		dbhelper.insertPurchase(purchase3);
//		dbhelper.insertPurchase(purchase4);
        // 销售 测试数据
//		Sale sale1 = new Sale("00010001", "华为P8", 6, 3000, dateFormat.parse("2017-03-16"));
//		Sale sale2 = new Sale("00030003", "Iphone7", 3, 7299, dateFormat.parse("2017-03-16"));
//		Sale sale3 = new Sale("00020002", "华为麦芒", 5, 2699, dateFormat.parse("2017-03-16"));
//		Sale sale4 = new Sale("00040004", "红米2", 8, 599, dateFormat.parse("2017-03-16"));
//		Sale sale5 = new Sale("00030003", "Iphone7", 5, 6999, dateFormat.parse("2017-03-13"));
//		dbhelper.insertSale(sale1);
//		dbhelper.insertSale(sale2);
//		dbhelper.insertSale(sale3);
//		dbhelper.insertSale(sale4);
//		dbhelper.insertSale(sale5);
        // 添加测试数据结束
    }

    public static void prtMainMenu() {
        System.out.println();
        System.out.println("****************商品进销存系统*****************");
        System.out.println("\t1-添加商品信息\t2-修改商品信息");
        System.out.println("\t3-查询商品信息\t4-新增供货商");
        System.out.println("\t5-修改供货商信息\t6-查询供货商信息");
        System.out.println("\t7-采购信息录入\t8-销售信息录入");
        System.out.println("\t9-库存查询\t0-打印销售报表");
        System.out.println("********************************************");
        System.out.println("请输入您要进行的操作,退出请输入q/Q：");
        System.out.println();
    }
}

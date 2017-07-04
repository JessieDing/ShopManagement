package ui;

import business.Goods;
import business.Provider;
import business.TransFactory;
import business.Transaction;
import database.DatabaseOperator;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class ShopManagementMain {

    public static void main(String[] args) throws ParseException {
        // 1.���ȴ�ӡ�˵�������
        // 2.�ͻ�ѡ���׺󣬽���������׶�Ӧ�Ĳ���/��ʾ����
        // 3.�ͻ��������󣬴ӽ����ȡ�ͻ����������
        // 4.ִ�иý��ף����Ҵ�ӡִ�н��
        Scanner scan = new Scanner(System.in);
        DatabaseOperator databaseOperator = new DatabaseOperator();// ���ݲ�������
//		initTestData(databaseOperator);
        databaseOperator.loadAllGoods();
        while (true) {
            printMainMenu(); // ��ӡ���˵�
            String strTrans = scan.next();// ��ȡ����
            if (strTrans.equalsIgnoreCase("q")) {
                break;
            }

            Transaction trans;
            TransFactory tFactory = new TransFactory();
            trans = tFactory.createTrans(strTrans);
            if (trans != null) {
                trans.setDatabaseOperator(databaseOperator);
                trans.printPrompt();// ��ӡ������ʾ��Ϣ
                if (trans.getInput() != 0) {// ��ȡ���������
                    trans.printResult();
                    System.out.println("��ȡ��������ʧ��");
                } else {
                    if (trans.process() != 0) {
                        trans.printResult();
                    } else {
                        trans.printResult();
                    }
                }
            } else {
                System.out.println("��������ʵ������");
            }
        }

        scan.close();
        System.out.println("ϵͳ�����˳�");
    }

    private static void initTestData(DatabaseOperator databaseOperator) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2016);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DATE, 30);

        // ��Ӳ�������
        Goods g1 = new Goods("00010001", "��ΪP8", "��", "0", 120);
        Goods g2 = new Goods("00020002", "��Ϊ��â", "��", "0", 120);
        Goods g3 = new Goods("00030003", "Iphone7", "��", "0", 120);
        Goods g4 = new Goods("00040004", "����2", "��", "0", 120);
        databaseOperator.insertGoods(g1);
        databaseOperator.insertGoods(g2);
        databaseOperator.insertGoods(g3);
        databaseOperator.insertGoods(g4);
        Provider p1 = new Provider("0001", "Ѹ��ͨѶ", "�츮����", "02811111111", "0");
        Provider p2 = new Provider("0002", "����ͨ", "�츮����", "02822222222", "0");
        Provider p3 = new Provider("0003", "����", "̫����·", "02833333333", "0");
        Provider p4 = new Provider("0004", "������", "�츮���", "02844444444", "0");
        databaseOperator.insertProvider(p1);
        databaseOperator.insertProvider(p2);
        databaseOperator.insertProvider(p3);
        databaseOperator.insertProvider(p4);
        // �ɹ� ��������
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Purchase purchase1 = new Purchase("00010001", "��ΪP8", 8, "��", 2000, dateFormat.parse("2017-03-13"), "����ͨ");
//		Purchase purchase2 = new Purchase("00020002", "��Ϊ��â", 6, "��", 1765.5, dateFormat.parse("2017-03-16"), "Ѹ��");
//		Purchase purchase3 = new Purchase("00030003", "Iphone7", 10, "��", 4890.5, dateFormat.parse("2017-03-12"), "����");
//		Purchase purchase4 = new Purchase("00040004", "����2", 10, "��", 275.5, dateFormat.parse("2017-03-15"), "������");
//		dbhelper.insertPurchase(purchase1);
//		dbhelper.insertPurchase(purchase2);
//		dbhelper.insertPurchase(purchase3);
//		dbhelper.insertPurchase(purchase4);
        // ���� ��������
//		Sale sale1 = new Sale("00010001", "��ΪP8", 6, 3000, dateFormat.parse("2017-03-16"));
//		Sale sale2 = new Sale("00030003", "Iphone7", 3, 7299, dateFormat.parse("2017-03-16"));
//		Sale sale3 = new Sale("00020002", "��Ϊ��â", 5, 2699, dateFormat.parse("2017-03-16"));
//		Sale sale4 = new Sale("00040004", "����2", 8, 599, dateFormat.parse("2017-03-16"));
//		Sale sale5 = new Sale("00030003", "Iphone7", 5, 6999, dateFormat.parse("2017-03-13"));
//		dbhelper.insertSale(sale1);
//		dbhelper.insertSale(sale2);
//		dbhelper.insertSale(sale3);
//		dbhelper.insertSale(sale4);
//		dbhelper.insertSale(sale5);
        // ��Ӳ������ݽ���
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("****************��Ʒ������ϵͳ*****************");
        System.out.println("\t1-�����Ʒ��Ϣ\t2-�޸���Ʒ��Ϣ");
        System.out.println("\t3-��ѯ��Ʒ��Ϣ\t4-����������");
        System.out.println("\t5-�޸Ĺ�������Ϣ\t6-��ѯ��������Ϣ");
        System.out.println("\t7-�ɹ���Ϣ¼��\t8-������Ϣ¼��");
        System.out.println("\t9-����ѯ\t0-��ӡ���۱���");
        System.out.println("********************************************");
        System.out.println("��������Ҫ���еĲ���,�˳�������q/Q��");
        System.out.println();
    }
}

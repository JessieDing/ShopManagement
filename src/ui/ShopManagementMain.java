package ui;

import java.util.Scanner;

import busi.TransFactory;
import busi.TransInterface;
import db.DBOper;

public class ShopManagementMain {

	public static void main(String[] args) {
		// 1.���ȴ�ӡ�˵�������
		// 2.�ͻ�ѡ���׺󣬽���������׶�Ӧ�Ĳ���/��ʾ����
		// 3.�ͻ��������󣬴ӽ����ȡ�ͻ����������
		// 4.ִ�иý��ף����Ҵ�ӡִ�н��
		Scanner scan = new Scanner(System.in);

		DBOper dbhelper = new DBOper();// ���ݲ�������

		while (true) {
			prtMainMenu(); // ��ӡ���˵�

			String strTrans = scan.next();// ��ȡ����
			if (strTrans.equalsIgnoreCase("q")) {
				break;
			}

			TransInterface trans = null;
			TransFactory tFactory = new TransFactory();
			trans = tFactory.createTrans(strTrans);
			if (trans != null) {
				trans.setDbhelper(dbhelper);
				trans.prtPrompt();// ��ӡ������ʾ��Ϣ
				if (trans.getInput() != 0) {// ��ȡ���������
					System.out.println("��ȡ��������ʧ��");
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
				System.out.println("��������ʵ������");
			}
		}

		scan.close();
		System.out.println("ϵͳ�����˳�");
	}

	public static void prtMainMenu() {
		System.out.println();
		System.out.println("****************��Ʒ������ϵͳ*****************");
		System.out.println("\t1-�����Ʒ��Ϣ\t2-�޸���Ʒ��Ϣ");
		System.out.println("\t3-��ѯ��Ʒ��Ϣ\t4-����������");
		System.out.println("\t5-�޸Ĺ�������Ϣ\t6-��ѯ��������Ϣ");
		System.out.println("\t7-�ɹ���Ϣ¼��\t8-������Ϣ¼��");
		System.out.println("********************************************");
		System.out.println("��������Ҫ���еĲ���,�˳�������q/Q��");
		System.out.println();
	}
}

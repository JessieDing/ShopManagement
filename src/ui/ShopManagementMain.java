package ui;

import java.util.Scanner;

import busi.TransAddGoods;

public class ShopManagementMain {

	public static void main(String[] args) {
		// 1.���ȴ�ӡ�˵�������
		// 2.�ͻ�ѡ���׺󣬽���������׶�Ӧ�Ĳ���/��ʾ����
		// 3.�ͻ��������󣬴ӽ����ȡ�ͻ����������
		// 4.ִ�иý��ף����Ҵ�ӡִ�н��
		prtMainMenu(); // ��ӡ���˵�
		Scanner scan = new Scanner(System.in);
		String strTrans = scan.next();
		if (strTrans.equals("1")) {// �����Ʒ��Ϣ����
			TransAddGoods addGoods = new TransAddGoods();
			addGoods.prtPrompt();// ��ӡ������ʾ��Ϣ
			if (addGoods.getInput() != 0) {
				System.out.println("��ȡ��������ʧ��");
			} else {
				if (addGoods.doTrans() != 0) {
					System.out.println(addGoods.getTrans_result());
				} else {
					System.out.println(addGoods.getTrans_result());
				}
			}
		}
		scan.close();
	}

	public static void prtMainMenu() {
		System.out.println("****************��Ʒ������ϵͳ*****************");
		System.out.println("\t1-�����Ʒ��Ϣ\t2-�޸���Ʒ��Ϣ");
		System.out.println("\t3-��ѯ��Ʒ��Ϣ\t4-����������");
		System.out.println("\t5-�޸Ĺ�������Ϣ\t6-��ѯ��������Ϣ");
		System.out.println("\t7-�ɹ���Ϣ¼��\t8-������Ϣ¼��");
		System.out.println("********************************************");
		System.out.println("��������Ҫ���еĲ�����");
	}
}

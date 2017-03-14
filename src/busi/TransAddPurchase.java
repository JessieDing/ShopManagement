package busi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransAddPurchase extends TransAbs {
	String goods_no;// ��Ʒ���
	String goods_name;// ��Ʒ����
	String goods_unit;// ��Ʒ��λ
	int goods_count;// �ɹ�����
	double goods_price;// �����۸�
	Date purchase_date;// ��������
	String prvd;// ������

	// public void addInventory(Purchase p) {
	// Inventory inventory = new Inventory(p);
	// dbhelper.insertInventory(inventory);
	// }

	public int findGoodsInfo(String no) {
		Goods goods = dbhelper.exactFindGoods(no);
		if (goods == null) {
			setTrans_result("�Ҳ�������Ʒ��ţ�");
			return -1;
		} else {
			System.out.println("����Ʒ��Ϣ���£�");
			System.out.print("goods_no[" + goods.getGoods_no() + "],");
			System.out.print("goods_name[" + goods.getGoods_name() + "],");
			System.out.print("goods_unit[" + goods.getGoods_unit() + "]");
			System.out.println();
			return 0;
		}
	}

	public void prtPrompt() {
		System.out.println("������Ʒ��ţ�");
		goods_no = scan.nextLine();
		if (findGoodsInfo(goods_no) == 0) {
			System.out.println("�ɹ�¼��|������������Ϣ��");
			System.out.println(
					"@goods_no @goods_name @goods_count @goods_unit @goods_price @purchase_date(yyyy-mm-dd) @prvd");
		}
	}

	public int getInput() {

		// ��ȡ��Ʒ���
		goods_no = scan.next();
		if (goods_no == null) {
			setTrans_result("��ȡ��Ʒ��Ŵ���");
			return -1;
		}

		// ��ȡ��Ʒ����
		goods_name = scan.next();
		if (goods_name == null) {
			setTrans_result("��ȡ��Ʒ���ƴ���");
			return -1;
		}

		// ��ȡ�ɹ�����
		String count = scan.next();
		goods_count = Integer.parseInt(count);
		if (goods_count == 0) {
			setTrans_result("��ȡ�ɹ�����ʧ��");
			return -1;
		}

		// ��ȡ��Ʒ��λ
		goods_unit = scan.next();
		if (goods_unit == null) {
			setTrans_result("��ȡ��Ʒ��λ����");
			return -1;
		}

		// ��ȡ�����۸�
		String price = scan.next();
		goods_price = Double.parseDouble(price);
		if (goods_price == 0) {
			setTrans_result("��ȡ�����۸�ʧ��");
			return -1;
		}

		// ��ȡ����
		if (scan.hasNext()) {
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			try {
				purchase_date = date.parse(scan.next());
			} catch (Exception e) {
			}
		} else {
			System.out.println("��������ڸ�ʽ����");
			return -1;
		}

		// ��ȡ������
		prvd = scan.next();
		if (prvd == null) {
			setTrans_result("��ȡ������ʧ��");
			return -1;
		}

		return 0;
	}

	public int doTrans() {
		Purchase purchase = new Purchase();
		purchase.setGoods_no(goods_no);
		purchase.setGoods_name(goods_name);
		purchase.setPurchase_amt(goods_count);
		purchase.setGoods_unit(goods_unit);
		purchase.setPurchase_price(goods_price);
		purchase.setPurchase_date(purchase_date);
		purchase.setPrvd(prvd);
		// addInventory(purchase);// ��ӿ��(�ɹ�֮����п��) ��TransEditInventory���޸�����
		if (getDbhelper().insertPurchase(purchase) == 0) {
			dbhelper.prtAllPurchase();
			setTrans_result("�ɹ���Ϣ¼��ɹ�");
			return 0;
		} else {
			setTrans_result("�ɹ���Ϣ¼��ʧ��");
			return -1;
		}
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

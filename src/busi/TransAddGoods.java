package busi;

public class TransAddGoods extends TransAbs {
	String goods_no;// ��Ʒ���
	String goods_name;// ��Ʒ����
	String goods_unit;// ��λ

	public void prtPrompt() {
		System.out.println("�����Ʒ|������������Ϣ��");
		System.out.println("@goods_no @goods_name @goods_unit");
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

		// ��ȡ��Ʒ��λ
		goods_unit = scan.next();
		if (goods_unit == null) {
			setTrans_result("��ȡ��Ʒ��λ����");
			return -1;
		}

		// �ж���Ʒ����Ƿ��ظ�
		if (dbhelper.exactFindGoods(goods_no) != null) {
			setTrans_result("��Ʒ����Ѵ���");
			return -1;
		}

		DataValidate validator = new DataValidate();
		if (!validator.goodNoValidate(goods_no)) {
			setTrans_result("��Ʒ��Ų��Ϸ�");
			return -1;
		}

		System.out.print("goods_no[" + goods_no + "],");
		System.out.print("goods_name[" + goods_name + "],");
		System.out.print("goods_unit[" + goods_unit + "]");
		System.out.println();
		return 0;
	}

	public int doTrans() {
		Goods g = new Goods();
		g.setGoods_no(goods_no);// ���û��������Ʒ��Ÿ�ֵ��Goods����
		g.setGoods_name(goods_name);// ��ֵ��Ʒ����
		g.setGoods_unit(goods_unit);// ��ֵ��Ʒ��λ
		g.setGoods_status("0");// ������Ʒ��Ĭ��״̬Ϊ0��Ч
		if (getDbhelper().insertGoods(g) == 0) {
			setTrans_result("������Ʒ�ɹ�");
			return 0;
		} else {
			setTrans_result("������Ʒʧ��");
			return -1;
		}
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

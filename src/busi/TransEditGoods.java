package busi;

public class TransEditGoods extends TransAbs {
	String goods_no;// ��Ʒ���
	String goods_name;// ��Ʒ����
	String goods_unit;// ��Ʒ��λ
	String goods_status;// ��Ʒ״̬

	public TransEditGoods() {
		super();
	}

	public TransEditGoods(String goods_no, String goods_name, String goods_unit, String goods_status) {
		super();
		this.goods_no = goods_no;
		this.goods_name = goods_name;
		this.goods_unit = goods_unit;
		this.goods_status = goods_status;
	}

	public void prtPrompt() {
		System.out.println("��Ʒ��Ϣ�޸�|������������Ʒ��ź��޸ĺ����Ʒ��Ϣ��");
		System.out.println("@goods_no @goods_name @goods_unit @goods_status");

	}

	public int getInput() {
		// ��Ʒ���
		goods_no = scan.next();
		if (goods_no == null) {
			setTrans_result("��ȡ��Ʒ��Ŵ���");
			return -1;
		}

		// ��Ʒ����
		goods_name = scan.next();
		if (goods_name == null) {
			setTrans_result("��ȡ��Ʒ���ƴ���");
			return -1;
		}

		// ��Ʒ��λ
		goods_unit = scan.next();
		if (goods_unit == null) {
			setTrans_result("��ȡ��Ʒ��λ����");
			return -1;
		}

		// ��Ʒ״̬
		goods_status = scan.next();
		if (goods_status == null) {
			setTrans_result("��ȡ��Ʒ״̬����");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		Goods goods = dbhelper.exactFindGoods(goods_no);
		goods.setGoods_name(goods_name);
		goods.setGoods_unit(goods_unit);
		goods.setGoods_status(goods_status);
		setTrans_result("�޸ĳɹ�");

		return 0;
	}

	public void prtResult() {
		System.out.println(trans_result);
	}

}

package busi;

public class TransFactory {

	public TransInterface createTrans(String strTrans) {
		TransInterface trans = null;

		if (strTrans.equals("1")) {// �����Ʒ��Ϣ����
			trans = new TransAddGoods();
		} else if (strTrans.equals("2")) {// ��ѯ��Ʒ
			trans = new TransEditGoods();
		} else if (strTrans.equals("3")) {// ��ѯ��Ʒ
			trans = new TransQueryGoods();
		} else if (strTrans.equals("4")) {// ��ѯ��Ʒ
			trans = new TransAddPrvd();
		}
		return trans;
	}
}

package business;

import java.util.List;

public class TransQueryGoods extends TransAbs {
	String query_type;// ��ѯ��ʽ
	String goods_no;// ��Ʒ���
	String goods_name;// ��Ʒ����

	public TransQueryGoods() {
		super();
	}

	public TransQueryGoods(String query_type, String goods_no, String goods_name) {
		super();
		this.query_type = query_type;
		this.goods_no = goods_no;
		this.goods_name = goods_name;
	}

	public void printPrompt() {
		System.out.println("��ѯ��Ʒ|������������Ϣ��");
		System.out.println("@query_type @goods_no @goods_name");
		System.out.println("query_type��0-ȫ����ѯ  1-��ȷ��ѯ   2-ģ����ѯ");
	}

	public int getInput() {
		// ��ȡ��ѯ��ʽ
		query_type = scan.next();
		if (query_type == null) {
			setTransResult("��ȡ��ѯ��ʽʧ��");
			return -1;
		} else if (query_type.equals("0")) {// ȫ����ѯ����Ҫ��ȡʣ��Ĳ���
			return 0;
		}

		// ��Ʒ���
		goods_no = scan.next();
		if (goods_no == null) {
			setTransResult("��ȡ��Ʒ��Ŵ���");
			return -1;
		}

		// ��Ʒ����
		goods_name = scan.next();
		if (goods_name == null) {
			setTransResult("��ȡ��Ʒ���ƴ���");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		if (query_type.equals("0")) {// ȫ����ѯ
			getDbhelper().printAllGoods();
			setTransResult("��ѯ���");
			return 0;
		} else if (query_type.equals("1")) {// ��ȷ��ѯ
			Goods goods = dbhelper.exactFindGoods(goods_no);
			if (goods != null) {
				System.out.println(goods.toString());
				setTransResult("��ȷ��ѯ���");
				return 0;
			} else {
				setTransResult("û�в鵽�����Ϣ��");
				return -1;
			}
		} else if (query_type.equals("2")) {// ģ����ѯ��Ŀǰֻ�ܲ�һ����

			if (dbhelper.fuzFindGoods(goods_name) != null) {
				List<Goods> list = dbhelper.fuzFindGoods(goods_name);
				for (Goods g : list) {
					System.out.println(g.toString());
				}
				return 0;
			} else {
				setTransResult("û�в鵽�����Ϣ��");
				return -1;
			}

		}
		return 0;
	}

	public void printResult() {
		System.out.println(transResult);
	}

	public String getQuery_type() {
		return query_type;
	}

	public void setQuery_type(String query_type) {
		this.query_type = query_type;
	}

	public String getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

}

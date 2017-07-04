package business;

import java.util.List;

class TransQueryGoods extends TransAbs {
	private String queryType;// ��ѯ��ʽ
	private String goodsNumber;// ��Ʒ���
	private String goodsName;// ��Ʒ����

	TransQueryGoods() {
		super();
	}

	public void printPrompt() {
		System.out.println("��ѯ��Ʒ|������������Ϣ��");
		System.out.println("@queryType @goodsNumber @goodsName");
		System.out.println("queryType��0-ȫ����ѯ  1-��ȷ��ѯ   2-ģ����ѯ");
	}

	public int getInput() {
		// ��ȡ��ѯ��ʽ
		queryType = scan.next();
		if (queryType == null) {
			setTransResult("��ȡ��ѯ��ʽʧ��");
			return -1;
		} else if (queryType.equals("0")) {// ȫ����ѯ����Ҫ��ȡʣ��Ĳ���
			return 0;
		}

		// ��Ʒ���
		goodsNumber = scan.next();
		if (goodsNumber == null) {
			setTransResult("��ȡ��Ʒ��Ŵ���");
			return -1;
		}

		// ��Ʒ����
		goodsName = scan.next();
		if (goodsName == null) {
			setTransResult("��ȡ��Ʒ���ƴ���");
			return -1;
		}
		return 0;
	}

	public int process() {
		switch (queryType) {
			case "0": // ȫ����ѯ
				getDatabaseOperator().printAllGoods();
				setTransResult("��ѯ���");
				return 0;
			case "1": // ��ȷ��ѯ
				Goods goods = databaseOperator.exactFindGoods(goodsNumber);
				if (goods != null) {
					System.out.println(goods.toString());
					setTransResult("��ȷ��ѯ���");
					return 0;
				} else {
					setTransResult("û�в鵽�����Ϣ��");
					return -1;
				}
			case "2": // ģ����ѯ��Ŀǰֻ�ܲ�һ����

				if (databaseOperator.fuzFindGoods(goodsName) != null) {
					List<Goods> list = databaseOperator.fuzFindGoods(goodsName);
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

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}

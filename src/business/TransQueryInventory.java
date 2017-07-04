package business;

import java.util.List;

class TransQueryInventory extends AbstractTransaction {
	private String queryType;
	private String goodsNumber;// ��Ʒ���
	private String goodsName;// ��Ʒ����

	public void printPrompt() {
		System.out.println("��ѯ��Ʒ|������������Ϣ��");
		System.out.println("@queryType @goodsNumber @goodsName");
		System.out.println("queryType��0-ȫ����ѯ  1-��ȷ��ѯ   2-ģ����ѯ");
	}

	public int getInput() {
		// ��ȡ��ѯ��ʽ
		queryType = scan.next();
		if (queryType == null) {
			setTransactionResult("��ȡ��ѯ��ʽʧ��");
			return -1;
		} else if (queryType.equals("0")) {// ȫ����ѯ����Ҫ��ȡʣ��Ĳ���
			return 0;
		}

		// ��Ʒ���
		goodsNumber = scan.next();
		if (goodsNumber == null) {
			setTransactionResult("��ȡ��Ʒ��Ŵ���");
			return -1;
		}

		// ��Ʒ����
		goodsName = scan.next();
		if (goodsName == null) {
			setTransactionResult("��ȡ��Ʒ���ƴ���");
			return -1;
		}
		return 0;
	}

	public int process() {
		switch (queryType) {
			case "0": // ȫ����ѯ
				getDatabaseOperator().printAllInventory();
				setTransactionResult("��ѯ���");
				return 0;
			case "1": // ��ȷ��ѯ
				Inventory inventory = databaseOperator.exactFindInventory(goodsNumber);
				if (inventory != null) {
					System.out.println(inventory.toString());
					setTransactionResult("��ȷ��ѯ���");
					return 0;
				} else {
					setTransactionResult("û�в鵽�����Ϣ��");
					return -1;
				}
			case "2": // ģ����ѯ

				if (databaseOperator.fuzFindInventory(goodsName) != null) {
					List<Inventory> list = databaseOperator.fuzFindInventory(goodsName);
					for (Inventory i : list) {
						System.out.println(i.toString());
					}
					setTransactionResult("ģ����ѯ���");
					return 0;
				} else {
					setTransactionResult("û�в鵽�����Ϣ��");
					return -1;
				}
		}
		return 0;
	}

	public void printResult() {
		System.out.println(transactionResult);
	}
}

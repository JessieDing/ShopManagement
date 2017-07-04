package business;

import java.util.List;

class TransQueryInventory extends AbstractTransaction {
	private String queryType;
	private String goodsNumber;// 商品编号
	private String goodsName;// 商品名称

	public void printPrompt() {
		System.out.println("查询商品|请输入以下信息：");
		System.out.println("@queryType @goodsNumber @goodsName");
		System.out.println("queryType：0-全部查询  1-精确查询   2-模糊查询");
	}

	public int getInput() {
		// 读取查询方式
		queryType = scan.next();
		if (queryType == null) {
			setTransactionResult("获取查询方式失败");
			return -1;
		} else if (queryType.equals("0")) {// 全部查询不需要读取剩余的参数
			return 0;
		}

		// 商品编号
		goodsNumber = scan.next();
		if (goodsNumber == null) {
			setTransactionResult("读取商品编号错误");
			return -1;
		}

		// 商品名称
		goodsName = scan.next();
		if (goodsName == null) {
			setTransactionResult("读取商品名称错误");
			return -1;
		}
		return 0;
	}

	public int process() {
		switch (queryType) {
			case "0": // 全部查询
				getDatabaseOperator().printAllInventory();
				setTransactionResult("查询完成");
				return 0;
			case "1": // 精确查询
				Inventory inventory = databaseOperator.exactFindInventory(goodsNumber);
				if (inventory != null) {
					System.out.println(inventory.toString());
					setTransactionResult("精确查询完成");
					return 0;
				} else {
					setTransactionResult("没有查到相关信息！");
					return -1;
				}
			case "2": // 模糊查询

				if (databaseOperator.fuzFindInventory(goodsName) != null) {
					List<Inventory> list = databaseOperator.fuzFindInventory(goodsName);
					for (Inventory i : list) {
						System.out.println(i.toString());
					}
					setTransactionResult("模糊查询完成");
					return 0;
				} else {
					setTransactionResult("没有查到相关信息！");
					return -1;
				}
		}
		return 0;
	}

	public void printResult() {
		System.out.println(transactionResult);
	}
}

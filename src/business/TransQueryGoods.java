package business;

import java.util.List;

class TransQueryGoods extends TransAbs {
	private String queryType;// 查询方式
	private String goodsNumber;// 商品编号
	private String goodsName;// 商品名称

	TransQueryGoods() {
		super();
	}

	public void printPrompt() {
		System.out.println("查询商品|请输入以下信息：");
		System.out.println("@queryType @goodsNumber @goodsName");
		System.out.println("queryType：0-全部查询  1-精确查询   2-模糊查询");
	}

	public int getInput() {
		// 读取查询方式
		queryType = scan.next();
		if (queryType == null) {
			setTransResult("获取查询方式失败");
			return -1;
		} else if (queryType.equals("0")) {// 全部查询不需要读取剩余的参数
			return 0;
		}

		// 商品编号
		goodsNumber = scan.next();
		if (goodsNumber == null) {
			setTransResult("读取商品编号错误");
			return -1;
		}

		// 商品名称
		goodsName = scan.next();
		if (goodsName == null) {
			setTransResult("读取商品名称错误");
			return -1;
		}
		return 0;
	}

	public int process() {
		switch (queryType) {
			case "0": // 全部查询
				getDatabaseOperator().printAllGoods();
				setTransResult("查询完成");
				return 0;
			case "1": // 精确查询
				Goods goods = databaseOperator.exactFindGoods(goodsNumber);
				if (goods != null) {
					System.out.println(goods.toString());
					setTransResult("精确查询完成");
					return 0;
				} else {
					setTransResult("没有查到相关信息！");
					return -1;
				}
			case "2": // 模糊查询（目前只能查一个）

				if (databaseOperator.fuzFindGoods(goodsName) != null) {
					List<Goods> list = databaseOperator.fuzFindGoods(goodsName);
					for (Goods g : list) {
						System.out.println(g.toString());
					}
					return 0;
				} else {
					setTransResult("没有查到相关信息！");
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

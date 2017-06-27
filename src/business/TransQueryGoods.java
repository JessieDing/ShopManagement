package business;

import java.util.List;

public class TransQueryGoods extends TransAbs {
	String query_type;// 查询方式
	String goods_no;// 商品编号
	String goods_name;// 商品名称

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
		System.out.println("查询商品|请输入以下信息：");
		System.out.println("@query_type @goods_no @goods_name");
		System.out.println("query_type：0-全部查询  1-精确查询   2-模糊查询");
	}

	public int getInput() {
		// 读取查询方式
		query_type = scan.next();
		if (query_type == null) {
			setTransResult("获取查询方式失败");
			return -1;
		} else if (query_type.equals("0")) {// 全部查询不需要读取剩余的参数
			return 0;
		}

		// 商品编号
		goods_no = scan.next();
		if (goods_no == null) {
			setTransResult("读取商品编号错误");
			return -1;
		}

		// 商品名称
		goods_name = scan.next();
		if (goods_name == null) {
			setTransResult("读取商品名称错误");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		if (query_type.equals("0")) {// 全部查询
			getDbhelper().printAllGoods();
			setTransResult("查询完成");
			return 0;
		} else if (query_type.equals("1")) {// 精确查询
			Goods goods = dbhelper.exactFindGoods(goods_no);
			if (goods != null) {
				System.out.println(goods.toString());
				setTransResult("精确查询完成");
				return 0;
			} else {
				setTransResult("没有查到相关信息！");
				return -1;
			}
		} else if (query_type.equals("2")) {// 模糊查询（目前只能查一个）

			if (dbhelper.fuzFindGoods(goods_name) != null) {
				List<Goods> list = dbhelper.fuzFindGoods(goods_name);
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

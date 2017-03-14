package busi;

import java.util.List;

public class TransQueryInventory extends TransAbs {
	String query_type;
	String goods_no;// 商品编号
	String goods_name;// 商品名称

	public void prtPrompt() {
		System.out.println("查询商品|请输入以下信息：");
		System.out.println("@query_type @goods_no @goods_name");
		System.out.println("query_type：0-全部查询  1-精确查询   2-模糊查询");
	}

	public int getInput() {
		// 读取查询方式
		query_type = scan.next();
		if (query_type == null) {
			setTrans_result("获取查询方式失败");
			return -1;
		} else if (query_type.equals("0")) {// 全部查询不需要读取剩余的参数
			return 0;
		}

		// 商品编号
		goods_no = scan.next();
		if (goods_no == null) {
			setTrans_result("读取商品编号错误");
			return -1;
		}

		// 商品名称
		goods_name = scan.next();
		if (goods_name == null) {
			setTrans_result("读取商品名称错误");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		if (query_type.equals("0")) {// 全部查询
			getDbhelper().prtAllInventory();
			setTrans_result("查询完成");
			return 0;
		} else if (query_type.equals("1")) {// 精确查询
			Inventory inventory = dbhelper.exactFindInventory(goods_no);
			if (inventory != null) {
				System.out.println(inventory.toString());
				setTrans_result("精确查询完成");
				return 0;
			} else {
				setTrans_result("没有查到相关信息！");
				return -1;
			}
		} else if (query_type.equals("2")) {// 模糊查询

			if (dbhelper.fuzFindInventory(goods_name) != null) {
				List<Inventory> list = dbhelper.fuzFindInventory(goods_name);
				for (Inventory i : list) {
					System.out.println(i.toString());
				}
				setTrans_result("模糊查询完成");
				return 0;
			} else {
				setTrans_result("没有查到相关信息！");
				return -1;
			}

		}
		return 0;
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

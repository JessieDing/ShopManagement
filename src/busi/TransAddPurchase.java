package busi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransAddPurchase extends TransAbs {
	String goods_no;// 商品编号
	String goods_name;// 商品名称
	String goods_unit;// 商品单位
	int goods_count;// 采购数量
	double goods_price;// 进货价格
	Date purchase_date;// 进货日期
	String prvd;// 供货商

	// public void addInventory(Purchase p) {
	// Inventory inventory = new Inventory(p);
	// dbhelper.insertInventory(inventory);
	// }

	public int findGoodsInfo(String no) {
		Goods goods = dbhelper.exactFindGoods(no);
		if (goods == null) {
			setTrans_result("找不到该商品编号！");
			return -1;
		} else {
			System.out.println("该商品信息如下：");
			System.out.print("goods_no[" + goods.getGoods_no() + "],");
			System.out.print("goods_name[" + goods.getGoods_name() + "],");
			System.out.print("goods_unit[" + goods.getGoods_unit() + "]");
			System.out.println();
			return 0;
		}
	}

	public void prtPrompt() {
		System.out.println("输入商品编号：");
		goods_no = scan.nextLine();
		if (findGoodsInfo(goods_no) == 0) {
			System.out.println("采购录入|请输入以下信息：");
			System.out.println(
					"@goods_no @goods_name @goods_count @goods_unit @goods_price @purchase_date(yyyy-mm-dd) @prvd");
		}
	}

	public int getInput() {

		// 读取商品编号
		goods_no = scan.next();
		if (goods_no == null) {
			setTrans_result("获取商品编号错误");
			return -1;
		}

		// 读取商品名称
		goods_name = scan.next();
		if (goods_name == null) {
			setTrans_result("获取商品名称错误");
			return -1;
		}

		// 读取采购数量
		String count = scan.next();
		goods_count = Integer.parseInt(count);
		if (goods_count == 0) {
			setTrans_result("获取采购数量失败");
			return -1;
		}

		// 读取商品单位
		goods_unit = scan.next();
		if (goods_unit == null) {
			setTrans_result("获取商品单位错误");
			return -1;
		}

		// 读取进货价格
		String price = scan.next();
		goods_price = Double.parseDouble(price);
		if (goods_price == 0) {
			setTrans_result("获取进货价格失败");
			return -1;
		}

		// 读取日期
		if (scan.hasNext()) {
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			try {
				purchase_date = date.parse(scan.next());
			} catch (Exception e) {
			}
		} else {
			System.out.println("输入的日期格式错误！");
			return -1;
		}

		// 读取供货商
		prvd = scan.next();
		if (prvd == null) {
			setTrans_result("获取供货商失败");
			return -1;
		}

		return 0;
	}

	public int doTrans() {
		Purchase purchase = new Purchase();
		purchase.setGoods_no(goods_no);
		purchase.setGoods_name(goods_name);
		purchase.setPurchase_amt(goods_count);
		purchase.setGoods_unit(goods_unit);
		purchase.setPurchase_price(goods_price);
		purchase.setPurchase_date(purchase_date);
		purchase.setPrvd(prvd);
		// addInventory(purchase);// 添加库存(采购之后才有库存) 在TransEditInventory中修改数量
		if (getDbhelper().insertPurchase(purchase) == 0) {
			dbhelper.prtAllPurchase();
			setTrans_result("采购信息录入成功");
			return 0;
		} else {
			setTrans_result("采购信息录入失败");
			return -1;
		}
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

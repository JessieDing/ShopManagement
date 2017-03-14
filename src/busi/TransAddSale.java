package busi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransAddSale extends TransAbs {
	String goods_no;// 商品编号
	String goods_name;// 商品名称
	int sale_count;// 销售数量
	String goods_unit;
	double sale_price;// 销售价格
	Date sale_date;// 销售日期
	SalesReport salesReport;

	// public void deleteInventory(Sale sale) {//删除库存
	// Inventory inventory = dbhelper.exactFindInventory(sale.getGoods_no());
	// List inventoryList = dbhelper.getInventory_list();
	// inventoryList.remove(inventory);
	// }

	public int findGoodsInfo(String no) {
		Inventory inventory = dbhelper.exactFindInventory(no);
		if (inventory == null) {
			setTrans_result("库存记录中找不到该商品编号！");
			return -1;
		} else {
			System.out.println("该商品信息如下：");
			System.out.println("goods_no[" + inventory.getGoods_no() + "],");
			System.out.println("goods_name[" + inventory.getGoods_name() + "],");
			System.out.println("Goods_count[" + inventory.getGoods_count() + "]");

		}

		return 0;
	}

	public void prtPrompt() {
		System.out.println("输入商品编号：");
		goods_no = scan.next();
		if (findGoodsInfo(goods_no) == 0) {
			System.out.println("销售录入|请输入以下信息：");
			System.out.println("@goods_no @goods_name @sale_count @goods_unit @sale_price @sale_date(yyyy-mm-dd)");
		}
	}

	public int getInput() {

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

		// 读取销售数量
		String count = scan.next();
		sale_count = Integer.parseInt(count);
		Inventory inventory = dbhelper.exactFindInventory(goods_no);
		if (sale_count > inventory.getGoods_count()) {
			setTrans_result("库存不足！");
			return -1;
		}

		goods_unit = scan.next();
		if (goods_unit == null) {
			setTrans_result("获取商品单位错误");
			return -1;
		}

		sale_price = Double.parseDouble(scan.next());
		if (sale_price < inventory.getGoods_price()) {
			setTrans_result("输入错误，售价小于进价！");
			return -1;
		}

		if (scan.hasNext()) {
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sale_date = date.parse(scan.next());
			} catch (Exception e) {
			}
			if (sale_date.before(inventory.getPurchase_date())) {
				System.out.println("输入错误，销售时间早于进货时间！");
				return -1;
			}
		} else {
			System.out.println("输入的日期格式错误！");
			return -1;
		}

		return 0;
	}

	public int doTrans() {

		Sale sale = new Sale();
		sale.setGoods_no(goods_no);
		sale.setGoods_name(goods_name);
		sale.setPrice(sale_price);
		sale.setSale_amt(sale_count);
		sale.setSale_date(sale_date);
		// deleteInventory(sale);//从库存中删除
		if (getDbhelper().insertSale(sale) == 0) {
			getDbhelper().prtAllSale();
			setTrans_result("销售信息录入成功");
			return 0;
		} else {
			setTrans_result("销售信息录入失败");
			return -1;
		}

	}

	public void prtResult() {
		System.out.println(trans_result);
	}

}

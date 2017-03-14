package busi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
	String goods_no;// 商品编号
	String goods_name;// 商品名称
	int goods_count = 0;// 商品数量
	String goods_unit;// 商品单位
	double goods_price;// 进货价格
	Date purchase_date;// 进货日期

	public Inventory() {
		super();

	}

	public Inventory(Purchase p) {
		super();
		this.goods_no = p.getGoods_no();
		this.goods_name = p.getGoods_name();
		this.goods_count = p.getPurchase_amt();
		this.goods_unit = p.getGoods_unit();
		this.goods_price = p.getPurchase_price();
		this.purchase_date = p.getPurchase_date();
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

	public int getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}

	public String getGoods_unit() {
		return goods_unit;
	}

	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	@Override
	public String toString() {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String purchaseDate = date.format(purchase_date);
		return "Inventory [goods_no=" + goods_no + ", goods_name=" + goods_name + ", goods_count=" + goods_count
				+ ", goods_unit=" + goods_unit + ", goods_price=" + goods_price + ", purchase_date=" + purchaseDate
				+ "]";
	}

}

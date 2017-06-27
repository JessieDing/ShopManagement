package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale {
	private String goodsNumber;// 商品编号
	private String goodsName;// 商品名称
	private int saleAmount;// 销售数量
	private double price;// 销售价格
	private Date saleDate;// 销售日期

	public Sale() {
		super();
	}

	public Sale(String goodsNumber, String goodsName, int saleAmount, double price, Date saleDate) {
		this.goodsNumber = goodsNumber;
		this.goodsName = goodsName;
		this.saleAmount = saleAmount;
		this.price = price;
		this.saleDate = saleDate;
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

	public int getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Override
	public String toString() {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String saleDate = date.format(this.saleDate);
		return "Sale [goodsNumber=" + goodsNumber + ", goodsName=" + goodsName + ", saleAmount=" + saleAmount + ", price="
				+ price + ", saleDate=" + saleDate + "]";
	}
}

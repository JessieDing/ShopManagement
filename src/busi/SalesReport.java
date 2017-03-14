package busi;

public class SalesReport {

	String goodsNo;
	String goodsName;
	double purchasePrice;
	double salePrice;
	int saleAmount;
	double profits;

	public SalesReport() {
		super();
	}

	public SalesReport(String goodsNo, String goodsName, int purchasePrice, int salePrice, int saleAmount,
			double profits) {
		super();
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.saleAmount = saleAmount;
		this.profits = profits;
	}

	public double calcProfits(double purchasePrice, double salePrice) {
		double profits = 0.00;
		profits = salePrice - purchasePrice;
		return profits;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}

	public double getProfits() {
		return profits;
	}

	public void setProfits(double profits) {
		this.profits = profits;
	}

	@Override
	public String toString() {
		return "SalesRow [goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", purchasePrice=" + purchasePrice
				+ ", salePrice=" + salePrice + ", saleAmount=" + saleAmount + ", profits=" + profits + "]";
	}

}
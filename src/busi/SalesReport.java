package busi;

public class SalesReport {
    private String goodsNumber;
    private String goodsName;
    private double purchasePrice;
    private double salePrice;
    private int saleAmount;
    private double profits;

    public SalesReport() {
        super();
    }

    public SalesReport(String goodsNumber, String goodsName, int purchasePrice, int salePrice, int saleAmount,
                       double profits) {
        super();
        this.goodsNumber = goodsNumber;
        this.goodsName = goodsName;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.saleAmount = saleAmount;
        this.profits = profits;
    }

    public double calcTotalAmount() {
        double totalAmount = 0.00;
        totalAmount = salePrice * saleAmount;
        return totalAmount;
    }

    public double calcProfits() {
        double profits = 0.00;
        profits = (salePrice - purchasePrice) * (double) saleAmount;
        return profits;
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

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
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
        return "  " + goodsNumber + "\t" + goodsName + "\t " + purchasePrice + "\t " + salePrice + "\t   " + saleAmount
                + "\t " + profits + "";
    }
}

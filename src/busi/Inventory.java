package busi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private int goodsCount = 0;// 商品数量
    private String goodsUnit;// 商品单位
    private double goodsPrice;// 进货价格
    private Date purchaseDate;// 进货日期

    public Inventory() {
        super();
    }

    public Inventory(Purchase p) {
        super();
        this.goodsNumber = p.getGoods_no();
        this.goodsName = p.getGoods_name();
        this.goodsCount = p.getPurchase_amt();
        this.goodsUnit = p.getGoods_unit();
        this.goodsPrice = p.getPurchase_price();
        this.purchaseDate = p.getPurchase_date();
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

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String purchaseDate = date.format(this.purchaseDate);
        return "Inventory [goodsNumber=" + goodsNumber + ", goodsName=" + goodsName + ", goodsCount=" + goodsCount
                + ", goodsUnit=" + goodsUnit + ", goodsPrice=" + goodsPrice + ", purchaseDate=" + purchaseDate
                + "]";
    }
}

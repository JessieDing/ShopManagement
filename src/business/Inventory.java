package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private int goodsCount = 0;// ��Ʒ����
    private String goodsUnit;// ��Ʒ��λ
    private double goodsPrice;// �����۸�
    private Date purchaseDate;// ��������

    public Inventory(Purchase p) {
        super();
        this.goodsNumber = p.getGoodsNumber();
        this.goodsName = p.getGoodsName();
        this.goodsCount = p.getPurchaseAmount();
        this.goodsUnit = p.getGoodsUnit();
        this.goodsPrice = p.getPurchasePrice();
        this.purchaseDate = p.getPurchaseDate();
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
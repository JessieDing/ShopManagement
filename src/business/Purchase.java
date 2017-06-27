package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private int purchaseAmount; // 采购（进货）数量
    private String goodsUnit;// 商品单位
    private double purchasePrice;// 进货价格
    private Date purchaseDate;// 进货日期
    private String provider;// 供货商

    Purchase() {
        super();
    }

    public Purchase(String goodsNumber, String goodsName, int goods_count, String goodsUnit, double goods_price,
                    Date purchaseDate, String provider) {
        super();
        this.goodsNumber = goodsNumber;
        this.goodsName = goodsName;
        this.purchaseAmount = goods_count;
        this.goodsUnit = goodsUnit;
        this.purchasePrice = goods_price;
        this.purchaseDate = purchaseDate;
        this.provider = provider;
    }

    public int addPurchaser() {
        return 0;
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

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String purchaseDate = date.format(this.purchaseDate);
        return "Purchase [goodsNumber=" + goodsNumber + ", goodsName=" + goodsName + ", goods_count=" + purchaseAmount
                + ", goodsUnit=" + goodsUnit + ", goods_price=" + purchasePrice + ", purchaseDate=" + purchaseDate
                + ", provider=" + provider + "]";
    }
}

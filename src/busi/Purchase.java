package busi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchase {
    private String goods_no;// 商品编号
    private String goods_name;// 商品名称
    private int purchase_amt; // 采购（进货）数量
    private String goods_unit;// 商品单位
    private double purchase_price;// 进货价格
    private Date purchase_date;// 进货日期
    private String prvd;// 供货商

    Purchase() {
        super();
    }

    public Purchase(String goods_no, String goods_name, int goods_count, String goods_unit, double goods_price,
                    Date purchase_date, String prvd) {
        super();
        this.goods_no = goods_no;
        this.goods_name = goods_name;
        this.purchase_amt = goods_count;
        this.goods_unit = goods_unit;
        this.purchase_price = goods_price;
        this.purchase_date = purchase_date;
        this.prvd = prvd;
    }

    public int addPurchaser() {
        return 0;
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

    public int getPurchase_amt() {
        return purchase_amt;
    }

    public void setPurchase_amt(int purchase_amt) {
        this.purchase_amt = purchase_amt;
    }

    public String getGoods_unit() {
        return goods_unit;
    }

    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
    }

    public double getPurchase_price() {
        return purchase_price;
    }

    public void setPurchase_price(double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getPrvd() {
        return prvd;
    }

    public void setPrvd(String prvd) {
        this.prvd = prvd;
    }

    @Override
    public String toString() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String purchaseDate = date.format(purchase_date);
        return "Purchase [goods_no=" + goods_no + ", goods_name=" + goods_name + ", goods_count=" + purchase_amt
                + ", goods_unit=" + goods_unit + ", goods_price=" + purchase_price + ", purchase_date=" + purchaseDate
                + ", prvd=" + prvd + "]";
    }
}

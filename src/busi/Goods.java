package busi;

public class Goods {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private String goodsUnit;// 商品单位
    private String goodsStatus;// 商品状态
    private int qualityDays;//保质期至

    public Goods() {
        super();
    }

    public Goods(String goodsNumber, String goodsName, String goodsUnit, String goodsStatus, int qualityDays) {
        super();
        this.goodsNumber = goodsNumber;
        this.goodsName = goodsName;
        this.goodsUnit = goodsUnit;
        this.goodsStatus = goodsStatus;
        this.qualityDays = qualityDays;
    }

    public int addGoods() {
        return 0;
    }

    public int editGoods() {
        return 0;
    }

    public int delGoods() {
        return 0;
    }

    public int queryGoods(String goods_id) {
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

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String i) {
        this.goodsStatus = i;
    }

    public int getQualityDays() {
        return qualityDays;
    }

    public void setQualityDays(int qualityDays) {

        this.qualityDays = qualityDays;

    }

    @Override
    public String toString() {
        return String.format("Goods [goodsNumber=%s, goodsName=%s, goodsUnit=%s, goodsStatus=%s, qualityDays=%s]", goodsNumber, goodsName, goodsUnit, goodsStatus, qualityDays);
    }

    public String toFileString() {
        return goodsNumber + "," + goodsName + "," + goodsUnit
                + "," + goodsStatus + "," + qualityDays;
    }
}

package busi;

public class Goods {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private String goodsUnit;// ��Ʒ��λ
    private String goods_status;// ��Ʒ״̬
    private int quality_days;//��������

    public Goods() {
        super();
    }

    public Goods(String goodsNumber, String goodsName, String goodsUnit, String goods_status, int quality_days) {
        super();
        this.goodsNumber = goodsNumber;
        this.goodsName = goodsName;
        this.goodsUnit = goodsUnit;
        this.goods_status = goods_status;
        this.quality_days = quality_days;
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

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String i) {
        this.goods_status = i;
    }

    public int getQuality_days() {
        return quality_days;
    }

    public void setQuality_days(int quality_days) {

        this.quality_days = quality_days;

    }

    @Override
    public String toString() {
        return "Goods [goodsNumber=" + goodsNumber + ", goodsName=" + goodsName + ", goodsUnit=" + goodsUnit
                + ", goods_status=" + goods_status + ", quality_days=" + quality_days + "]";
    }

    public String toFileString() {
        return goodsNumber + "," + goodsName + "," + goodsUnit
                + "," + goods_status + "," + quality_days;
    }
}

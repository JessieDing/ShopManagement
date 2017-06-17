package busi;

public class Goods {
    private String goodsNumber;// ��Ʒ���
    private String goods_name;// ��Ʒ����
    private String goods_unit;// ��Ʒ��λ
    private String goods_status;// ��Ʒ״̬
    private int quality_days;//��������

    public Goods() {
        super();
    }

    public Goods(String goodsNumber, String goods_name, String goods_unit, String goods_status, int quality_days) {
        super();
        this.goodsNumber = goodsNumber;
        this.goods_name = goods_name;
        this.goods_unit = goods_unit;
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

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_unit() {
        return goods_unit;
    }

    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
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
        return "Goods [goodsNumber=" + goodsNumber + ", goods_name=" + goods_name + ", goods_unit=" + goods_unit
                + ", goods_status=" + goods_status + ", quality_days=" + quality_days + "]";
    }

    public String toFileString() {
        return goodsNumber + "," + goods_name + "," + goods_unit
                + "," + goods_status + "," + quality_days;
    }
}

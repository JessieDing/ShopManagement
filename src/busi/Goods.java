package busi;

public class Goods {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private String goodsUnit;// ��Ʒ��λ
    private String goods_status;// ��Ʒ״̬
    private int qualityDays;//��������

    public Goods() {
        super();
    }

    public Goods(String goodsNumber, String goodsName, String goodsUnit, String goods_status, int qualityDays) {
        super();
        this.goodsNumber = goodsNumber;
        this.goodsName = goodsName;
        this.goodsUnit = goodsUnit;
        this.goods_status = goods_status;
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

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String i) {
        this.goods_status = i;
    }

    public int getQualityDays() {
        return qualityDays;
    }

    public void setQualityDays(int qualityDays) {

        this.qualityDays = qualityDays;

    }

    @Override
    public String toString() {
        return "Goods [goodsNumber=" + goodsNumber + ", goodsName=" + goodsName + ", goodsUnit=" + goodsUnit
                + ", goods_status=" + goods_status + ", qualityDays=" + qualityDays + "]";
    }

    public String toFileString() {
        return goodsNumber + "," + goodsName + "," + goodsUnit
                + "," + goods_status + "," + qualityDays;
    }
}

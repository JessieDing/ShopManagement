package business;

public class TransEditGoods extends TransAbs {
    String goods_no;// ��Ʒ���
    String goods_name;// ��Ʒ����
    String goods_unit;// ��Ʒ��λ
    String goods_status;// ��Ʒ״̬

    public TransEditGoods() {
        super();
    }

    public TransEditGoods(String goods_no, String goods_name, String goods_unit, String goods_status) {
        super();
        this.goods_no = goods_no;
        this.goods_name = goods_name;
        this.goods_unit = goods_unit;
        this.goods_status = goods_status;
    }

    public void printPrompt() {
        System.out.println("��Ʒ��Ϣ�޸�|������������Ʒ��ź��޸ĺ����Ʒ��Ϣ��");
        System.out.println("@goods_no @goods_name @goods_unit @goods_status");

    }

    public int getInput() {
        // ��Ʒ���
        goods_no = scan.next();
        if (goods_no == null) {
            setTransResult("��ȡ��Ʒ��Ŵ���");
            return -1;
        }

        // ��Ʒ����
        goods_name = scan.next();
        if (goods_name == null) {
            setTransResult("��ȡ��Ʒ���ƴ���");
            return -1;
        }

        // ��Ʒ��λ
        goods_unit = scan.next();
        if (goods_unit == null) {
            setTransResult("��ȡ��Ʒ��λ����");
            return -1;
        }

        // ��Ʒ״̬
        goods_status = scan.next();
        if (goods_status == null) {
            setTransResult("��ȡ��Ʒ״̬����");
            return -1;
        }

        DataValidate validator = new DataValidate();
        if (!validator.goodsStatusValidate(goods_status)) {
            setTransResult("״̬���벻�Ϸ�");
            return -1;
        }

        return 0;
    }

    public int doTrans() {
        Goods goods = databaseOperator.exactFindGoods(goods_no);
        goods.setGoodsName(goods_name);
        goods.setGoodsUnit(goods_unit);
        goods.setGoodsStatus(goods_status);
        setTransResult("�޸ĳɹ�");
        databaseOperator.editGoodsInfo(databaseOperator.getGoodsFile(), goods_no);//�޸ĺ�д���ļ�
        return 0;
    }

    public void printResult() {
        System.out.println(transResult);
    }

}

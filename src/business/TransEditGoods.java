package business;

class TransEditGoods extends TransAbs {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private String goodsUnit;// ��Ʒ��λ
    private String goodsStatus;// ��Ʒ״̬

    TransEditGoods() {
        super();
    }

    public void printPrompt() {
        System.out.println("��Ʒ��Ϣ�޸�|������������Ʒ��ź��޸ĺ����Ʒ��Ϣ��");
        System.out.println("@goodsNumber @goodsName @goodsUnit @goodsStatus");
    }

    public int getInput() {
        // ��Ʒ���
        goodsNumber = scan.next();
        if (goodsNumber == null) {
            setTransResult("��ȡ��Ʒ��Ŵ���");
            return -1;
        }

        // ��Ʒ����
        goodsName = scan.next();
        if (goodsName == null) {
            setTransResult("��ȡ��Ʒ���ƴ���");
            return -1;
        }

        // ��Ʒ��λ
        goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("��ȡ��Ʒ��λ����");
            return -1;
        }

        // ��Ʒ״̬
        goodsStatus = scan.next();
        if (goodsStatus == null) {
            setTransResult("��ȡ��Ʒ״̬����");
            return -1;
        }

        DataValidate validator = new DataValidate();
        if (!validator.goodsStatusValidate(goodsStatus)) {
            setTransResult("״̬���벻�Ϸ�");
            return -1;
        }

        return 0;
    }

    public int process() {
        Goods goods = databaseOperator.exactFindGoods(goodsNumber);
        goods.setGoodsName(goodsName);
        goods.setGoodsUnit(goodsUnit);
        goods.setGoodsStatus(goodsStatus);
        setTransResult("�޸ĳɹ�");
        databaseOperator.editGoodsInfo(databaseOperator.getGoodsFile(), goodsNumber);//�޸ĺ�д���ļ�
        return 0;
    }

    public void printResult() {
        System.out.println(transResult);
    }

}

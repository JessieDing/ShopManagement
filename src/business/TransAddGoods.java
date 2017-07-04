package business;

public class TransAddGoods extends TransAbs {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private String goodsUnit;// ��λ
    private int qualityDays;//��������

    public void printPrompt() {
        System.out.println("�����Ʒ|������������Ϣ��");
        System.out.println("@goodsNumber @goodsName @goodsUnit @qualityDays");
    }

    public int getInput() {
        // ��ȡ��Ʒ���
        goodsNumber = scan.next();
        if (goodsNumber == null) {
            setTransResult("��ȡ��Ʒ��Ŵ���");
            return -1;
        }

        // ��ȡ��Ʒ����
        goodsName = scan.next();
        if (goodsName == null) {
            setTransResult("��ȡ��Ʒ���ƴ���");
            return -1;
        }

        // ��ȡ��Ʒ��λ
        goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("��ȡ��Ʒ��λ����");
            return -1;
        }

        // �ж���Ʒ����Ƿ��ظ�
        if (databaseOperator.exactFindGoods(goodsNumber) != null) {
            setTransResult("��Ʒ����Ѵ���");
            return -1;
        }

        //��ȡ������
        qualityDays = scan.nextInt();
        if (qualityDays == 0) {
            setTransResult("��ȡ�����ڴ���");
            return -1;
        }

        DataValidate validator = new DataValidate();
        if (!validator.goodsNumberValidate(goodsNumber)) {
            setTransResult("��Ʒ��Ų��Ϸ�");
            return -1;
        }

        System.out.print("goodsNumber[" + goodsNumber + "],");
        System.out.print("goodsName[" + goodsName + "],");
        System.out.print("goodsUnit[" + goodsUnit + "]");
        System.out.println();
        return 0;
    }

    public int process() {
        Goods g = new Goods();
        g.setGoodsNumber(goodsNumber);// ���û��������Ʒ��Ÿ�ֵ��Goods����
        g.setGoodsName(goodsName);// ��ֵ��Ʒ����
        g.setGoodsUnit(goodsUnit);// ��ֵ��Ʒ��λ
        g.setGoodsStatus("0");// ������Ʒ��Ĭ��״̬Ϊ0��Ч
        g.setQualityDays(qualityDays);
        if (getDatabaseOperator().insertGoods(g) == 0) {
            setTransResult("������Ʒ�ɹ�");
            databaseOperator.writeGoodsInfo(databaseOperator.getGoodsFile(), g.toFileString());//System.getProperty("line.separator")
            return 0;
        } else {
            setTransResult("������Ʒʧ��");
            return -1;
        }
    }

    public void printResult() {
        System.out.println(transResult);
    }
}

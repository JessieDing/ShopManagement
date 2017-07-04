package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TransAddPurchase extends TransAbs {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private String goodsUnit;// ��Ʒ��λ
    private int goodsCount;// �ɹ�����
    private double goodsPrice;// �����۸�
    private Date purchaseDate;// ��������
    private String provider;// ������

    public void printPrompt() {
        System.out.println("������Ʒ��ţ�");
        goodsNumber = scan.nextLine();
        if (findGoodsInfo(goodsNumber) == 0) {
            System.out.println("�ɹ�¼��|������������Ϣ��");
            System.out.println(
                    "@goodsNumber @goodsName @goodsCount @goodsUnit @goodsPrice @purchaseDate(yyyy-mm-dd) @provider");
        }
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

        // ��ȡ�ɹ�����
        String count = scan.next();
        goodsCount = Integer.parseInt(count);
        if (goodsCount == 0) {
            setTransResult("��ȡ�ɹ�����ʧ��");
            return -1;
        }

        // ��ȡ��Ʒ��λ
        goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("��ȡ��Ʒ��λ����");
            return -1;
        }

        // ��ȡ�����۸�
        String price = scan.next();
        goodsPrice = Double.parseDouble(price);
        if (goodsPrice == 0) {
            setTransResult("��ȡ�����۸�ʧ��");
            return -1;
        }

        // ��ȡ����
        if (scan.hasNext()) {
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                purchaseDate = date.parse(scan.next());
            } catch (Exception e) {
            }
        } else {
            System.out.println("��������ڸ�ʽ����");
            return -1;
        }

        // ��ȡ������
        provider = scan.next();
        if (provider == null) {
            setTransResult("��ȡ������ʧ��");
            return -1;
        }

        return 0;
    }

    public int process() {
        Purchase purchase = new Purchase();
        purchase.setGoodsNumber(goodsNumber);
        purchase.setGoodsName(goodsName);
        purchase.setPurchaseAmount(goodsCount);
        purchase.setGoodsUnit(goodsUnit);
        purchase.setPurchasePrice(goodsPrice);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setProvider(provider);
        addInventory(purchase);// ��ӿ��(�ɹ�֮����п��)
        if (getDatabaseOperator().insertPurchase(purchase) == 0) {
            databaseOperator.printAllPurchase();
            setTransResult("�ɹ���Ϣ¼��ɹ�");
            return 0;
        } else {
            setTransResult("�ɹ���Ϣ¼��ʧ��");
            return -1;
        }
    }

    private int findGoodsInfo(String no) {
        Goods goods = databaseOperator.exactFindGoods(no);
        if (goods == null) {
            setTransResult("�Ҳ�������Ʒ��ţ�");
            return -1;
        } else {
            System.out.println("����Ʒ��Ϣ���£�");
            System.out.print("goodsNumber[" + goods.getGoodsNumber() + "],");
            System.out.print("goodsName[" + goods.getGoodsName() + "],");
            System.out.print("goodsUnit[" + goods.getGoodsUnit() + "]");
            System.out.println();
            return 0;
        }
    }

    private void addInventory(Purchase purchase) {
        Inventory inventory = databaseOperator.exactFindInventory(purchase.getGoodsNumber());
        if (inventory == null) {
            inventory = new Inventory(purchase);
            databaseOperator.insertInventory(inventory);
        } else {
            inventory.setGoodsCount(inventory.getGoodsCount() + purchase.getPurchaseAmount());
        }
    }

    public void printResult() {
        System.out.println(transResult);
    }
}

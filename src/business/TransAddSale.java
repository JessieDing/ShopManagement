package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TransAddSale extends TransAbs {
    private String goodsNumber;// ��Ʒ���
    private String goodsName;// ��Ʒ����
    private int saleCount;// ��������
    private double salePrice;// ���ۼ۸�
    private Date saleDate;// ��������

    private int findGoodsInfo(String no) {
        Inventory inventory = databaseOperator.exactFindInventory(no);
        if (inventory == null) {
            setTransResult("����¼���Ҳ�������Ʒ��ţ�");
            return -1;
        } else {
            System.out.println("����Ʒ��Ϣ���£�");
            System.out.println("goodsNumber[" + inventory.getGoodsNumber() + "],");
            System.out.println("goodsName[" + inventory.getGoodsName() + "],");
            System.out.println("Goods_count[" + inventory.getGoodsCount() + "]");

        }

        return 0;
    }

    public void printPrompt() {
        System.out.println("������Ʒ��ţ�");
        goodsNumber = scan.next();
        if (findGoodsInfo(goodsNumber) == 0) {
            System.out.println("����¼��|������������Ϣ��");
            System.out.println("@goodsNumber @goodsName @saleCount @goods_unit @salePrice @saleDate(yyyy-mm-dd)");
        }
    }

    public int getInput() {
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

        // ��ȡ��������
        String count = scan.next();
        saleCount = Integer.parseInt(count);
        Inventory inventory = databaseOperator.exactFindInventory(goodsNumber);
        if (saleCount > inventory.getGoodsCount()) {
            setTransResult("��治�㣡");
            return -1;
        }

        String goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("��ȡ��Ʒ��λ����");
            return -1;
        }

        salePrice = Double.parseDouble(scan.next());
        if (salePrice < inventory.getGoodsPrice()) {
            setTransResult("��������ۼ�С�ڽ��ۣ�");
            return -1;
        }

        if (scan.hasNext()) {
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                saleDate = date.parse(scan.next());
            } catch (Exception ignored) {
            }
            if (saleDate.before(inventory.getPurchaseDate())) {
                System.out.println("�����������ʱ�����ڽ���ʱ�䣡");
                return -1;
            }
        } else {
            System.out.println("��������ڸ�ʽ����");
            return -1;
        }

        return 0;
    }

    public int process() {
        Sale sale = new Sale();
        sale.setGoodsNumber(goodsNumber);
        sale.setGoodsName(goodsName);
        sale.setPrice(salePrice);
        sale.setSaleAmount(saleCount);
        sale.setSaleDate(saleDate);
        deleteInventory(sale);//�ӿ����ɾ��
        if (getDatabaseOperator().insertSale(sale) == 0) {
            getDatabaseOperator().printAllSale();
            setTransResult("������Ϣ¼��ɹ�");
            return 0;
        } else {
            setTransResult("������Ϣ¼��ʧ��");
            return -1;
        }

    }

    private void deleteInventory(Sale sale) {
        Inventory inventory = databaseOperator.exactFindInventory(sale.getGoodsNumber());
        if (inventory == null) {
            System.out.println("��治��");
        } else if (inventory.getGoodsCount() < sale.getSaleAmount()) {
            System.out.println("��治��");
        } else {
            inventory.setGoodsCount(inventory.getGoodsCount() - sale.getSaleAmount());
        }
    }

    public void printResult() {
        System.out.println(transResult);
    }
}

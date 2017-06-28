package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransAddSale extends TransAbs {
    String goods_no;// ��Ʒ���
    String goods_name;// ��Ʒ����
    int sale_count;// ��������
    String goods_unit;
    double sale_price;// ���ۼ۸�
    Date sale_date;// ��������
    SalesReport salesReport;


    public int findGoodsInfo(String no) {
        Inventory inventory = databaseOperator.exactFindInventory(no);
        if (inventory == null) {
            setTransResult("����¼���Ҳ�������Ʒ��ţ�");
            return -1;
        } else {
            System.out.println("����Ʒ��Ϣ���£�");
            System.out.println("goods_no[" + inventory.getGoodsNumber() + "],");
            System.out.println("goods_name[" + inventory.getGoodsName() + "],");
            System.out.println("Goods_count[" + inventory.getGoodsCount() + "]");

        }

        return 0;
    }

    public void printPrompt() {
        System.out.println("������Ʒ��ţ�");
        goods_no = scan.next();
        if (findGoodsInfo(goods_no) == 0) {
            System.out.println("����¼��|������������Ϣ��");
            System.out.println("@goods_no @goods_name @sale_count @goods_unit @sale_price @sale_date(yyyy-mm-dd)");
        }
    }

    public int getInput() {

        goods_no = scan.next();
        if (goods_no == null) {
            setTransResult("��ȡ��Ʒ��Ŵ���");
            return -1;
        }

        // ��ȡ��Ʒ����
        goods_name = scan.next();
        if (goods_name == null) {
            setTransResult("��ȡ��Ʒ���ƴ���");
            return -1;
        }

        // ��ȡ��������
        String count = scan.next();
        sale_count = Integer.parseInt(count);
        Inventory inventory = databaseOperator.exactFindInventory(goods_no);
        if (sale_count > inventory.getGoodsCount()) {
            setTransResult("��治�㣡");
            return -1;
        }

        goods_unit = scan.next();
        if (goods_unit == null) {
            setTransResult("��ȡ��Ʒ��λ����");
            return -1;
        }

        sale_price = Double.parseDouble(scan.next());
        if (sale_price < inventory.getGoodsPrice()) {
            setTransResult("��������ۼ�С�ڽ��ۣ�");
            return -1;
        }

        if (scan.hasNext()) {
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                sale_date = date.parse(scan.next());
            } catch (Exception e) {
            }
            if (sale_date.before(inventory.getPurchaseDate())) {
                System.out.println("�����������ʱ�����ڽ���ʱ�䣡");
                return -1;
            }
        } else {
            System.out.println("��������ڸ�ʽ����");
            return -1;
        }

        return 0;
    }

    public int doTrans() {

        Sale sale = new Sale();
        sale.setGoodsNumber(goods_no);
        sale.setGoodsName(goods_name);
        sale.setPrice(sale_price);
        sale.setSaleAmount(sale_count);
        sale.setSaleDate(sale_date);
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

package business;

import java.util.ArrayList;
import java.util.List;

public class TransPrintSalesReport extends TransAbs {

    public void printPrompt() {
        System.out.println("��ӡ���۱���");
    }

    public int getInput() {
        return 0;
    }

    public void printResult() {
        System.out.println(trans_result);
    }

    public int doTrans() {

        List<Sale> sales = dbhelper.getSale_list();
        List<SalesReport> reports = new ArrayList<>();
        for (Sale sale : sales) {
            SalesReport report = new SalesReport();
            report.setGoodsName(sale.getGoodsName());
            report.setGoodsNumber(sale.getGoodsNumber());
            report.setSalePrice(sale.getPrice());
            report.setSaleAmount(sale.getSaleAmount());
            Purchase purchase = dbhelper.exactFindPurchase(sale.getGoodsNumber());
            report.setPurchasePrice(purchase.getPurchasePrice());
            report.setProfits(report.calcProfits());
            reports.add(report);
        }
        System.out.println();
        System.out.println("\t\t\t   ��Ʒ����ͳ�Ʊ�");
        System.out.println("________________________________________________________________");
        System.out.println("     ��Ʒ���\t��Ʒ����\t   �����۸�\t   ���ۼ۸�\t  ��������\t   ë����");

        double totalAmount = 0.00;
        int totalNumber = 0;
        double totalProfits = 0;
        for (SalesReport report : reports) {
            double rowSales = 0.00;
            System.out.println(report.toString());// ������ӡsales
            rowSales = report.calcTotalAmount();// ����ÿ����������������۶�
            totalAmount += rowSales;
            totalNumber += report.getSaleAmount();
            totalProfits += report.getProfits();
        }
        System.out.println("________________________________________________________________");
        System.out.println();
        System.out.println("\t\t\t\t\t\t��������" + totalNumber);
        System.out.println("\t\t\t\t\t\t�����۶" + totalAmount);
        System.out.println("\t\t\t\t\t\t������" + totalProfits);
        setTrans_result("\t\t\t\t\t\t���۱����ӡ���");
        System.out.println("________________________________________________________________");
        return 0;
    }
}
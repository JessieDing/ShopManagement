package busi;

import java.util.ArrayList;
import java.util.List;

public class TransPrintSalesReport extends TransAbs {
    SalesReport salesReport;

    public static void printSalesReport(SalesReport salesReport) {
        System.out.println();
        System.out.println("_____________________________________________");
        System.out.println("\t��Ʒ���\t��Ʒ����\t�����۸�\t���ۼ۸�\t��������\të����");
        System.out.println(salesReport.toString());
        System.out.println("");
        System.out.println("_____________________________________________");
        System.out.println();
    }

    public void prtPrompt() {
        System.out.println("��ӡ���۱���");
    }

    public int getInput() {
        return 0;
    }

    public int doTrans() {
        List<Sale> sales = dbhelper.getSale_list();
        List<SalesReport> reports = new ArrayList<>();
        for (Sale sale : sales) {
            SalesReport report = new SalesReport();
            report.setGoodsName(sale.getGoods_name());
            report.setGoodsNo(sale.getGoods_no());
            report.setSalePrice(sale.getPrice());
            report.setSaleAmount(sale.getSale_amt());
            Purchase purchase = dbhelper.exactFindPurchase(sale.getGoods_no());
            report.setPurchasePrice(purchase.getPurchase_price());
            report.setProfits(report.calcProfits(report.getPurchasePrice(), report.getSalePrice()));
            reports.add(report);
        }

        double totalAmount = 0;
        int totalNumber = 0;
        double totalProfits = 0;
        for (SalesReport report : reports) {
            System.out.println(report.toString());
            totalAmount += report.getSalePrice();
            totalNumber += report.getSaleAmount();
            totalProfits += report.getProfits();
        }
        System.out.println("�����۶" + totalAmount);
        System.out.println("��������" + totalNumber);
        System.out.println("������" + totalProfits);
        setTrans_result("��ӡ���۱���ɹ���");
        return 0;
    }

    public void prtResult() {
        System.out.println(trans_result);
    }
}
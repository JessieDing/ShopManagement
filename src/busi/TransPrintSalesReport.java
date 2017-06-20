package busi;

import java.util.ArrayList;
import java.util.List;

public class TransPrintSalesReport extends TransAbs {

    public void prtPrompt() {
        System.out.println("打印销售报表");
    }

    public int getInput() {
        return 0;
    }

    public void prtResult() {
        System.out.println(trans_result);
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
            report.setPurchasePrice(purchase.getPurchasePrice());
            report.setProfits(report.calcProfits());
            reports.add(report);
        }
        System.out.println();
        System.out.println("\t\t\t   产品销售统计表");
        System.out.println("________________________________________________________________");
        System.out.println("     商品编号\t商品名称\t   进货价格\t   销售价格\t  销售数量\t   毛利润");

        double totalAmount = 0.00;
        int totalNumber = 0;
        double totalProfits = 0;
        for (SalesReport report : reports) {
            double rowSales = 0.00;
            System.out.println(report.toString());// 逐条打印sales
            rowSales = report.calcTotalAmount();// 计算每条销售情况的总销售额
            totalAmount += rowSales;
            totalNumber += report.getSaleAmount();
            totalProfits += report.getProfits();
        }
        System.out.println("________________________________________________________________");
        System.out.println();
        System.out.println("\t\t\t\t\t\t总销量：" + totalNumber);
        System.out.println("\t\t\t\t\t\t总销售额：" + totalAmount);
        System.out.println("\t\t\t\t\t\t总利润：" + totalProfits);
        setTrans_result("\t\t\t\t\t\t销售报表打印完毕");
        System.out.println("________________________________________________________________");
        return 0;
    }
}
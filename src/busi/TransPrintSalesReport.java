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
            report.setProfits(report.calcProfits());
            reports.add(report);
        }
        System.out.println("______________________________________________________________________________________________________________________");
        System.out.println("\t        商品编号\t        商品名称\t        进货价格\t        销售价格\t     销售数量\t      毛利润");
        double totalAmount = 0;
        int totalNumber = 0;
        double totalProfits = 0;
        for (SalesReport report : reports) {
            System.out.println(report.toString());//逐条打印sales
            totalAmount += report.getSalePrice();
            totalNumber += report.getSaleAmount();
            totalProfits += report.getProfits();
        }
        System.out.println("______________________________________________________________________________________________________________________");
        System.out.println("总销量：" + totalNumber);
        System.out.println("总销售额：" + totalAmount);
        System.out.println("总利润：" + totalProfits);
        setTrans_result("打印销售报表成功。");
        System.out.println("______________________________________________________________________________________________________________________");
        return 0;
    }

    public void prtResult() {
        System.out.println(trans_result);
    }
}
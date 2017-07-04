package business;

import java.util.ArrayList;
import java.util.List;

class TransPrintSalesReport extends AbstractTransaction {

    public void printPrompt() {
        System.out.println("打印销售报表");
    }

    public int getInput() {
        return 0;
    }

    public void printResult() {
        System.out.println(transactionResult);
    }

    public int process() {
        List<Sale> sales = databaseOperator.getSaleList();
        List<SalesReport> reports = new ArrayList<>();
        for (Sale sale : sales) {
            SalesReport report = new SalesReport();
            report.setGoodsName(sale.getGoodsName());
            report.setGoodsNumber(sale.getGoodsNumber());
            report.setSalePrice(sale.getPrice());
            report.setSaleAmount(sale.getSaleAmount());
            Purchase purchase = databaseOperator.exactFindPurchase(sale.getGoodsNumber());
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
            System.out.println(report.toString());// 逐条打印sales
            double rowSales = report.calcTotalAmount();// 计算每条销售情况的总销售额
            totalAmount += rowSales;
            totalNumber += report.getSaleAmount();
            totalProfits += report.getProfits();
        }
        System.out.println("________________________________________________________________");
        System.out.println();
        System.out.println("\t\t\t\t\t\t总销量：" + totalNumber);
        System.out.println("\t\t\t\t\t\t总销售额：" + totalAmount);
        System.out.println("\t\t\t\t\t\t总利润：" + totalProfits);
        setTransactionResult("\t\t\t\t\t\t销售报表打印完毕");
        System.out.println("________________________________________________________________");
        return 0;
    }
}
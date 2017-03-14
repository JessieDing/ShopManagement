package busi;

public class TransPrintSalesReport extends TransAbs {
	SalesReport salesReport;

	public static void printSalesReport(SalesReport salesReport) {
		System.out.println();
		System.out.println("_____________________________________________");
		System.out.println("\t商品编号\t商品名称\t进货价格\t销售价格\t销售数量\t毛利润");
		System.out.println(salesReport.toString());
		System.out.println("");
		System.out.println("_____________________________________________");
		System.out.println();
	}

	public void prtPrompt() {
		System.out.println("打印销售报表");
	}

	public int getInput() {

		dbhelper.getSale_list();

		return 0;
	}

	public int doTrans() {
		return 0;
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}
package busi;

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
//
// class salesReport {
//
// }

// package busi;
//
// import java.util.Date;
//
// public class TransEditInventory extends TransAbs {
// String goods_no;
// String goods_name;
// int goods_count;
// String goods_unit;
// double goods_price;
// Date purchase_date;
// Inventory inventory;
// Sale sale;
//
//
// public void prtPrompt() {
// System.out.println("�����Ϣ�޸�|��������Ʒ��ţ�");
//
// }
//
// public int getInput() {
//// ��ȡ��Ʒ���
// goods_no = scan.next();
// if (goods_no == null) {
// setTrans_result("��ȡ��Ʒ���ʧ��");
// return -1;
// }
// inventory = dbhelper.exactFindInventory(goods_no);
// sale = dbhelper.exactFindSale(goods_no);
// return 0;
// }
//
// public int doTrans() {
// if (sale != null) {
// int changedAmt = inventory.getGoods_count() - sale.getSale_amt();
//// inventory.setGoods_count(changedAmt);
// dbhelper.deleteInventoryGoodsCount(goods_no, changedAmt);
// setTrans_result("�޸ĳɹ�");
// } else {
// setTrans_result("����ޱ仯");
// }
//
//
// return 0;
// }
//
// public void prtResult() {
// System.out.println(trans_result);
// }
//
// }
//

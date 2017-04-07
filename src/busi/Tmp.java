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
// System.out.println("库存信息修改|请输入商品编号：");
//
// }
//
// public int getInput() {
//// 读取商品编号
// goods_no = scan.next();
// if (goods_no == null) {
// setTrans_result("读取商品编号失败");
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
// setTrans_result("修改成功");
// } else {
// setTrans_result("库存无变化");
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

//package busi;
//
//import java.util.Date;
//
//public class TransEditInventory extends TransAbs {
//    String goods_no;
//    String goods_name;
//    int goods_count;
//    String goods_unit;
//    double goods_price;
//    Date purchase_date;
//    Inventory inventory;
//    Sale sale;
//    Purchase purchase;
//    String editType;
//
//    public void addInventory(Purchase phurchase) {
//        Inventory inventory = new Inventory(phurchase);
//        dbhelper.insertInventory(inventory);
//    }
//
//    public void prtPrompt() {
//        System.out.println("�����Ϣ�޸�|������������Ϣ��");
//        System.out.println("@editType @goods_no @goods_name");
//        System.out.println("editType�� 0-���ٿ�� 1-���ӿ��  ");
//
//    }
//
//    public int getInput() {
//
//        editType = scan.next();
//        if (editType == null) {
//            setTrans_result("��ȡ������ʽʧ��");
//            return -1;
//        }
//
//        // ��ȡ��Ʒ���
//        goods_no = scan.next();
//        if (goods_no == null) {
//            setTrans_result("��ȡ��Ʒ���ʧ��");
//            return -1;
//        }
//
//        goods_name = scan.next();
//        if (goods_name == null) {
//            setTrans_result("��ȡ��Ʒ����ʧ��");
//            return -1;
//        }
//
//        return 0;
//    }
//
//    public int doTrans() {
//
//        if (dbhelper.exactFindInventory(goods_no) == null) {
//            purchase = dbhelper.exactFindPurchase(goods_no);
//            addInventory(purchase);
//            setTrans_result("���ӿ��ɹ�");
//
//        } else if (dbhelper.exactFindSale(goods_no) != null) {
//            sale = dbhelper.exactFindSale(goods_no);
//
//            inventory = dbhelper.exactFindInventory(goods_no);
//
//            if (editType.equals("0")) {
//                int deleteAmt = inventory.getGoods_count() - sale.getSale_amt();
//                dbhelper.deleteInventoryGoodsCount(goods_no, deleteAmt);
//                setTrans_result("���ٿ��ɹ�");
//            } else if (editType.equals("1")) {
//                int addAmt = inventory.getGoods_count() + purchase.getPurchase_amt();
//                dbhelper.addInventoryGoodsCount(goods_no, addAmt);
//                setTrans_result("���ӿ��ɹ�");
//            }
//        } else {
//            setTrans_result("����ޱ仯");
//        }
//        return 0;
//    }
//
//    public void prtResult() {
//        System.out.println(trans_result);
//    }
//
//}

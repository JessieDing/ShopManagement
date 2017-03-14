package busi;

public class TransFactory {

    public TransInterface createTrans(String strTrans) {
        TransInterface trans = null;

        if (strTrans.equals("1")) {// 添加商品信息交易
            trans = new TransAddGoods();
        } else if (strTrans.equals("2")) {// 修改商品信息
            trans = new TransEditGoods();
        } else if (strTrans.equals("3")) {// 查询商品
            trans = new TransQueryGoods();
        } else if (strTrans.equals("4")) {// 新增供货商
            trans = new TransAddPrvd();
        } else if (strTrans.equals("5")) {// 修改供货商
            trans = new TransEditProvider();
        } else if (strTrans.equals("6")) {// 查询供货商
            trans = new TransQueryProvider();
        } else if (strTrans.equals("7")) {
            trans = new TransAddPurchase();// 采购信息录入
        } else if (strTrans.equals("8")) {
            trans = new TransAddSale();// 销售信息录入
        } else if (strTrans.equals("9")) {
            trans = new TransQueryInventory();// 查询库存信息
        } else if (strTrans.equals("0")) {
            trans = new TransPrintSalesReport();// 打印销售报表
        }
        return trans;
    }
}

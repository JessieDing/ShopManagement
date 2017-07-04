package business;

public class TransFactory {

    public Transaction createTrans(String strTrans) {
        Transaction trans = null;
        switch (strTrans) {
            case "1": // 添加商品信息交易
                trans = new TransAddGoods();
                break;
            case "2": // 修改商品信息
                trans = new TransEditGoods();
                break;
            case "3": // 查询商品
                trans = new TransQueryGoods();
                break;
            case "4": // 新增供货商
                trans = new TransAddProvider();
                break;
            case "5": // 修改供货商
                trans = new TransEditProvider();
                break;
            case "6": // 查询供货商
                trans = new TransQueryProvider();
                break;
            case "7":
                trans = new TransAddPurchase();// 采购信息录入
                break;
            case "8":
                trans = new TransAddSale();// 销售信息录入
                break;
            case "9":
                trans = new TransQueryInventory();// 查询库存信息
                break;
            case "0":
                trans = new TransPrintSalesReport();// 打印销售报表
                break;
        }
        return trans;
    }
}

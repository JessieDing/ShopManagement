package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TransAddSale extends TransAbs {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private int saleCount;// 销售数量
    private double salePrice;// 销售价格
    private Date saleDate;// 销售日期

    private int findGoodsInfo(String no) {
        Inventory inventory = databaseOperator.exactFindInventory(no);
        if (inventory == null) {
            setTransResult("库存记录中找不到该商品编号！");
            return -1;
        } else {
            System.out.println("该商品信息如下：");
            System.out.println("goodsNumber[" + inventory.getGoodsNumber() + "],");
            System.out.println("goodsName[" + inventory.getGoodsName() + "],");
            System.out.println("Goods_count[" + inventory.getGoodsCount() + "]");

        }

        return 0;
    }

    public void printPrompt() {
        System.out.println("输入商品编号：");
        goodsNumber = scan.next();
        if (findGoodsInfo(goodsNumber) == 0) {
            System.out.println("销售录入|请输入以下信息：");
            System.out.println("@goodsNumber @goodsName @saleCount @goods_unit @salePrice @saleDate(yyyy-mm-dd)");
        }
    }

    public int getInput() {
        goodsNumber = scan.next();
        if (goodsNumber == null) {
            setTransResult("获取商品编号错误");
            return -1;
        }

        // 读取商品名称
        goodsName = scan.next();
        if (goodsName == null) {
            setTransResult("获取商品名称错误");
            return -1;
        }

        // 读取销售数量
        String count = scan.next();
        saleCount = Integer.parseInt(count);
        Inventory inventory = databaseOperator.exactFindInventory(goodsNumber);
        if (saleCount > inventory.getGoodsCount()) {
            setTransResult("库存不足！");
            return -1;
        }

        String goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("获取商品单位错误");
            return -1;
        }

        salePrice = Double.parseDouble(scan.next());
        if (salePrice < inventory.getGoodsPrice()) {
            setTransResult("输入错误，售价小于进价！");
            return -1;
        }

        if (scan.hasNext()) {
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                saleDate = date.parse(scan.next());
            } catch (Exception ignored) {
            }
            if (saleDate.before(inventory.getPurchaseDate())) {
                System.out.println("输入错误，销售时间早于进货时间！");
                return -1;
            }
        } else {
            System.out.println("输入的日期格式错误！");
            return -1;
        }

        return 0;
    }

    public int process() {
        Sale sale = new Sale();
        sale.setGoodsNumber(goodsNumber);
        sale.setGoodsName(goodsName);
        sale.setPrice(salePrice);
        sale.setSaleAmount(saleCount);
        sale.setSaleDate(saleDate);
        deleteInventory(sale);//从库存中删除
        if (getDatabaseOperator().insertSale(sale) == 0) {
            getDatabaseOperator().printAllSale();
            setTransResult("销售信息录入成功");
            return 0;
        } else {
            setTransResult("销售信息录入失败");
            return -1;
        }

    }

    private void deleteInventory(Sale sale) {
        Inventory inventory = databaseOperator.exactFindInventory(sale.getGoodsNumber());
        if (inventory == null) {
            System.out.println("库存不足");
        } else if (inventory.getGoodsCount() < sale.getSaleAmount()) {
            System.out.println("库存不足");
        } else {
            inventory.setGoodsCount(inventory.getGoodsCount() - sale.getSaleAmount());
        }
    }

    public void printResult() {
        System.out.println(transResult);
    }
}

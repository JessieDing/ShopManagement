package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class TransAddPurchase extends TransAbs {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private String goodsUnit;// 商品单位
    private int goodsCount;// 采购数量
    private double goodsPrice;// 进货价格
    private Date purchaseDate;// 进货日期
    private String provider;// 供货商

    public void printPrompt() {
        System.out.println("输入商品编号：");
        goodsNumber = scan.nextLine();
        if (findGoodsInfo(goodsNumber) == 0) {
            System.out.println("采购录入|请输入以下信息：");
            System.out.println(
                    "@goodsNumber @goodsName @goodsCount @goodsUnit @goodsPrice @purchaseDate(yyyy-mm-dd) @provider");
        }
    }

    public int getInput() {
        // 读取商品编号
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

        // 读取采购数量
        String count = scan.next();
        goodsCount = Integer.parseInt(count);
        if (goodsCount == 0) {
            setTransResult("获取采购数量失败");
            return -1;
        }

        // 读取商品单位
        goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("获取商品单位错误");
            return -1;
        }

        // 读取进货价格
        String price = scan.next();
        goodsPrice = Double.parseDouble(price);
        if (goodsPrice == 0) {
            setTransResult("获取进货价格失败");
            return -1;
        }

        // 读取日期
        if (scan.hasNext()) {
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                purchaseDate = date.parse(scan.next());
            } catch (Exception e) {
            }
        } else {
            System.out.println("输入的日期格式错误！");
            return -1;
        }

        // 读取供货商
        provider = scan.next();
        if (provider == null) {
            setTransResult("获取供货商失败");
            return -1;
        }

        return 0;
    }

    public int process() {
        Purchase purchase = new Purchase();
        purchase.setGoodsNumber(goodsNumber);
        purchase.setGoodsName(goodsName);
        purchase.setPurchaseAmount(goodsCount);
        purchase.setGoodsUnit(goodsUnit);
        purchase.setPurchasePrice(goodsPrice);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setProvider(provider);
        addInventory(purchase);// 添加库存(采购之后才有库存)
        if (getDatabaseOperator().insertPurchase(purchase) == 0) {
            databaseOperator.printAllPurchase();
            setTransResult("采购信息录入成功");
            return 0;
        } else {
            setTransResult("采购信息录入失败");
            return -1;
        }
    }

    private int findGoodsInfo(String no) {
        Goods goods = databaseOperator.exactFindGoods(no);
        if (goods == null) {
            setTransResult("找不到该商品编号！");
            return -1;
        } else {
            System.out.println("该商品信息如下：");
            System.out.print("goodsNumber[" + goods.getGoodsNumber() + "],");
            System.out.print("goodsName[" + goods.getGoodsName() + "],");
            System.out.print("goodsUnit[" + goods.getGoodsUnit() + "]");
            System.out.println();
            return 0;
        }
    }

    private void addInventory(Purchase purchase) {
        Inventory inventory = databaseOperator.exactFindInventory(purchase.getGoodsNumber());
        if (inventory == null) {
            inventory = new Inventory(purchase);
            databaseOperator.insertInventory(inventory);
        } else {
            inventory.setGoodsCount(inventory.getGoodsCount() + purchase.getPurchaseAmount());
        }
    }

    public void printResult() {
        System.out.println(transResult);
    }
}

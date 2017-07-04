package business;

class TransEditGoods extends TransAbs {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private String goodsUnit;// 商品单位
    private String goodsStatus;// 商品状态

    TransEditGoods() {
        super();
    }

    public void printPrompt() {
        System.out.println("商品信息修改|请输入已有商品编号和修改后的商品信息：");
        System.out.println("@goodsNumber @goodsName @goodsUnit @goodsStatus");
    }

    public int getInput() {
        // 商品编号
        goodsNumber = scan.next();
        if (goodsNumber == null) {
            setTransResult("读取商品编号错误");
            return -1;
        }

        // 商品名称
        goodsName = scan.next();
        if (goodsName == null) {
            setTransResult("读取商品名称错误");
            return -1;
        }

        // 商品单位
        goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("读取商品单位错误");
            return -1;
        }

        // 商品状态
        goodsStatus = scan.next();
        if (goodsStatus == null) {
            setTransResult("读取商品状态错误");
            return -1;
        }

        DataValidate validator = new DataValidate();
        if (!validator.goodsStatusValidate(goodsStatus)) {
            setTransResult("状态输入不合法");
            return -1;
        }

        return 0;
    }

    public int process() {
        Goods goods = databaseOperator.exactFindGoods(goodsNumber);
        goods.setGoodsName(goodsName);
        goods.setGoodsUnit(goodsUnit);
        goods.setGoodsStatus(goodsStatus);
        setTransResult("修改成功");
        databaseOperator.editGoodsInfo(databaseOperator.getGoodsFile(), goodsNumber);//修改后写入文件
        return 0;
    }

    public void printResult() {
        System.out.println(transResult);
    }

}

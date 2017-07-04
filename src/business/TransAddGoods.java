package business;

public class TransAddGoods extends TransAbs {
    private String goodsNumber;// 商品编号
    private String goodsName;// 商品名称
    private String goodsUnit;// 单位
    private int qualityDays;//保存天数

    public void printPrompt() {
        System.out.println("添加商品|请输入以下信息：");
        System.out.println("@goodsNumber @goodsName @goodsUnit @qualityDays");
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

        // 读取商品单位
        goodsUnit = scan.next();
        if (goodsUnit == null) {
            setTransResult("获取商品单位错误");
            return -1;
        }

        // 判断商品编号是否重复
        if (databaseOperator.exactFindGoods(goodsNumber) != null) {
            setTransResult("商品编号已存在");
            return -1;
        }

        //读取保质期
        qualityDays = scan.nextInt();
        if (qualityDays == 0) {
            setTransResult("获取保质期错误");
            return -1;
        }

        DataValidate validator = new DataValidate();
        if (!validator.goodsNumberValidate(goodsNumber)) {
            setTransResult("商品编号不合法");
            return -1;
        }

        System.out.print("goodsNumber[" + goodsNumber + "],");
        System.out.print("goodsName[" + goodsName + "],");
        System.out.print("goodsUnit[" + goodsUnit + "]");
        System.out.println();
        return 0;
    }

    public int process() {
        Goods g = new Goods();
        g.setGoodsNumber(goodsNumber);// 把用户输入的商品编号赋值给Goods对象
        g.setGoodsName(goodsName);// 赋值商品名称
        g.setGoodsUnit(goodsUnit);// 赋值商品单位
        g.setGoodsStatus("0");// 新增商品，默认状态为0有效
        g.setQualityDays(qualityDays);
        if (getDatabaseOperator().insertGoods(g) == 0) {
            setTransResult("新增商品成功");
            databaseOperator.writeGoodsInfo(databaseOperator.getGoodsFile(), g.toFileString());//System.getProperty("line.separator")
            return 0;
        } else {
            setTransResult("新增商品失败");
            return -1;
        }
    }

    public void printResult() {
        System.out.println(transResult);
    }
}

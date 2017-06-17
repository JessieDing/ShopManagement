package busi;

public class TransAddGoods extends TransAbs {
    String goods_no;// 商品编号
    String goods_name;// 商品名称
    String goods_unit;// 单位
    int quality_days;//保存天数

    public void prtPrompt() {
        System.out.println("添加商品|请输入以下信息：");
        System.out.println("@goods_no @goods_name @goods_unit @quality_days");
    }

    public int getInput() {
        // 读取商品编号
        goods_no = scan.next();
        if (goods_no == null) {
            setTrans_result("获取商品编号错误");
            return -1;
        }

        // 读取商品名称
        goods_name = scan.next();
        if (goods_name == null) {
            setTrans_result("获取商品名称错误");
            return -1;
        }

        // 读取商品单位
        goods_unit = scan.next();
        if (goods_unit == null) {
            setTrans_result("获取商品单位错误");
            return -1;
        }

        // 判断商品编号是否重复
        if (dbhelper.exactFindGoods(goods_no) != null) {
            setTrans_result("商品编号已存在");
            return -1;
        }

        //读取保质期
        quality_days = scan.nextInt();
        if (quality_days == 0) {
            setTrans_result("获取保质期错误");
            return -1;
        }


        DataValidate validator = new DataValidate();
        if (!validator.goodNoValidate(goods_no)) {
            setTrans_result("商品编号不合法");
            return -1;
        }

        System.out.print("goods_no[" + goods_no + "],");
        System.out.print("goods_name[" + goods_name + "],");
        System.out.print("goods_unit[" + goods_unit + "]");
        System.out.println();
        return 0;
    }

    public int doTrans() {
        Goods g = new Goods();
        g.setGoodsNumber(goods_no);// 把用户输入的商品编号赋值给Goods对象
        g.setGoodsName(goods_name);// 赋值商品名称
        g.setGoodsUnit(goods_unit);// 赋值商品单位
        g.setGoodsStatus("0");// 新增商品，默认状态为0有效
        g.setQualityDays(quality_days);
        if (getDbhelper().insertGoods(g) == 0) {
            setTrans_result("新增商品成功");
            dbhelper.writeGoodsInfo(dbhelper.getGoodsFile(), g.toFileString());//System.getProperty("line.separator")
            return 0;
        } else {
            setTrans_result("新增商品失败");
            return -1;
        }
    }

    public void prtResult() {
        System.out.println(trans_result);
    }
}

package busi;

public class TransEditGoods extends TransAbs {
    String goods_no;// 商品编号
    String goods_name;// 商品名称
    String goods_unit;// 商品单位
    String goods_status;// 商品状态

    public TransEditGoods() {
        super();
    }

    public TransEditGoods(String goods_no, String goods_name, String goods_unit, String goods_status) {
        super();
        this.goods_no = goods_no;
        this.goods_name = goods_name;
        this.goods_unit = goods_unit;
        this.goods_status = goods_status;
    }

    public void prtPrompt() {
        System.out.println("商品信息修改|请输入已有商品编号和修改后的商品信息：");
        System.out.println("@goods_no @goods_name @goods_unit @goods_status");

    }

    public int getInput() {
        // 商品编号
        goods_no = scan.next();
        if (goods_no == null) {
            setTrans_result("读取商品编号错误");
            return -1;
        }

        // 商品名称
        goods_name = scan.next();
        if (goods_name == null) {
            setTrans_result("读取商品名称错误");
            return -1;
        }

        // 商品单位
        goods_unit = scan.next();
        if (goods_unit == null) {
            setTrans_result("读取商品单位错误");
            return -1;
        }

        // 商品状态
        goods_status = scan.next();
        if (goods_status == null) {
            setTrans_result("读取商品状态错误");
            return -1;
        }

        DataValidate validator = new DataValidate();
        if (!validator.goodsStatusValidate(goods_status)) {
            setTrans_result("状态输入不合法");
            return -1;
        }

        return 0;
    }

    public int doTrans() {
        Goods goods = dbhelper.exactFindGoods(goods_no);
        goods.setGoodsName(goods_name);
        goods.setGoodsUnit(goods_unit);
        goods.setGoodsStatus(goods_status);
        setTrans_result("修改成功");
        dbhelper.editGoodsInfo(dbhelper.getGoodsFile(), goods_no);//修改后写入文件
        return 0;
    }

    public void prtResult() {
        System.out.println(trans_result);
    }

}

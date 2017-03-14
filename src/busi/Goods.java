package busi;

public class Goods {
	private String goods_no;// 商品编号
	private String goods_name;// 商品名称
	private String goods_unit;// 商品单位
	private String goods_status;// 商品状态

	public Goods() {
		super();
	}

	public Goods(String goods_no, String goods_name, String goods_unit, String goods_status) {
		super();
		this.goods_no = goods_no;
		this.goods_name = goods_name;
		this.goods_unit = goods_unit;
		this.goods_status = goods_status;
	}

	public int addGoods() {
		return 0;
	}

	public int editGoods() {
		return 0;
	}

	public int delGoods() {
		return 0;
	}

	public int queryGoods(String goods_id) {
		return 0;
	}

	public String getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_unit() {
		return goods_unit;
	}

	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
	}

	public String getGoods_status() {
		return goods_status;
	}

	public void setGoods_status(String i) {
		this.goods_status = i;
	}

	@Override
	public String toString() {
		return "Goods [goods_no=" + goods_no + ", goods_name=" + goods_name + ", goods_unit=" + goods_unit
				+ ", goods_status=" + goods_status + "]";
	}

}

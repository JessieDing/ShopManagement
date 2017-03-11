package db;

import java.util.ArrayList;
import java.util.List;

import busi.Goods;

public class DBOper {
	// List��һ���ӿڣ�Goods�Ƿ���
	List<Goods> goods_list;// �����Ʒ���б�

	public DBOper() {
		goods_list = new ArrayList<Goods>();

	}

	public Goods exactFind(String no) {
		for (Goods g : goods_list) {
			if (g.getGoods_no().equals(no)) {
				return g;
			}
		}
		return null;
	}

	public List<Goods> fuzFind(String str) {
		List<Goods> list = new ArrayList<Goods>();
		for (Goods g : goods_list) {
			if (g.getGoods_name().indexOf(str) != -1) {
				list.add(g);
			}
		}
		return list;
	}

	public int insertGoods(Goods g) {
		goods_list.add(g);
		return 0;
	}

	public int delGoods(Goods g) {
		for (int i = 0; i < goods_list.size(); i++) {
			String good_no = goods_list.get(i).getGoods_no();// ��ǰ������Ʒ���
			String del_goods_no = g.getGoods_no();// Ҫɾ������Ʒ���
			if (good_no.equals(del_goods_no)) {
				goods_list.remove(i);
			}
		}
		return 0;
	}

	public int prtAllGoods() {
		for (Goods g : goods_list) {
			System.out.println(g.toString());
		}
		return 0;
	}
}

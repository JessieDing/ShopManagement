package db;

import java.util.ArrayList;
import java.util.List;

import busi.Goods;

public class DBOper {
	List<Goods> goods_list;// �����Ʒ���б�
	// List��һ���ӿڣ�Goods�Ƿ���

	public DBOper() {
		goods_list = new ArrayList<Goods>();
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
}

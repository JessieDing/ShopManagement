package busi;

import db.DBOper;

public interface TransInterface {
	// 1.��ʾ������Ϣ
	// 2.�ӽ����ȡ���������
	// 3.������
	// 4.��ʾ���״�����
	public void prtPrompt();

	public int getInput();

	public int doTrans();

	public void prtResult();

	public void setDbhelper(DBOper dbhelper);
}

package business;

import database.DatabaseOperator;

public interface TransInterface {
	// 1.��ʾ������Ϣ
	// 2.�ӽ����ȡ���������
	// 3.������
	// 4.��ʾ���״�����
	public void printPrompt();

	public int getInput();

	public int doTrans();

	public void printResult();

	public void setDbhelper(DatabaseOperator dbhelper);
}

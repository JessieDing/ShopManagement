package busi;

import db.DBOper;

public interface TransInterface {
	// 1.提示输入信息
	// 2.从界面读取输入的数据
	// 3.处理交易
	// 4.显示交易处理结果
	public void prtPrompt();

	public int getInput();

	public int doTrans();

	public void prtResult();

	public void setDbhelper(DBOper dbhelper);
}

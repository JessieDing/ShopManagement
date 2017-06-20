package busi;

import java.util.Scanner;

import db.DBOper;

abstract public class TransAbs implements TransInterface {
	String trans_result;// ÿ�����״�����
	Scanner scan;
	DBOper dbhelper;// ���ݴ�ȡ����

	public TransAbs() {
		scan = new Scanner(System.in);
	}

	public void printResult() {
		System.out.println(trans_result);
	}

	public DBOper getDbhelper() {
		return dbhelper;
	}

	public void setDbhelper(DBOper dbhelper) {
		this.dbhelper = dbhelper;
	}

	public String getTrans_result() {
		return trans_result;
	}

	public void setTrans_result(String trans_result) {
		this.trans_result = trans_result;
	}
}

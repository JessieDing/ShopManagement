package busi;

import java.util.Scanner;

import db.DBOper;
import db.ProviderDBOper;

abstract public class TransAbs implements TransInterface {
	String trans_result;// ÿ�����״�����
	Scanner scan;
	DBOper dbhelper;// ���ݴ�ȡ����
	ProviderDBOper providerDBOper;

	public TransAbs() {
		scan = new Scanner(System.in);

	}

	public void prtResult() {
		System.out.println(trans_result);
	}

	public DBOper getDbhelper() {
		return dbhelper;
	}

	public void setDbhelper(DBOper dbhelper) {
		this.dbhelper = dbhelper;
	}

	public ProviderDBOper getProviderDBOper() {
		return providerDBOper;
	}

	public void setProviderDBOper(ProviderDBOper providerDBOper) {
		this.providerDBOper = providerDBOper;
	}

	public String getTrans_result() {
		return trans_result;
	}

	public void setTrans_result(String trans_result) {
		this.trans_result = trans_result;
	}
}

package business;

import database.DatabaseOperator;

import java.util.Scanner;

abstract public class TransAbs implements TransInterface {
    String transResult;// ÿ�����״�����
    Scanner scan;
    DatabaseOperator dbhelper;// ���ݴ�ȡ����

    public TransAbs() {
        scan = new Scanner(System.in);
    }

    public void printResult() {
        System.out.println(transResult);
    }

    public DatabaseOperator getDbhelper() {
        return dbhelper;
    }

    public void setDbhelper(DatabaseOperator dbhelper) {
        this.dbhelper = dbhelper;
    }

    public String getTransResult() {
        return transResult;
    }

    public void setTransResult(String transResult) {
        this.transResult = transResult;
    }
}

package business;

import database.DatabaseOperator;

import java.util.Scanner;

abstract public class TransAbs implements Transaction {
    String transResult;// ÿ�����״�����
    Scanner scan;
    DatabaseOperator databaseOperator;// ���ݴ�ȡ����

    public TransAbs() {
        scan = new Scanner(System.in);
    }

    public void printResult() {
        System.out.println(transResult);
    }

    public DatabaseOperator getDatabaseOperator() {
        return databaseOperator;
    }

    public void setDatabaseOperator(DatabaseOperator databaseOperator) {
        this.databaseOperator = databaseOperator;
    }

    public String getTransResult() {
        return transResult;
    }

    public void setTransResult(String transResult) {
        this.transResult = transResult;
    }
}

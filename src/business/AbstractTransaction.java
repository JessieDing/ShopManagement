package business;

import database.DatabaseOperator;

import java.util.Scanner;

public abstract class AbstractTransaction implements Transaction {
    String transactionResult;// ÿ�����״�����
    Scanner scan;
    DatabaseOperator databaseOperator;// ���ݴ�ȡ����

    public AbstractTransaction() {
        scan = new Scanner(System.in);
    }

    public void printResult() {
        System.out.println(transactionResult);
    }

    public DatabaseOperator getDatabaseOperator() {
        return databaseOperator;
    }

    public void setDatabaseOperator(DatabaseOperator databaseOperator) {
        this.databaseOperator = databaseOperator;
    }

    public String getTransactionResult() {
        return transactionResult;
    }

    public void setTransactionResult(String transactionResult) {
        this.transactionResult = transactionResult;
    }
}

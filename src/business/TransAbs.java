package business;

import database.DatabaseOperator;

import java.util.Scanner;

abstract public class TransAbs implements TransInterface {
    String transResult;// 每个交易处理结果
    Scanner scan;
    DatabaseOperator dbhelper;// 数据存取对象

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

package business;

import database.DatabaseOperator;

public interface Transaction {
    // 1.提示输入信息
    // 2.从界面读取输入的数据
    // 3.处理交易
    // 4.显示交易处理结果
    void printPrompt();

    int getInput();

    int process();

    void printResult();

    void setDatabaseOperator(DatabaseOperator databaseOperator);
}

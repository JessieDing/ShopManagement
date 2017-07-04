package business;

import database.DatabaseOperator;

public interface Transaction {
    // 1.��ʾ������Ϣ
    // 2.�ӽ����ȡ���������
    // 3.������
    // 4.��ʾ���״�����
    void printPrompt();

    int getInput();

    int process();

    void printResult();

    void setDatabaseOperator(DatabaseOperator databaseOperator);
}

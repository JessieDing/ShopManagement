package business;

import database.DatabaseOperator;

public interface TransInterface {
    // 1.��ʾ������Ϣ
    // 2.�ӽ����ȡ���������
    // 3.������
    // 4.��ʾ���״�����
    void printPrompt();

    int getInput();

    int doTrans();

    void printResult();

    void setDatabaseOperator(DatabaseOperator databaseOperator);
}

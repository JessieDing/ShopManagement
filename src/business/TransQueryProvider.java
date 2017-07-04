package business;

import java.util.List;

class TransQueryProvider extends TransAbs {
    private String queryType;// ��ѯ��ʽ
    private String providerNumber;// �����̱��
    private String providerName;// ����������

    TransQueryProvider() {
        super();
    }

    public void printPrompt() {
        System.out.println("��ѯ������|������������Ϣ��");
        System.out.println("@queryType @providerNumber @providerName");
        System.out.println("queryType��0-ȫ����ѯ  1-��ȷ��ѯ   2-ģ����ѯ");
    }

    public int getInput() {
        // ��ȡ��ѯ��ʽ
        queryType = scan.next();
        if (queryType == null) {
            setTransResult("��ȡ��ѯ��ʽʧ��");
            return -1;
        } else if (queryType.equals("0")) {// ȫ����ѯ����Ҫ��ȡʣ��Ĳ���
            return 0;
        }

        // �����̱��
        providerNumber = scan.next();
        if (providerNumber == null) {
            setTransResult("��ȡ��Ʒ��Ŵ���");
            return -1;
        }

        providerName = scan.next();
        if (providerName == null) {
            setTransResult("��ȡ��Ʒ���ƴ���");
            return -1;
        }
        return 0;
    }

    public int process() {
        switch (queryType) {
            case "0": // ȫ����ѯ
                getDatabaseOperator().printAllProvider();
                setTransResult("��ѯ���");
                return 0;
            case "1": // ��ȷ��ѯ
                Provider provider = databaseOperator.exactFindProvider(providerNumber);
                if (provider != null) {
                    System.out.println(provider.toString());
                    setTransResult("��ȷ��ѯ���");
                    return 0;
                } else {
                    setTransResult("û�в鵽�����Ϣ��");
                    return -1;
                }
            case "2": // ģ����ѯ��Ŀǰֻ�ܲ�һ����
                if (databaseOperator.fuzFindProvider(providerName) != null) {
                    List<Provider> list = databaseOperator.fuzFindProvider(providerName);
                    for (Provider p : list) {
                        System.out.println(p.toString());
                    }
                    return 0;
                } else {
                    setTransResult("û�в鵽�����Ϣ��");
                    return -1;
                }

        }
        return 0;
    }

    public void printResult() {
        System.out.println(transResult);
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(String providerNumber) {
        this.providerNumber = providerNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}

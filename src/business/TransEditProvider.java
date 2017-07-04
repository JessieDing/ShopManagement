package business;

class TransEditProvider extends AbstractTransaction {
    private String providerNumber;// �����̱��
    private String providerName;// ����������
    private String providerAddress;// �����̵�ַ
    private String providerTel;// �����̵绰
    private String providerStatus;

    TransEditProvider() {
        super();
    }

    public void printPrompt() {
        System.out.println("��������Ϣ�޸�|���������й����̱�ź��޸ĺ����Ϣ��");
        System.out.println("@providerNumber @providerName @providerAddress @provider_tels @providerStatus");
    }

    public int getInput() {
        // �����̱��
        providerNumber = scan.next();
        if (providerNumber == null) {
            setTransactionResult("��ȡ�����̱�Ŵ���");
            return -1;
        }

        // ����������
        providerName = scan.next();
        if (providerName == null) {
            setTransactionResult("��ȡ���������ƴ���");
            return -1;
        }

        // �����̵�ַ
        providerAddress = scan.next();
        if (providerAddress == null) {
            setTransactionResult("��ȡ�����̵�ַ����");
            return -1;
        }

        // �����̵绰
        providerTel = scan.next();
        if (providerTel == null) {
            setTransactionResult("��ȡ�����̵绰����");
            return -1;
        }

        // ������״̬
        providerStatus = scan.next();
        if (providerStatus == null) {
            setTransactionResult("��ȡ������״̬����");
            return -1;
        }
        return 0;
    }

    public int process() {
        Provider provider = databaseOperator.exactFindProvider(providerNumber);
        provider.setProviderName(providerName);
        provider.setProviderAddress(providerAddress);
        provider.setProviderTel(providerTel);
        provider.setProviderStatus(providerStatus);
        setTransactionResult("�޸ĳɹ�");

        return 0;
    }

    public void printResult() {
        System.out.println(transactionResult);
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

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderTel() {
        return providerTel;
    }

    public void setProviderTel(String providerTel) {
        this.providerTel = providerTel;
    }

    public String getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(String providerStatus) {
        this.providerStatus = providerStatus;
    }
}

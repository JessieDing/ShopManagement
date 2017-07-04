package business;

class TransEditProvider extends AbstractTransaction {
    private String providerNumber;// 供货商编号
    private String providerName;// 供货商名称
    private String providerAddress;// 供货商地址
    private String providerTel;// 供货商电话
    private String providerStatus;

    TransEditProvider() {
        super();
    }

    public void printPrompt() {
        System.out.println("供货商信息修改|请输入已有供货商编号和修改后的信息：");
        System.out.println("@providerNumber @providerName @providerAddress @provider_tels @providerStatus");
    }

    public int getInput() {
        // 供货商编号
        providerNumber = scan.next();
        if (providerNumber == null) {
            setTransactionResult("读取供货商编号错误");
            return -1;
        }

        // 供货商名称
        providerName = scan.next();
        if (providerName == null) {
            setTransactionResult("读取供货商名称错误");
            return -1;
        }

        // 供货商地址
        providerAddress = scan.next();
        if (providerAddress == null) {
            setTransactionResult("读取供货商地址错误");
            return -1;
        }

        // 供货商电话
        providerTel = scan.next();
        if (providerTel == null) {
            setTransactionResult("读取供货商电话错误");
            return -1;
        }

        // 供货商状态
        providerStatus = scan.next();
        if (providerStatus == null) {
            setTransactionResult("读取供货商状态错误");
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
        setTransactionResult("修改成功");

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

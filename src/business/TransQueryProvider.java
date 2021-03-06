package business;

import java.util.List;

class TransQueryProvider extends AbstractTransaction {
    private String queryType;// 查询方式
    private String providerNumber;// 供货商编号
    private String providerName;// 供货商名称

    TransQueryProvider() {
        super();
    }

    public void printPrompt() {
        System.out.println("查询供货商|请输入以下信息：");
        System.out.println("@queryType @providerNumber @providerName");
        System.out.println("queryType：0-全部查询  1-精确查询   2-模糊查询");
    }

    public int getInput() {
        // 读取查询方式
        queryType = scan.next();
        if (queryType == null) {
            setTransactionResult("获取查询方式失败");
            return -1;
        } else if (queryType.equals("0")) {// 全部查询不需要读取剩余的参数
            return 0;
        }

        // 供货商编号
        providerNumber = scan.next();
        if (providerNumber == null) {
            setTransactionResult("读取商品编号错误");
            return -1;
        }

        providerName = scan.next();
        if (providerName == null) {
            setTransactionResult("读取商品名称错误");
            return -1;
        }
        return 0;
    }

    public int process() {
        switch (queryType) {
            case "0": // 全部查询
                getDatabaseOperator().printAllProvider();
                setTransactionResult("查询完成");
                return 0;
            case "1": // 精确查询
                Provider provider = databaseOperator.exactFindProvider(providerNumber);
                if (provider != null) {
                    System.out.println(provider.toString());
                    setTransactionResult("精确查询完成");
                    return 0;
                } else {
                    setTransactionResult("没有查到相关信息！");
                    return -1;
                }
            case "2": // 模糊查询（目前只能查一个）
                if (databaseOperator.fuzFindProvider(providerName) != null) {
                    List<Provider> list = databaseOperator.fuzFindProvider(providerName);
                    for (Provider p : list) {
                        System.out.println(p.toString());
                    }
                    return 0;
                } else {
                    setTransactionResult("没有查到相关信息！");
                    return -1;
                }

        }
        return 0;
    }

    public void printResult() {
        System.out.println(transactionResult);
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

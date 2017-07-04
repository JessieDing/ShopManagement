package business;

class TransAddProvider extends AbstractTransaction {
	private String providerNumber;// 供货商编号
	private String providerName;// 供货商名称
	private String providerAddress;// 供货商地址
	private String providerTel;// 供货商电话

	public void printPrompt() {
		System.out.println("添加供货商|请输入以下信息：");
		System.out.println("@providerNumber @providerName @providerAddress @providerTel");
	};

	public int getInput() {
		// 读取供货商编号
		providerNumber = scan.next();
		if (providerNumber == null) {
			setTransactionResult("获取供应商编号错误");
			return -1;
		}

		providerName = scan.next();
		if (providerName == null) {
			setTransactionResult("获取供应商名称错误");
			return -1;
		}

		providerAddress = scan.next();
		if (providerAddress == null) {
			setTransactionResult("获取供应商地址错误");
			return -1;
		}

		providerTel = scan.next();
		if (providerTel == null) {
			setTransactionResult("获取供应商电话错误");
			return -1;
		}

		// 判断供应商编号是否重复
		if (databaseOperator.exactFindProvider(providerNumber) != null) {
			setTransactionResult("供应商编号已存在！");
			return -1;
		}

		DataValidate validator = new DataValidate();
		if (!validator.providerNoValidate(providerNumber)) {
			setTransactionResult("供应商编号不合法");
			return -1;
		}

		if (!validator.telNoValidate(providerTel)) {
			setTransactionResult("电话号码不合法");
			return -1;
		}

		System.out.print("providerNumber[" + providerNumber + "],");
		System.out.print("providerName[" + providerName + "],");
		System.out.print("providerAddress[" + providerAddress + "]");
		System.out.print("providerTel[" + providerTel + "]");
		System.out.println();
		return 0;
	}

	public int process() {
		Provider p = new Provider();
		p.setProviderNumber(providerNumber);
		p.setProviderName(providerName);
		p.setProviderAddress(providerAddress);
		p.setProviderTel(providerTel);
		if (getDatabaseOperator().insertProvider(p) == 0) {
			setTransactionResult("新增供货商成功");
			return 0;
		} else {
			setTransactionResult("新增供货商失败");
			return -1;
		}
	}

	public void printResult() {
		System.out.println(transactionResult);
	}
}

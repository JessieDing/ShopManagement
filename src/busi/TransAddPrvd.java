package busi;

public class TransAddPrvd extends TransAbs {
	String provider_no;// 供货商编号
	String provider_name;// 供货商名称
	String provider_addr;// 供货商地址
	String provider_tel;// 供货商电话

	public void prtPrompt() {
		System.out.println("添加供货商|请输入以下信息：");
		System.out.println("@providerNumber @providerName @providerAddress @providerTel");
	};

	public int getInput() {
		// 读取供货商编号
		provider_no = scan.next();
		if (provider_no == null) {
			setTrans_result("获取供应商编号错误");
			return -1;
		}

		provider_name = scan.next();
		if (provider_name == null) {
			setTrans_result("获取供应商名称错误");
			return -1;
		}

		provider_addr = scan.next();
		if (provider_addr == null) {
			setTrans_result("获取供应商地址错误");
			return -1;
		}

		provider_tel = scan.next();
		if (provider_tel == null) {
			setTrans_result("获取供应商电话错误");
			return -1;
		}

		// 判断供应商编号是否重复
		if (dbhelper.exactFindProvider(provider_no) != null) {
			setTrans_result("供应商编号已存在！");
			return -1;
		}

		DataValidate validator = new DataValidate();
		if (!validator.providerNoValidate(provider_no)) {
			setTrans_result("供应商编号不合法");
			return -1;
		}

		if (!validator.telNoValidate(provider_tel)) {
			setTrans_result("电话号码不合法");
			return -1;
		}

		System.out.print("providerNumber[" + provider_no + "],");
		System.out.print("providerName[" + provider_name + "],");
		System.out.print("providerAddress[" + provider_addr + "]");
		System.out.print("providerTel[" + provider_tel + "]");
		System.out.println();
		return 0;
	}

	public int doTrans() {
		Provider p = new Provider();
		p.setProviderNumber(provider_no);
		p.setProviderName(provider_name);
		p.setProviderAddress(provider_addr);
		p.setProviderTel(provider_tel);
		if (getDbhelper().insertProvider(p) == 0) {
			setTrans_result("新增供货商成功");
			return 0;
		} else {
			setTrans_result("新增供货商失败");
			return -1;
		}
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

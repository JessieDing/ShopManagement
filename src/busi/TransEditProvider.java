package busi;

public class TransEditProvider extends TransAbs {
	String provider_no;// 供货商编号
	String provider_name;// 供货商名称
	String provider_addr;// 供货商地址
	String provider_tel;// 供货商电话
	String provider_status;

	public TransEditProvider() {
		super();

	}

	public TransEditProvider(String provider_no, String provider_name, String provider_addr, String provider_tel) {
		super();
		this.provider_no = provider_no;
		this.provider_name = provider_name;
		this.provider_addr = provider_addr;
		this.provider_tel = provider_tel;
	}

	public void printPrompt() {
		System.out.println("供货商信息修改|请输入已有供货商编号和修改后的信息：");
		System.out.println("@providerNumber @providerName @providerAddress @provider_tels @providerStatus");

	}

	public int getInput() {
		// 供货商编号
		provider_no = scan.next();
		if (provider_no == null) {
			setTrans_result("读取供货商编号错误");
			return -1;
		}

		// 供货商名称
		provider_name = scan.next();
		if (provider_name == null) {
			setTrans_result("读取供货商名称错误");
			return -1;
		}

		// 供货商地址
		provider_addr = scan.next();
		if (provider_addr == null) {
			setTrans_result("读取供货商地址错误");
			return -1;
		}

		// 供货商电话
		provider_tel = scan.next();
		if (provider_tel == null) {
			setTrans_result("读取供货商电话错误");
			return -1;
		}

		// 供货商状态
		provider_status = scan.next();
		if (provider_status == null) {
			setTrans_result("读取供货商状态错误");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		Provider provider = dbhelper.exactFindProvider(provider_no);
		provider.setProviderName(provider_name);
		provider.setProviderAddress(provider_addr);
		provider.setProviderTel(provider_tel);
		provider.setProviderStatus(provider_status);
		setTrans_result("修改成功");

		return 0;
	}

	public void printResult() {
		System.out.println(trans_result);
	}

	public String getProvider_no() {
		return provider_no;
	}

	public void setProvider_no(String provider_no) {
		this.provider_no = provider_no;
	}

	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

	public String getProvider_addr() {
		return provider_addr;
	}

	public void setProvider_addr(String provider_addr) {
		this.provider_addr = provider_addr;
	}

	public String getProvider_tel() {
		return provider_tel;
	}

	public void setProvider_tel(String provider_tel) {
		this.provider_tel = provider_tel;
	}

	public String getProvider_status() {
		return provider_status;
	}

	public void setProvider_status(String provider_status) {
		this.provider_status = provider_status;
	}

}

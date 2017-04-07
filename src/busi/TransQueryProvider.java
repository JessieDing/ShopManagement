package busi;

import java.util.List;

public class TransQueryProvider extends TransAbs {
	String query_type;// 查询方式
	String provider_no;// 供货商编号
	String provider_name;// 供货商名称

	public TransQueryProvider() {
		super();

	}

	public TransQueryProvider(String query_type, String provider_no, String provider_name) {
		super();
		this.query_type = query_type;
		this.provider_no = provider_no;
		this.provider_name = provider_name;
	}

	public void prtPrompt() {
		System.out.println("查询供货商|请输入以下信息：");
		System.out.println("@query_type @provider_no @provider_name");
		System.out.println("query_type：0-全部查询  1-精确查询   2-模糊查询");
	}

	public int getInput() {
		// 读取查询方式
		query_type = scan.next();
		if (query_type == null) {
			setTrans_result("获取查询方式失败");
			return -1;
		} else if (query_type.equals("0")) {// 全部查询不需要读取剩余的参数
			return 0;
		}

		// 供货商编号
		provider_no = scan.next();
		if (provider_no == null) {
			setTrans_result("读取商品编号错误");
			return -1;
		}

		provider_name = scan.next();
		if (provider_name == null) {
			setTrans_result("读取商品名称错误");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		if (query_type.equals("0")) {// 全部查询
			getDbhelper().prtAllProvider();
			setTrans_result("查询完成");
			return 0;
		} else if (query_type.equals("1")) {// 精确查询
			Provider provider = dbhelper.exactFindProvider(provider_no);
			if (provider != null) {
				System.out.println(provider.toString());
				setTrans_result("精确查询完成");
				return 0;
			} else {
				setTrans_result("没有查到相关信息！");
				return -1;
			}
		} else if (query_type.equals("2")) {// 模糊查询（目前只能查一个）

			if (dbhelper.fuzFindProvider(provider_name) != null) {
				List<Provider> list = dbhelper.fuzFindProvider(provider_name);
				for (Provider p : list) {
					System.out.println(p.toString());
				}
				return 0;
			} else {
				setTrans_result("没有查到相关信息！");
				return -1;
			}

		}
		return 0;
	}

	public void prtResult() {
		System.out.println(trans_result);
	}

	public String getQuery_type() {
		return query_type;
	}

	public void setQuery_type(String query_type) {
		this.query_type = query_type;
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

}

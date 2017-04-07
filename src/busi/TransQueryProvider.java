package busi;

import java.util.List;

public class TransQueryProvider extends TransAbs {
	String query_type;// ��ѯ��ʽ
	String provider_no;// �����̱��
	String provider_name;// ����������

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
		System.out.println("��ѯ������|������������Ϣ��");
		System.out.println("@query_type @provider_no @provider_name");
		System.out.println("query_type��0-ȫ����ѯ  1-��ȷ��ѯ   2-ģ����ѯ");
	}

	public int getInput() {
		// ��ȡ��ѯ��ʽ
		query_type = scan.next();
		if (query_type == null) {
			setTrans_result("��ȡ��ѯ��ʽʧ��");
			return -1;
		} else if (query_type.equals("0")) {// ȫ����ѯ����Ҫ��ȡʣ��Ĳ���
			return 0;
		}

		// �����̱��
		provider_no = scan.next();
		if (provider_no == null) {
			setTrans_result("��ȡ��Ʒ��Ŵ���");
			return -1;
		}

		provider_name = scan.next();
		if (provider_name == null) {
			setTrans_result("��ȡ��Ʒ���ƴ���");
			return -1;
		}
		return 0;
	}

	public int doTrans() {
		if (query_type.equals("0")) {// ȫ����ѯ
			getDbhelper().prtAllProvider();
			setTrans_result("��ѯ���");
			return 0;
		} else if (query_type.equals("1")) {// ��ȷ��ѯ
			Provider provider = dbhelper.exactFindProvider(provider_no);
			if (provider != null) {
				System.out.println(provider.toString());
				setTrans_result("��ȷ��ѯ���");
				return 0;
			} else {
				setTrans_result("û�в鵽�����Ϣ��");
				return -1;
			}
		} else if (query_type.equals("2")) {// ģ����ѯ��Ŀǰֻ�ܲ�һ����

			if (dbhelper.fuzFindProvider(provider_name) != null) {
				List<Provider> list = dbhelper.fuzFindProvider(provider_name);
				for (Provider p : list) {
					System.out.println(p.toString());
				}
				return 0;
			} else {
				setTrans_result("û�в鵽�����Ϣ��");
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

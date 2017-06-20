package busi;

public class TransAddPrvd extends TransAbs {
	String provider_no;// �����̱��
	String provider_name;// ����������
	String provider_addr;// �����̵�ַ
	String provider_tel;// �����̵绰

	public void prtPrompt() {
		System.out.println("��ӹ�����|������������Ϣ��");
		System.out.println("@providerNumber @providerName @providerAddress @providerTel");
	};

	public int getInput() {
		// ��ȡ�����̱��
		provider_no = scan.next();
		if (provider_no == null) {
			setTrans_result("��ȡ��Ӧ�̱�Ŵ���");
			return -1;
		}

		provider_name = scan.next();
		if (provider_name == null) {
			setTrans_result("��ȡ��Ӧ�����ƴ���");
			return -1;
		}

		provider_addr = scan.next();
		if (provider_addr == null) {
			setTrans_result("��ȡ��Ӧ�̵�ַ����");
			return -1;
		}

		provider_tel = scan.next();
		if (provider_tel == null) {
			setTrans_result("��ȡ��Ӧ�̵绰����");
			return -1;
		}

		// �жϹ�Ӧ�̱���Ƿ��ظ�
		if (dbhelper.exactFindProvider(provider_no) != null) {
			setTrans_result("��Ӧ�̱���Ѵ��ڣ�");
			return -1;
		}

		DataValidate validator = new DataValidate();
		if (!validator.providerNoValidate(provider_no)) {
			setTrans_result("��Ӧ�̱�Ų��Ϸ�");
			return -1;
		}

		if (!validator.telNoValidate(provider_tel)) {
			setTrans_result("�绰���벻�Ϸ�");
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
			setTrans_result("���������̳ɹ�");
			return 0;
		} else {
			setTrans_result("����������ʧ��");
			return -1;
		}
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

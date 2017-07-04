package business;

public class TransAddPrvd extends TransAbs {
	private String provider_no;// �����̱��
	private String provider_name;// ����������
	private String provider_addr;// �����̵�ַ
	private String provider_tel;// �����̵绰

	public void printPrompt() {
		System.out.println("��ӹ�����|������������Ϣ��");
		System.out.println("@providerNumber @providerName @providerAddress @providerTel");
	};

	public int getInput() {
		// ��ȡ�����̱��
		provider_no = scan.next();
		if (provider_no == null) {
			setTransResult("��ȡ��Ӧ�̱�Ŵ���");
			return -1;
		}

		provider_name = scan.next();
		if (provider_name == null) {
			setTransResult("��ȡ��Ӧ�����ƴ���");
			return -1;
		}

		provider_addr = scan.next();
		if (provider_addr == null) {
			setTransResult("��ȡ��Ӧ�̵�ַ����");
			return -1;
		}

		provider_tel = scan.next();
		if (provider_tel == null) {
			setTransResult("��ȡ��Ӧ�̵绰����");
			return -1;
		}

		// �жϹ�Ӧ�̱���Ƿ��ظ�
		if (databaseOperator.exactFindProvider(provider_no) != null) {
			setTransResult("��Ӧ�̱���Ѵ��ڣ�");
			return -1;
		}

		DataValidate validator = new DataValidate();
		if (!validator.providerNoValidate(provider_no)) {
			setTransResult("��Ӧ�̱�Ų��Ϸ�");
			return -1;
		}

		if (!validator.telNoValidate(provider_tel)) {
			setTransResult("�绰���벻�Ϸ�");
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
		if (getDatabaseOperator().insertProvider(p) == 0) {
			setTransResult("���������̳ɹ�");
			return 0;
		} else {
			setTransResult("����������ʧ��");
			return -1;
		}
	}

	public void printResult() {
		System.out.println(transResult);
	}
}

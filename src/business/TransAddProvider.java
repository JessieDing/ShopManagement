package business;

class TransAddProvider extends TransAbs {
	private String providerNumber;// �����̱��
	private String providerName;// ����������
	private String providerAddress;// �����̵�ַ
	private String providerTel;// �����̵绰

	public void printPrompt() {
		System.out.println("��ӹ�����|������������Ϣ��");
		System.out.println("@providerNumber @providerName @providerAddress @providerTel");
	};

	public int getInput() {
		// ��ȡ�����̱��
		providerNumber = scan.next();
		if (providerNumber == null) {
			setTransResult("��ȡ��Ӧ�̱�Ŵ���");
			return -1;
		}

		providerName = scan.next();
		if (providerName == null) {
			setTransResult("��ȡ��Ӧ�����ƴ���");
			return -1;
		}

		providerAddress = scan.next();
		if (providerAddress == null) {
			setTransResult("��ȡ��Ӧ�̵�ַ����");
			return -1;
		}

		providerTel = scan.next();
		if (providerTel == null) {
			setTransResult("��ȡ��Ӧ�̵绰����");
			return -1;
		}

		// �жϹ�Ӧ�̱���Ƿ��ظ�
		if (databaseOperator.exactFindProvider(providerNumber) != null) {
			setTransResult("��Ӧ�̱���Ѵ��ڣ�");
			return -1;
		}

		DataValidate validator = new DataValidate();
		if (!validator.providerNoValidate(providerNumber)) {
			setTransResult("��Ӧ�̱�Ų��Ϸ�");
			return -1;
		}

		if (!validator.telNoValidate(providerTel)) {
			setTransResult("�绰���벻�Ϸ�");
			return -1;
		}

		System.out.print("providerNumber[" + providerNumber + "],");
		System.out.print("providerName[" + providerName + "],");
		System.out.print("providerAddress[" + providerAddress + "]");
		System.out.print("providerTel[" + providerTel + "]");
		System.out.println();
		return 0;
	}

	public int doTrans() {
		Provider p = new Provider();
		p.setProviderNumber(providerNumber);
		p.setProviderName(providerName);
		p.setProviderAddress(providerAddress);
		p.setProviderTel(providerTel);
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

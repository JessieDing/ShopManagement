package busi;

public class TransAddPrvd extends TransAbs {
	String provider_no;// �����̱��
	String provider_name;// ����������
	String provider_addr;// �����̵�ַ
	String provider_tel;// �����̵绰

	public void prtPrompt() {
		System.out.println("��ӹ�����|������������Ϣ��");
		System.out.println("@provider_no @provider_name @provider_addr @provider_tel");
	};

	public int getInput() {
		// ��ȡ�����̱��
		provider_no = scan.next();
		if (provider_no == null) {
			setTrans_result("��ȡ��Ӧ�̱�Ŵ���");
			return -1;
		}

		if (provider_name == null) {
			setTrans_result("��ȡ��Ӧ�����ƴ���");
			return -1;
		}

		if (provider_addr == null) {
			setTrans_result("��ȡ��Ӧ�̵�ַ����");
			return -1;
		}

		if (provider_tel == null) {
			setTrans_result("��ȡ��Ӧ�̵绰����");
			return -1;
		}

		System.out.print("provider_no[" + provider_no + "],");
		System.out.print("provider_name[" + provider_name + "],");
		System.out.print("provider_addr[" + provider_addr + "]");
		System.out.print("provider_tel[" + provider_tel + "]");
		System.out.println();
		return 0;
	}

	public int doTrans() {
		Provider p = new Provider();
		p.setProvider_no(provider_no);
		p.setProvider_name(provider_name);
		p.setProvider_addr(provider_addr);
		p.setProvider_tel(provider_tel);
		if (getProviderDBOper().insertProvider(p) == 0) {
			setTrans_result("������Ʒ�ɹ�");
			return 0;
		} else {
			setTrans_result("������Ʒʧ��");
			return -1;
		}
	}

	public void prtResult() {
		System.out.println(trans_result);
	}
}

package busi;

public class TransAddPrvd extends TransAbs {
	String prvd_no;// �����̱��
	String prvd_name;// ����������
	String prvd_addr;// �����̵�ַ
	String prvd_tel;// �����̵绰

	public void prtPrompt() {
		System.out.println("��ӹ�����|������������Ϣ��");
		System.out.println("@prvd_no @prvd_name @prvd_addr @prvd_tel");
	};

	public int getInput() {
		// ��ȡ�����̱��
		prvd_no = scan.next();
		if (prvd_no == null) {
			setTrans_result("��ȡ��Ӧ�̱�Ŵ���");
			return -1;
		}

		if (prvd_name == null) {
			setTrans_result("��ȡ��Ӧ�����ƴ���");
			return -1;
		}

		if (prvd_addr == null) {
			setTrans_result("��ȡ��Ӧ�̵�ַ����");
			return -1;
		}

		if (prvd_tel == null) {
			setTrans_result("��ȡ��Ӧ�̵绰����");
			return -1;
		}

		System.out.print("prvd_no[" + prvd_no + "],");
		System.out.print("prvd_name[" + prvd_name + "],");
		System.out.print("prvd_addr[" + prvd_addr + "]");
		System.out.print("prvd_tel[" + prvd_tel + "]");
		System.out.println();
		return 0;
	}

	public int doTrans() {
		Provider p = new Provider();// ����������DBOper����Ҫ�ٽ�һ��<provider>������

		return 0;
	};

	public void prtResult() {
	};
}

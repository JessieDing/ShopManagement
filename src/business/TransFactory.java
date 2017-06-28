package business;

public class TransFactory {

    public TransInterface createTrans(String strTrans) {
        TransInterface trans = null;
        switch (strTrans) {
            case "1": // �����Ʒ��Ϣ����
                trans = new TransAddGoods();
                break;
            case "2": // �޸���Ʒ��Ϣ
                trans = new TransEditGoods();
                break;
            case "3": // ��ѯ��Ʒ
                trans = new TransQueryGoods();
                break;
            case "4": // ����������
                trans = new TransAddPrvd();
                break;
            case "5": // �޸Ĺ�����
                trans = new TransEditProvider();
                break;
            case "6": // ��ѯ������
                trans = new TransQueryProvider();
                break;
            case "7":
                trans = new TransAddPurchase();// �ɹ���Ϣ¼��
                break;
            case "8":
                trans = new TransAddSale();// ������Ϣ¼��
                break;
            case "9":
                trans = new TransQueryInventory();// ��ѯ�����Ϣ
                break;
            case "0":
                trans = new TransPrintSalesReport();// ��ӡ���۱���
                break;
        }
        return trans;
    }
}

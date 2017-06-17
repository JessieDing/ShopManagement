package busi;

import java.util.Date;

public class DataValidate {

    public boolean isQualify(Date saleDate, Date qualityDate) {


        if (qualityDate.before(saleDate)) {
            return true;
        }


        return false;
    }

    public boolean goodNoValidate(String goodNo) {
        if (goodNo.length() != 8) {
            // System.out.println("��Ʒ��Ų��Ϸ�");
            return false;
        }
        return true;
    }

    public boolean goodsStatusValidate(String strStatus) {
        if ((!strStatus.equals("0") && (!strStatus.equals("1")))) {
            // System.out.println("״̬���벻�Ϸ�");
            return false;
        }
        return true;
    }

    public boolean providerNoValidate(String providerNo) {
        if (providerNo.length() != 4) {
            // System.out.println("��Ӧ�̱�Ų��Ϸ�");
            return false;
        }
        return true;
    }

    public boolean telNoValidate(String telNo) {
        //�ж��Ƿ��ֻ��ţ��Լ�����Ŷ��Ƿ���ڣ��Լ��������Ƿ�Ϸ�
        boolean isValid = telNo.matches("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}|(((0\\d{2})?-\\d{8})|((0\\d{3})?-\\d{7}))$");
        if (!isValid) {
            // System.out.println("�绰���벻�Ϸ�");
            return false;
        }
//        char[] tmp = telNo.toCharArray();
//        for (char c : tmp) {
//            if ((c > '9' || c < '0') && c != '-') {
//                // System.out.println("�绰���벻�Ϸ�");
//                return false;
//            }
//        }
        else

            return true;
    }
}

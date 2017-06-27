package busi;

import java.util.Date;

class DataValidate {

    public boolean isQualify(Date saleDate, Date qualityDate) {
        return qualityDate.before(saleDate);
    }

    boolean goodsNumberValidate(String goodsNumber) {
        return goodsNumber.length() == 8;
    }

    boolean goodsStatusValidate(String strStatus) {
        return !(!strStatus.equals("0") && (!strStatus.equals("1")));
    }

    boolean providerNoValidate(String providerNo) {
        return providerNo.length() == 4;
    }

    boolean telNoValidate(String telNo) {
        //�ж��Ƿ��ֻ��ţ��Լ�����Ŷ��Ƿ���ڣ��Լ��������Ƿ�Ϸ�
        return telNo.matches("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}|(((0\\d{2})?-\\d{8})|((0\\d{3})?-\\d{7}))$");
    }
}

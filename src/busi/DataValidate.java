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
        //判断是否手机号，以及号码号段是否存在；以及座机号是否合法
        return telNo.matches("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}|(((0\\d{2})?-\\d{8})|((0\\d{3})?-\\d{7}))$");
    }
}

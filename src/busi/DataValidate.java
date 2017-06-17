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
            // System.out.println("商品编号不合法");
            return false;
        }
        return true;
    }

    public boolean goodsStatusValidate(String strStatus) {
        if ((!strStatus.equals("0") && (!strStatus.equals("1")))) {
            // System.out.println("状态输入不合法");
            return false;
        }
        return true;
    }

    public boolean providerNoValidate(String providerNo) {
        if (providerNo.length() != 4) {
            // System.out.println("供应商编号不合法");
            return false;
        }
        return true;
    }

    public boolean telNoValidate(String telNo) {
        //判断是否手机号，以及号码号段是否存在；以及座机号是否合法
        boolean isValid = telNo.matches("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}|(((0\\d{2})?-\\d{8})|((0\\d{3})?-\\d{7}))$");
        if (!isValid) {
            // System.out.println("电话号码不合法");
            return false;
        }
//        char[] tmp = telNo.toCharArray();
//        for (char c : tmp) {
//            if ((c > '9' || c < '0') && c != '-') {
//                // System.out.println("电话号码不合法");
//                return false;
//            }
//        }
        else

            return true;
    }
}

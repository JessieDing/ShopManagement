package busi;

public class DataValidate {

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
		if (telNo.length() > 12) {
			// System.out.println("电话号码不合法");
			return false;
		}
		char[] tmp = telNo.toCharArray();
		for (char c : tmp) {
			if ((c > '9' || c < '0') && c != '-') {
				// System.out.println("电话号码不合法");
				return false;
			}
		}

		return true;
	}

}

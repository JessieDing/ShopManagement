package business;

public class Provider {
    private String providerNumber;// 供货商编号
    private String providerName;// 供货商名称
    private String providerAddress;// 供货商地址
    private String providerTel;// 供货商电话
    private String providerStatus;// 状态

    Provider() {
    }

    public Provider(String providerNumber, String providerName, String providerAddress, String providerTel,
                    String providerStatus) {
        this.providerNumber = providerNumber;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerTel = providerTel;
        this.providerStatus = providerStatus;
    }

    public String getProviderNumber() {
        return providerNumber;
    }

    public void setProviderNumber(String providerNumber) {
        this.providerNumber = providerNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderTel() {
        return providerTel;
    }

    public void setProviderTel(String providerTel) {
        this.providerTel = providerTel;
    }

    public String getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(String providerStatus) {
        this.providerStatus = providerStatus;
    }

    @Override
    public String toString() {
        return "Provider [providerNumber=" + providerNumber + ", providerName=" + providerName + ", providerAddress="
                + providerAddress + ", providerTel=" + providerTel + ", providerStatus=" + providerStatus + "]";
    }
}

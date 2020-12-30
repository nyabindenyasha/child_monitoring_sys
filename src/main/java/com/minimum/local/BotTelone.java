package com.minimum.local;

public class BotTelone {

    private String broadband_provider;

    private String request_location;

    private int recharge_product;

    private String recharge_account;

    private String mobile_money_number;

    public String getBroadband_provider() {
        return broadband_provider;
    }

    public void setBroadband_provider(String broadband_provider) {
        this.broadband_provider = broadband_provider;
    }

    public String getRequest_location() {
        return request_location;
    }

    public void setRequest_location(String request_location) {
        this.request_location = request_location;
    }

    public int getRecharge_product() {
        return recharge_product;
    }

    public void setRecharge_product(int recharge_product) {
        this.recharge_product = recharge_product;
    }

    public String getRecharge_account() {
        return recharge_account;
    }

    public void setRecharge_account(String recharge_account) {
        this.recharge_account = recharge_account;
    }

    public String getMobile_money_number() {
        return mobile_money_number;
    }

    public void setMobile_money_number(String mobile_money_number) {
        this.mobile_money_number = mobile_money_number;
    }

    @Override
    public String toString() {
        return "BotTelone{" +
                "broadband_provider='" + broadband_provider + '\'' +
                ", request_location='" + request_location + '\'' +
                ", recharge_product=" + recharge_product +
                ", recharge_account='" + recharge_account + '\'' +
                ", mobile_money_number='" + mobile_money_number + '\'' +
                '}';
    }
}

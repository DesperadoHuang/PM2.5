package com.main.pm25;

/**
 * Created by WilsonHuang on 2016/1/15.
 */
public class PM25Item {
    private String siteName;
    private String country;
    private int PMvalue;
    private String publishTime;

    public PM25Item() {
    }

    public PM25Item(String observatoryName, String country, int PMvalue, String releaseTime) {
        this.siteName = observatoryName;
        this.country = country;
        this.PMvalue = PMvalue;
        this.publishTime = releaseTime;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPMvalue() {
        return PMvalue;
    }

    public void setPMvalue(int PMvalue) {
        this.PMvalue = PMvalue;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}

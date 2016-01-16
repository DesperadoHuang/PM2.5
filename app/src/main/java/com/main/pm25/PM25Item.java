package com.main.pm25;

/**
 * Created by WilsonHuang on 2016/1/15.
 */
public class PM25Item {
    private String siteName;
    private String county;
    private String PMvalue;
    private String publishTime;

    public PM25Item() {
    }

    public PM25Item(String siteName, String county, String PMvalue, String publishTime) {
        this.siteName = siteName;
        this.county = county;
        this.PMvalue = PMvalue;
        this.publishTime = publishTime;
    }


    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPMvalue() {
        return PMvalue;
    }

    public void setPMvalue(String PMvalue) {
        this.PMvalue = PMvalue;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}

package com.main.pm25;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by WilsonHuang on 2016/1/15.
 */
public class Helper {
    public static final String PM25URL = " http://opendata.epa.gov.tw/ws/Data/REWXQA/" +
            "?$select=SiteName,County,PM2.5,PublishTime&$orderby=SiteName&$skip=0&$top=1000&format=json&sort=County";


    public static String getJsonString(String urlString) throws Exception {
        InputStream is = null;
        Reader reader = null;
        StringBuilder str = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection URLConn = url.openConnection();
        URLConn.setRequestProperty("User-agent", "IE/6.0");
        is = URLConn.getInputStream();
        reader = new InputStreamReader(is, "UTF-8");
        char[] buffer = new char[1];
        while (reader.read(buffer) != -1) {
            str.append(new String(buffer));
        }
        return str.toString();
    }

    public static ArrayList<PM25Item> getPm25Items(String jsonString) {
        ArrayList<PM25Item> pm25Items = new ArrayList<PM25Item>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            Log.i("debug", jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String siteName = jsonObject.optString("SiteName");
                String county = jsonObject.optString("County");
                String pm25value = jsonObject.optString("PM2.5").equals("")
                        ? String.valueOf(0) : jsonObject.optString("PM2.5");
                String publishTime = jsonObject.optString("PublishTime");

                pm25Items.add(new PM25Item(
                        siteName,
                        county,
                        pm25value,
                        publishTime));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pm25Items;
    }


}

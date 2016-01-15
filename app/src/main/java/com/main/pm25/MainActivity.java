package com.main.pm25;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private Context context;
    private ListView listView;

    private ArrayList<PM25Item> itemList;
    private PM25ItemAdapter pm25ItemAdapter;

    public static final String PM25URL = "http://opendata.epa.gov.tw/ws/Data/REWXQA/" +
            "?$select=SiteName,County,PM2.5,PublishTime&$orderby=SiteName&$skip=0&$top=1000&format=json&sort=County";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = (ListView) findViewById(R.id.data_ListView);

        PM25Item pm25Item1 = new PM25Item("第一站", "台北", 1, "AAA");
        PM25Item pm25Item2 = new PM25Item("第二站", "台中", 2, "BBB");
        PM25Item pm25Item3 = new PM25Item("第三站", "高雄", 3, "CCC");

        itemList = new ArrayList<PM25Item>();
        itemList.add(pm25Item1);
        itemList.add(pm25Item2);
        itemList.add(pm25Item3);

        pm25ItemAdapter = new PM25ItemAdapter(context, itemList);

        listView.setAdapter(pm25ItemAdapter);


    }


}

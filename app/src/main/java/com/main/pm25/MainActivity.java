package com.main.pm25;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = (ListView) findViewById(R.id.data_ListView);

        new MyAsyncTask().execute();
    }

    private class MyAsyncTask extends AsyncTask<Void, Integer, String> {
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {
            String jsonString = null;
            try {
                jsonString = Helper.getJsonString(Helper.PM25URL);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonString;
        }

        @Override
        protected void onPostExecute(String jsonString) {
            ArrayList<PM25Item> itemList = Helper.getPm25Items(jsonString);
            PM25ItemAdapter pm25ItemAdapter = new PM25ItemAdapter(context, itemList);
            listView.setAdapter(pm25ItemAdapter);
            super.onPostExecute(jsonString);
        }
    }
}

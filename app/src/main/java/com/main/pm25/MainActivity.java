package com.main.pm25;

import android.app.ProgressDialog;
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
        private ProgressDialog dialog;

        @Override

        protected void onProgressUpdate(Integer... values) {
            Helper.myLog("onProgressUpdate");

            super.onProgressUpdate(values);
        }

        //執行內容
        @Override
        protected String doInBackground(Void... params) {
            Helper.myLog("doInBackground");

            String jsonString = null;
            try {
                jsonString = Helper.getJsonString(Helper.PM25URL);
            } catch (Exception e) {
                Helper.myLog(e.toString());
                dialog.dismiss();
            }
            return jsonString;
        }

        //執行結束
        @Override
        protected void onPostExecute(String jsonString) {
            Helper.myLog("onPostExecute");

            ArrayList<PM25Item> itemList = Helper.getPm25Items(jsonString);
            PM25ItemAdapter pm25ItemAdapter = new PM25ItemAdapter(context, itemList);
            listView.setAdapter(pm25ItemAdapter);

            dialog.dismiss();
            super.onPostExecute(jsonString);
        }

        //事前準備
        @Override
        protected void onPreExecute() {
            Helper.myLog("onPreExecute");

            dialog = new ProgressDialog(context);
            dialog.setCancelable(false);
            dialog.setMessage(context.getResources().getString(R.string.updating));
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onCancelled(String s) {
            Helper.myLog("onCancelled");

            super.onCancelled(s);
        }

        @Override
        protected void onCancelled() {
            Helper.myLog("onCancelled");

            super.onCancelled();
        }
    }
}

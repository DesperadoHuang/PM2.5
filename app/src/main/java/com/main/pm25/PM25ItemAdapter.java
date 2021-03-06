package com.main.pm25;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WilsonHuang on 2016/1/15.
 */
public class PM25ItemAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<PM25Item> arrayList;
    private Context context;

    static class ViewHolder {
        TextView siteName;
        TextView country;
        TextView PMvalue;
        TextView publishTime;
    }

    public PM25ItemAdapter(Context context, ArrayList<PM25Item> arrayList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.siteName = (TextView) convertView.findViewById(R.id.text_stationName);
            holder.country = (TextView) convertView.findViewById(R.id.text_country);
            holder.PMvalue = (TextView) convertView.findViewById(R.id.text_PM_value);
            holder.publishTime = (TextView) convertView.findViewById(R.id.text_release_time);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        PM25Item item = arrayList.get(position);

        holder.siteName.setText(item.getSiteName());
        holder.siteName.setBackgroundResource(R.drawable.frame_line);
        holder.country.setText(item.getCounty());
        holder.country.setBackgroundResource(R.drawable.frame_line);
        holder.PMvalue.setText(item.getPMvalue());
        holder.PMvalue.setBackgroundResource(R.drawable.frame_line);
        holder.publishTime.setText(item.getPublishTime());
        holder.publishTime.setBackgroundResource(R.drawable.frame_line);

        int pm25Value = Integer.parseInt(item.getPMvalue());
        if (pm25Value == 0) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.pm25_0));
            holder.siteName.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.country.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.PMvalue.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.PMvalue.setText("維護中");
            holder.publishTime.setTextColor(ContextCompat.getColor(context, R.color.text_black));
        } else if (pm25Value > 0 && pm25Value <= 35) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.pm25_1to35));
            holder.siteName.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.country.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.PMvalue.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.publishTime.setTextColor(ContextCompat.getColor(context, R.color.text_black));
        } else if (pm25Value > 35 && pm25Value <= 53) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.pm25_36to53));
            holder.siteName.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.country.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.PMvalue.setTextColor(ContextCompat.getColor(context, R.color.text_black));
            holder.publishTime.setTextColor(ContextCompat.getColor(context, R.color.text_black));
        } else if (pm25Value > 53 && pm25Value <= 70) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.pm25_54to70));
            holder.siteName.setTextColor(ContextCompat.getColor(context, R.color.text_white));
            holder.country.setTextColor(ContextCompat.getColor(context, R.color.text_white));
            holder.PMvalue.setTextColor(ContextCompat.getColor(context, R.color.text_white));
            holder.publishTime.setTextColor(ContextCompat.getColor(context, R.color.text_white));
        } else if (pm25Value > 70) {
            convertView.setBackgroundColor(ContextCompat.getColor(context, R.color.pm25_70up));
            holder.siteName.setTextColor(ContextCompat.getColor(context, R.color.text_white));
            holder.country.setTextColor(ContextCompat.getColor(context, R.color.text_white));
            holder.PMvalue.setTextColor(ContextCompat.getColor(context, R.color.text_white));
            holder.publishTime.setTextColor(ContextCompat.getColor(context, R.color.text_white));
        }
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }


}

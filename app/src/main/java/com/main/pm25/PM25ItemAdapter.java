package com.main.pm25;

import android.content.Context;
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
        int pm25Value = item.getPMvalue();
        holder.siteName.setText(item.getSiteName());
        holder.siteName.setBackgroundResource(R.drawable.frame_line);
        holder.country.setText(item.getCountry());
        holder.country.setBackgroundResource(R.drawable.frame_line);
        holder.PMvalue.setText(String.valueOf(pm25Value));
        holder.PMvalue.setBackgroundResource(R.drawable.frame_line);
        holder.publishTime.setText(item.getPublishTime());
        holder.publishTime.setBackgroundResource(R.drawable.frame_line);

        if (pm25Value == 1) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.pm25_1to35));
            holder.siteName.setTextColor(context.getResources().getColor(R.color.text_black));
            holder.country.setTextColor(context.getResources().getColor(R.color.text_black));
            holder.PMvalue.setTextColor(context.getResources().getColor(R.color.text_black));
            holder.publishTime.setTextColor(context.getResources().getColor(R.color.text_black));
        } else if (pm25Value == 2) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.pm25_36to53));
            holder.siteName.setTextColor(context.getResources().getColor(R.color.text_black));
            holder.country.setTextColor(context.getResources().getColor(R.color.text_black));
            holder.PMvalue.setTextColor(context.getResources().getColor(R.color.text_black));
            holder.publishTime.setTextColor(context.getResources().getColor(R.color.text_black));
        } else if (pm25Value == 3) {
            convertView.setBackgroundColor(context.getResources().getColor(R.color.pm25_54to70));
            holder.siteName.setTextColor(context.getResources().getColor(R.color.text_white));
            holder.country.setTextColor(context.getResources().getColor(R.color.text_white));
            holder.PMvalue.setTextColor(context.getResources().getColor(R.color.text_white));
            holder.publishTime.setTextColor(context.getResources().getColor(R.color.text_white));
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

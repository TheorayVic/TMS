package com.yf.bx.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yf.bx.tms.R;

import java.util.List;

/**
 * Created by 123 on 2016/11/9.
 */

public class GzzdAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public GzzdAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_gzzd_item,null);
          //  holder.tv_date = (TextView) convertView.findViewById(R.id.tv_gzzd_item_date);
         //   holder.tv_title = (TextView) convertView.findViewById(R.id.tv_gzzd_item_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder{
        TextView tv_title,tv_date;
    }
}

package com.yf.bx.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by 123 on 2016/10/25.
 */

public class MainAdapter extends BaseAdapter {
    private Context context;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_main_item, parent, false);
            holder.num = (TextView) convertView.findViewById(R.id.tv_main_item_num);
            holder.type = (TextView) convertView.findViewById(R.id.tv_main_item_type);
            holder.date = (TextView) convertView.findViewById(R.id.tv_main_item_date);
            holder.title = (TextView) convertView.findViewById(R.id.tv_main_item_title);
            convertView.setTag(holder);
            //对于listview，注意添加这一行，即可在item上使用高度
            AutoUtils.autoSize(convertView);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;

    }

    class ViewHolder{
        TextView num,type,date,title;
    }
}

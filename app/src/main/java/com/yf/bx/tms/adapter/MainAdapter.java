package com.yf.bx.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.bean.MainBean;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by 123 on 2016/10/25.
 */

public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public MainAdapter(Context context, List<String> list) {
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

        holder.num.setText(position+1+"");
        holder.type.setText(list.get(position));
        return convertView;

    }

    class ViewHolder{
        TextView num,type,date,title;
    }
}

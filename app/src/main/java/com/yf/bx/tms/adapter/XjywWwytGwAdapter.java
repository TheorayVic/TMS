package com.yf.bx.tms.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yf.bx.tms.R;

import java.util.List;

/**
 * Created by 123 on 2016/11/10.
 */

public class XjywWwytGwAdapter extends BaseAdapter {
    private final static String TAG = "XjywWwytGwAdapter";
    private Context context;
    private String [][] strings;

    public XjywWwytGwAdapter(Context context, String [][] strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        Log.i(TAG, "getCount: strings.length:"+strings.length);
        return strings[0].length;
    }

    @Override
    public Object getItem(int position) {
        Log.i(TAG, "getItem: strings[position]:"+strings[position].toString());
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_xjyw_wwyt_gw,null);
            holder.tv_left = (TextView) convertView.findViewById(R.id.tv_wwyt_gw_left);
            holder.tv_right = (TextView) convertView.findViewById(R.id.tv_wwyt_gw_right);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_left.setText(strings[0][position]);
        holder.tv_right.setText(strings[1][position]);
        return convertView;
    }

    class ViewHolder{
        TextView tv_left,tv_right;
    }
}

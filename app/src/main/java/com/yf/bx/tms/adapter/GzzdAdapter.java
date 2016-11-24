package com.yf.bx.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.bean.GzzdBean;
import com.yf.bx.tms.customview.CustomRoundProcessbar;

import java.util.List;

/**
 * Created by 123 on 2016/11/9.
 */

public class GzzdAdapter extends BaseAdapter {

    private Context context;
    public List<GzzdBean> list;
    private  int progress = 0;
    public GzzdAdapter(Context context, List<GzzdBean> list) {
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
        ViewHolderGzzd holder = null;
        if (convertView==null){
            holder = new ViewHolderGzzd();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_gzzd_item,parent,false);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_gzzd_item_date);
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_gzzd_item_title);

            holder.bar = (CustomRoundProcessbar) convertView.findViewById(R.id.roundProgressBar);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolderGzzd) convertView.getTag();
        }
        holder.tv_title.setText(list.get(position).getFileName());
        return convertView;
    }

    public class ViewHolderGzzd{
        TextView tv_title,tv_date;
        public CustomRoundProcessbar bar;
    }
}

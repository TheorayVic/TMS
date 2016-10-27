package com.yf.bx.tms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.GdpsAddPeopleActivity;
import com.yf.bx.tms.activity.XxbgActivity;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 123 on 2016/10/27.
 */

public class GdpsAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public GdpsAdapter(Context context, List<String> list) {
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
        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_gdps_item,null);
            holder.tv_num = (TextView) convertView.findViewById(R.id.tv_gdps_item_num);
            holder.tv_gdbh = (TextView) convertView.findViewById(R.id.tv_gdps_item_gdbh);
            holder.tv_jjcd = (TextView) convertView.findViewById(R.id.tv_gdps_item_jjcd);
            holder.tv_wtlx = (TextView) convertView.findViewById(R.id.tv_gdps_item_wtlx);
            holder.tv_wtms = (TextView) convertView.findViewById(R.id.tv_gdps_item_wtms);
            holder.tv_fsdd = (TextView) convertView.findViewById(R.id.tv_gdps_item_fsdd);
            holder.tv_lxr = (TextView) convertView.findViewById(R.id.tv_gdps_item_lxr);
            holder.tv_lqgd = (TextView) convertView.findViewById(R.id.tv_gdps_item_lqgd);
            holder.tv_psgd = (TextView) convertView.findViewById(R.id.tv_gdps_item_psgd);
            holder.ll_gdps_cl = (LinearLayout) convertView.findViewById(R.id.ll_gdps_item_cl);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_gdbh.setText(list.get(position));
        //点击派送工单，成功后显示派送成功，然后才能点击领取工单，领取工单后，
        // 整个ll变成“处理中”，背景变绿色

        boolean isPsgd = false;
        holder.tv_psgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GdpsAddPeopleActivity.class);
                ((XxbgActivity)context).startActivityForResult(intent,100);
            }
        });

        return convertView;
    }

    class ViewHolder{
        TextView tv_num,tv_gdbh,tv_jjcd,tv_wtlx,tv_wtms,tv_fsdd,tv_lxr,tv_lqgd,tv_psgd;
        LinearLayout ll_gdps_cl;
    }


}

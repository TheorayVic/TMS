package com.yf.bx.tms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ScrollingView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.GdpsAddPeopleActivity;
import com.yf.bx.tms.activity.XxbgActivity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 123 on 2016/10/27.
 */

public class GdpsAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private String[][] strings;

    public GdpsAdapter(Context context, String[][] strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
    //    return list.size();
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
      //  return list.get(position);
        return strings[position];
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
            //对于listview，注意添加这一行，即可在item上使用高度
            AutoUtils.autoSize(convertView);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_gdbh.setText(strings[position][0]);
        holder.tv_jjcd.setText(strings[position][1]);
        holder.tv_wtlx.setText(strings[position][2]);
        holder.tv_wtms.setText(strings[position][3]);
        holder.tv_fsdd.setText(strings[position][4]);
        holder.tv_lxr.setText(strings[position][5]);

        holder.tv_num.setText(position+1+"");
        //点击派送工单，成功后显示派送成功，然后才能点击领取工单，领取工单后，
        // 整个ll变成“处理中”，背景变绿色
        final boolean[] isPs = {false};
        //true 代表派送成功
        if (isPs[0]){
            holder.tv_psgd.setText("派送成功");
        }
        final ViewHolder finalHolder = holder;
        holder.tv_psgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPs[0]){
                    isPs[0] = true;
                Intent intent = new Intent(context, GdpsAddPeopleActivity.class);
                ((XxbgActivity)context).startActivityForResult(intent,100);
                    finalHolder.tv_psgd.setText("派送成功");}
            }
        });
        final boolean[] isLq = {false};
        holder.tv_lqgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLq[0]) {
                    isLq[0] = true;
                    Toast.makeText(context, "领取成功", Toast.LENGTH_SHORT).show();
                    finalHolder.tv_psgd.setText("");
                    finalHolder.tv_psgd.setBackgroundColor(Color.TRANSPARENT);
                    finalHolder.tv_lqgd.setText("");
                    finalHolder.tv_lqgd.setBackgroundColor(Color.TRANSPARENT);
                    finalHolder.ll_gdps_cl.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.gdps_clz));

                }
            }
        });

      //问题描述栏滚动
        holder.tv_wtms.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                    v.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                }
                return false;
            }
        });
        holder.tv_wtms.setMovementMethod(ScrollingMovementMethod.getInstance());

        return convertView;
    }


    class ViewHolder{
        TextView tv_num,tv_gdbh,tv_jjcd,tv_wtlx,tv_wtms,tv_fsdd,tv_lxr,tv_lqgd,tv_psgd;
        LinearLayout ll_gdps_cl;
    }


}

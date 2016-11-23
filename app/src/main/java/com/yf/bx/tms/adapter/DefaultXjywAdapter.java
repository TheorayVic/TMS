package com.yf.bx.tms.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.KsxjActivity;
import com.yf.bx.tms.activity.XjywCkActivity;

import java.util.List;

/**
 * Created by 123 on 2016/11/7.
 */

public class DefaultXjywAdapter extends BaseAdapter implements View.OnClickListener{

    private final static String TAG = "DefaultXjywAdapter";
    private Context context;
    private List<List<String>> list;
    private String isEnd ;//是否结束巡检
    private int mark;//标记位
    public DefaultXjywAdapter(Context context, List<List<String>> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder holder = null;
        if (convertView==null){
        holder = new MyViewHolder();
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_xjyw_default_item,null);
            holder.tv_xjdw = (TextView) convertView.findViewById(R.id.tv_xjyw_item_xjdw);
            holder.tv_txz = (TextView) convertView.findViewById(R.id.tv_xjyw_item_txz);
            holder.tv_jcsj = (TextView) convertView.findViewById(R.id.tv_xjyw_item_jcsj);
            holder.tv_jcfzr = (TextView) convertView.findViewById(R.id.tv_xjyw_item_jcfzr);
            holder.tv_zt = (TextView) convertView.findViewById(R.id.tv_xjyw_item_zt);
            holder.tv_xjlx = (TextView) convertView.findViewById(R.id.tv_xjyw_item_xjlx);
            holder.ll_xjyw_item = (LinearLayout) convertView.findViewById(R.id.ll_xjyw_item_cz);
            holder.tv_ck = (TextView) convertView.findViewById(R.id.xjyw_item_ck);
            holder.tv_edit = (TextView) convertView.findViewById(R.id.xjyw_item_edit);
            holder. tv_jsxj = (TextView) convertView.findViewById(R.id.xjyw_item_jsxj);
            convertView.setTag(holder);
        }else{
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.tv_ck.setOnClickListener(this);
        holder.tv_jsxj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"巡检结束",Toast.LENGTH_SHORT).show();
                list.get(position).remove(5);
                list.get(position).add("0");
                notifyDataSetChanged();
            }
        });
        holder.tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("1".equals(list.get(position).get(5))){
                    Intent intent_edit = new Intent(context, KsxjActivity.class);
                    context.startActivity(intent_edit);
                }else{
                    Toast.makeText(context,"已经结束巡检，不可编辑",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }


    class MyViewHolder {
        TextView tv_xjdw,tv_txz,tv_jcsj,tv_jcfzr,tv_zt,tv_xjlx,tv_ck,tv_edit,tv_jsxj;
        LinearLayout ll_xjyw_item;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.xjyw_item_ck:
                Intent intent_ck = new Intent(context, XjywCkActivity.class);
                context.startActivity(intent_ck);
                break;
//            case R.id.xjyw_item_edit:
//                //带数据进入
//                Intent intent_edit = new Intent(context, KsxjActivity.class);
//                context.startActivity(intent_edit);
//                break;
//            case R.id.xjyw_item_jsxj:
//                break;
        };
    }

    }

package com.yf.bx.tms.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.yf.bx.tms.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 123 on 2016/10/26.
 */

public class GdtbAdapter extends BaseAdapter {

    private final static String TAG = "GdtbAdapter";
    private List<String> list;
    private Context context;

    private Map<Integer,Boolean> map;

    public GdtbAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
        map = new HashMap<>();
    }

    public  Map<Integer,Boolean> getMap(){
        return map;
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
        ViewHolder holder = null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_gdtb_item,null);
            holder.cb_gdtb = (CheckBox) convertView.findViewById(R.id.cb_gdtb_item);
            holder.tv_lxr = (TextView) convertView.findViewById(R.id.tv_gdtb_item_lxr);
            holder.tv_lxdh = (TextView) convertView.findViewById(R.id.tv_gdtb_item_lxdh);
            holder.tv_fsdd = (TextView) convertView.findViewById(R.id.tv_gdtb_item_fsdd);
            holder.tv_gdzt = (TextView) convertView.findViewById(R.id.tv_gdtb_item_gdzt);
            holder.tv_jjcd = (TextView) convertView.findViewById(R.id.tv_gdtb_item_jjcd);
            holder.tv_wtbt = (TextView) convertView.findViewById(R.id.tv_gdtb_item_wtbt);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.cb_gdtb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                map.put(position,b);
                Log.i(TAG, "onCheckedChanged: list:"+list.toString());
            }
        });
        if (null!=map.get(position)){
        holder.cb_gdtb.setChecked(map.get(position));}
        return convertView;
    }

    public void initCheckbox(boolean flag){
        for (int i = 0;i<list.size();i++){
            map.put(i,flag);
        }
    }

    class ViewHolder{
      CheckBox cb_gdtb;
      TextView tv_wtbt,tv_lxr,tv_lxdh,tv_fsdd,tv_gdzt,tv_jjcd;
    }
}

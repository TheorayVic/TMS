package com.yf.bx.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.bean.FxwtBean;

import java.util.List;

/**
 * Created by 123 on 2016/11/8.
 */

public class FxwtAdapter extends BaseAdapter {

    private Context context;
    private List<FxwtBean> list;

    public FxwtAdapter(Context context, List<FxwtBean> list) {
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
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_fxwt_item,null);
            holder.tv_jcfzr = (TextView) convertView.findViewById(R.id.tv_fxwt_item_jcfzr);
            holder.tv_xjdw = (TextView) convertView.findViewById(R.id.tv_fxwt_item_xjdw);
            holder.tv_txz = (TextView) convertView.findViewById(R.id.tv_fxwt_item_txz);
            holder.tv_jcsj = (TextView) convertView.findViewById(R.id.tv_fxwt_item_jcsj);
            holder.tv_jcxm = (TextView) convertView.findViewById(R.id.tv_fxwt_item_jcxm);
            holder.tv_ycyy = (TextView) convertView.findViewById(R.id.tv_fxwt_item_ycyy);
            holder.tv_sfyxq = (TextView) convertView.findViewById(R.id.tv_fxwt_item_sfyxq);
            holder.tv_cz = (TextView) convertView.findViewById(R.id.tv_fxwt_item_cz);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        FxwtBean fxwtBean = list.get(position);
        holder.tv_jcfzr.setText(fxwtBean.getJcfzr());
        holder.tv_xjdw.setText(fxwtBean.getXjdw());
        holder.tv_txz.setText(fxwtBean.getTxz());
        holder.tv_jcsj.setText(fxwtBean.getJxsj());
        holder.tv_jcxm.setText(fxwtBean.getJcxm());
        holder.tv_ycyy.setText(fxwtBean.getYcyy());
        holder.tv_sfyxq.setText(fxwtBean.getIsyxq());
        holder.tv_cz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"已经消缺",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    class ViewHolder{
        TextView tv_xjdw,tv_txz,tv_jcsj,tv_jcfzr,tv_jcxm,tv_ycyy,tv_sfyxq,tv_cz;
    }
}

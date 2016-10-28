package com.yf.bx.tms.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.yf.bx.tms.R;

import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2016/10/28.
 */

public class WwytExpandlistviewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> list_head;
    private Map<Integer,List<String>> map;

    public WwytExpandlistviewAdapter(Context context, List<String> list_head, Map<Integer,List<String>> map) {
        this.context = context;
        this.list_head = list_head;
        this.map = map;
    }

    @Override
    public int getGroupCount() {
        return list_head.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return map.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list_head.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return map.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       GroupViewHolder groupViewHolder = null;
        if (convertView==null){
            groupViewHolder = new GroupViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.expandlistview_wwytpj_head,null);
            groupViewHolder.tv_wtbt = (TextView) convertView.findViewById(R.id.tv_wwytpj_item_wtbt);
            groupViewHolder.tv_lxr = (TextView) convertView.findViewById(R.id.tv_wwytpj_item_lxr);
            groupViewHolder.tv_lxdh = (TextView) convertView.findViewById(R.id.tv_wwytpj_item_lxdh);
            groupViewHolder.tv_fsdd = (TextView) convertView.findViewById(R.id.tv_wwytpj_item_fsdd);
            groupViewHolder.tv_zf = (TextView) convertView.findViewById(R.id.tv_wwytpj_item_zf);
            convertView.setTag(groupViewHolder);
        }else{
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
      ChildViewHolder childViewHolder = null;
        if (convertView==null){
            childViewHolder = new ChildViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.expandlistview_wwytpj_content,null);
            childViewHolder.tv_gdtb = (TextView) convertView.findViewById(R.id.tv_wwytpj_content_gdtb);
            childViewHolder.tv_gdps = (TextView) convertView.findViewById(R.id.tv_wwytpj_content_gdps);
            childViewHolder.tv_gdcl = (TextView) convertView.findViewById(R.id.tv_wwytpj_content_gdcl);
            childViewHolder.tv_yhpj = (TextView) convertView.findViewById(R.id.tv_wwytpj_content_yhpj);
            convertView.setTag(childViewHolder);
        }else{
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupViewHolder{
        TextView tv_wtbt,tv_lxr,tv_lxdh,tv_fsdd,tv_zf;
    }

    class ChildViewHolder{
        TextView tv_gdtb,tv_gdps,tv_gdcl,tv_yhpj;
    }
}

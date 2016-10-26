package com.yf.bx.tms.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.XxbgActivity;

/**
 * 工单提报
 * Created by 123 on 2016/10/26.
 */

public class GdtbFragment extends Fragment implements View.OnClickListener{

    private View view;
    private ListView listView;
    private LinearLayout ll_add,ll_edit,ll_del,ll_commit;

    //定义接口 实现从一个Fragment跳转到另一个Fragment
    private OnAddClick  onAddClick;
    public GdtbFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gdtb,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.listview_gdtb);
        ll_add = (LinearLayout) view.findViewById(R.id.ll_gdtb_add);
        ll_edit = (LinearLayout) view.findViewById(R.id.ll_gdtb_edit);
        ll_del = (LinearLayout) view.findViewById(R.id.ll_gdtb_del);
        ll_commit = (LinearLayout) view.findViewById(R.id.ll_gdtb_commit);
        ll_add.setOnClickListener(this);
        ll_edit.setOnClickListener(this);
        ll_del.setOnClickListener(this);
        ll_commit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_gdtb_add:
                if (null!=onAddClick){
                    onAddClick.onClick(ll_add);
                }
                break;
            case R.id.ll_gdtb_edit:
                break;
            case R.id.ll_gdtb_del:
                break;
            case R.id.ll_gdtb_commit:
                break;
        }
    }


    //定义接口变量的get方法
    public OnAddClick getOnButtonClick() {
        return onAddClick;
    }
    //定义接口变量的set方法
    public void setOnButtonClick(OnAddClick onButtonClick) {
        this.onAddClick = onButtonClick;
    }
    //1、定义接口
    public interface OnAddClick{
        public void onClick(View view);
    }
}

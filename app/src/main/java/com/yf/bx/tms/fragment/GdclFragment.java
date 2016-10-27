package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;

/**
 * Created by 123 on 2016/10/26.
 */

public class GdclFragment extends Fragment implements View.OnClickListener{


    private View view;
    private ListView lv_gdcl;
    private TextView tv_cl,tv_tj;

    //定义接口 实现从一个Fragment跳转到另一个Fragment
    private OnAddClick onAddClick;

    public GdclFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gdcl,null);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_gdcl = (ListView) view.findViewById(R.id.listview_gdcl);
        tv_cl = (TextView) view.findViewById(R.id.tv_gdcl_cl);
        tv_tj = (TextView) view.findViewById(R.id.tv_gdcl_tj);

        tv_cl.setOnClickListener(this);
        tv_tj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_gdcl_cl:
                if (null!=onAddClick){
                    onAddClick.onClick(tv_cl);
                }
                break;
            case R.id.tv_gdcl_tj:

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
        void onClick(View view);
    }
}

package com.yf.bx.tms.fragment;


import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.GdtbAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 工单提报
 * Created by 123 on 2016/10/26.
 */

public class GdtbFragment extends Fragment implements View.OnClickListener{

    private final static String TAG = "GdtbFragment";
    private View view;
    private ListView listView;
    private LinearLayout ll_add,ll_edit,ll_del,ll_commit;
    private CheckBox cb_gdtb;
    private List<String> list;
    private List<String> list_cb;//选中的条目
    //定义接口 实现从一个Fragment跳转到另一个Fragment
    private OnAddClick  onAddClick;

    private GdtbAdapter adapter;
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
        cb_gdtb = (CheckBox) view.findViewById(R.id.cb_gdtb);
        listView = (ListView) view.findViewById(R.id.listview_gdtb);
        ll_add = (LinearLayout) view.findViewById(R.id.ll_gdtb_add);
        ll_edit = (LinearLayout) view.findViewById(R.id.ll_gdtb_edit);
        ll_del = (LinearLayout) view.findViewById(R.id.ll_gdtb_del);
        ll_commit = (LinearLayout) view.findViewById(R.id.ll_gdtb_commit);
        ll_add.setOnClickListener(this);
        ll_edit.setOnClickListener(this);
        ll_del.setOnClickListener(this);
        ll_commit.setOnClickListener(this);
        list = new ArrayList<>();
        list.add("实验数据1");
        list.add("实验数据2");
        adapter = new GdtbAdapter(list,getActivity());
        listView.setAdapter(adapter);
        cb_gdtb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    adapter.initCheckbox(true);
                    cb_gdtb.setText("全不选");
                }else{
                    adapter.initCheckbox(false);
                    cb_gdtb.setText("全选");
                }
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onClick(View v) {
        Map<Integer,Boolean> map =adapter.getMap();
        list_cb = new ArrayList<>();
        for (int i =0;i<map.size();i++){
            if (map.get(i)){
            list_cb.add(list.get(i));}
        }
        int len = list_cb.size();
        Log.i(TAG, "onClick: len:"+len);
        switch (v.getId()){
            case R.id.ll_gdtb_add:
                if (null!=onAddClick){
                    onAddClick.onClick(ll_add);
                }
                break;
            case R.id.ll_gdtb_edit:
                if (len!=1){
                    handler.sendEmptyMessage(1);
                }else{
                 // 编辑同样进入add界面，带数据进入
                    if (null!=onAddClick){
                        onAddClick.onClick2(ll_edit);
                    }
                }
                break;
            case R.id.ll_gdtb_del:
                if (len==0){
                    handler.sendEmptyMessage(2);
                     }else{

                    handler.sendEmptyMessage(22);
                    }
                break;
            case R.id.ll_gdtb_commit:
                if (len==0){
                    handler.sendEmptyMessage(3);
                }else{

                    handler.sendEmptyMessage(33);
                }
                break;
        }
    }


    android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Toast.makeText(getActivity(),"请选择一条工单进行编辑",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getActivity(),"请至少选择一条工单进行删除",Toast.LENGTH_SHORT).show();
                    break;
                case 22:
                    Toast.makeText(getActivity(),"删除成功",Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getActivity(),"请至少选择一条工单进行提交",Toast.LENGTH_SHORT).show();
                    break;
                case 33:
                    Toast.makeText(getActivity(),"提交成功",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
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
         void onClick2(View view);
    }
}

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.GdclAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**工单处理
 * Created by 123 on 2016/10/26.
 */

public class GdclFragment extends Fragment implements View.OnClickListener{

    private final static String TAG = "GdclFragment";
    private View view;
    private ListView lv_gdcl;
    private TextView tv_cl,tv_tj;
    private CheckBox cb_gdcl;
    private GdclAdapter adapter;
    private List<String> list ,list_cb;
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
        cb_gdcl = (CheckBox) view.findViewById(R.id.cb_gdcl);
        lv_gdcl = (ListView) view.findViewById(R.id.listview_gdcl);
        tv_cl = (TextView) view.findViewById(R.id.tv_gdcl_cl);
        tv_tj = (TextView) view.findViewById(R.id.tv_gdcl_tj);
        list = new ArrayList<>();
        list.add("测试数据1");
        list.add("测试数据2");
        list.add("测试数据1");
        list.add("测试数据2");
        list.add("测试数据1");
        list.add("测试数据2");
        list.add("测试数据1");
        list.add("测试数据2");
        list.add("测试数据1");
        list.add("测试数据2");
        list.add("测试数据1");
        list.add("测试数据2");
        tv_cl.setOnClickListener(this);
        tv_tj.setOnClickListener(this);
        adapter = new GdclAdapter(getActivity(),list);
        lv_gdcl.setAdapter(adapter);
        cb_gdcl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    adapter.initCheckbox(true);
                    cb_gdcl.setText("全不选");
                }else{
                    adapter.initCheckbox(false);
                    cb_gdcl.setText("全选");
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        list_cb = new ArrayList<>();
        Map<Integer,Boolean> map =adapter.getMap();
        Log.i(TAG, "onClick: map.size:"+map.size());
        for (int i =0;i<map.size();i++){
            if (map.get(i)){
            list_cb.add(list.get(i));}
        }
        int len = list_cb.size();
        Log.i(TAG, "onClick: len:"+len);
        switch (v.getId()){
            case R.id.tv_gdcl_cl:
                if (len!=1){
                    handler.sendEmptyMessage(1);
                }else{
                if (null!=onAddClick){
                    //带数据进入
                    onAddClick.onClick(tv_cl);
                }}
                break;
            case R.id.tv_gdcl_tj:
                if (len==0){
                    handler.sendEmptyMessage(2);
                }else{

                    handler.sendEmptyMessage(22);
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
                    Toast.makeText(getActivity(),"请选择一条工单进行处理",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getActivity(),"请至少选择一条工单进行提交",Toast.LENGTH_SHORT).show();
                    break;
                case 22:
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
    }
}

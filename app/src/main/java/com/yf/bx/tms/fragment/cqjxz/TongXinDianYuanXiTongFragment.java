package com.yf.bx.tms.fragment.cqjxz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.bx.tms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongXinDianYuanXiTongFragment extends ZnglFragment {


    public TongXinDianYuanXiTongFragment() {
        // Required empty public constructor
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int viewType, ViewGroup parent) {
        if (viewType == 0) {
            return getActivity().getLayoutInflater().inflate(R.layout
                    .layout_tongxindianyuan_header, parent, false);
        }
        return getActivity().getLayoutInflater().inflate(R.layout.list_item_radio_button_edit,
                parent, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tong_xin_dian_yuan_xi_tong, container, false);
    }

    static final String[] TITLES = {"整流模块风扇", "防雷保安单", "线缆、部件\n" +
            "是否过热", "空开、熔丝配置", "均充周期", "告警门限设置", "监控信息上报", "电源接线是否牢固", "电源线是否\n" +
            "穿防火管", "供电负荷标签", "重要负载独立\n" +
            "双电源核查", "设备接地", "UPS电源", "系统架构", "负载率", "监控单元\n" +
            "参数配置", "设备风扇", "双机切换", "蓄电池组", "电池组数/容量", "电池外观", "连接部件", "蓄电池标识", "缆线标识"};

    @Override
    public String[] getLines() {
        return TITLES;
    }
}

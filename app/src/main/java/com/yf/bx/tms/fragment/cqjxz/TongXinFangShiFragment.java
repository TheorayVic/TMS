package com.yf.bx.tms.fragment.cqjxz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.bx.tms.R;

public class TongXinFangShiFragment extends ZnglFragment {


    public TongXinFangShiFragment() {
        // Required empty public constructor
    }

    static final String[] TITLES = {"年度通信运行方式、\n" +
            "系统图册等资料，\n" +
            "内容是否完整准确，\n" +
            "是否与通信网络实际\n" +
            "运行状况相符", "重要业务通道运行\n" +
            "方式是否合理，是\n" +
            "否定期与现场进行\n" +
            "校核，是否具备应\n" +
            "急预案", "电路方式安排", "电路运行方式单\n" +
            "是否保存完整，\n" +
            "与电路实际数\n" +
            "据配置是否相符", "承载 220kV 及以\n" +
            "上电压等级同一线\n" +
            "路的两套继电保护\n" +
            "、同一系统两套安\n" +
            "控装置业务的通道\n" +
            "应具备两条不同的\n" +
            "路由，相应通信传\n" +
            "输设备应满足“双路\n" +
            "由、双设备、双电源\n" +
            "”的配置要求", "业务名称检查", "继电保护、安控装\n" +
            "置业务通道与现\n" +
            "场终端设备命名\n" +
            "及标识是否一致", "继电保护、安控装置维护界面是否清晰，责任是否落实", "其他", "检查重要传输网管设备是否采用了双机热备，是否定期进行切换试验"};

    @Override
    public String[] getLines() {
        return TITLES;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tong_xin_fang_shi, container, false);
    }

}

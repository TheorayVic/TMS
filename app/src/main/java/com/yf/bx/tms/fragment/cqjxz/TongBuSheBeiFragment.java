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
public class TongBuSheBeiFragment extends ZnglFragment {


    public TongBuSheBeiFragment() {
        // Required empty public constructor
    }

    static final String[] TITILES = {"检查同步时钟\n" +
            "设备各单元\n" +
            "运行情况", "卫星天线和馈线\n" +
            "固定是否牢固，\n" +
            "有无破损、进水、\n" +
            "锈蚀、接触不良\n" +
            "等情况", "检查卫星信号\n" +
            "与地面参考信号\n" +
            "跟踪、切换情况", "检查输出的 2Mhz\n" +
            " 及 2Mbps 信号使\n" +
            "用记录，下游接收\n" +
            "同步现场检查供给\n" +
            "信号的各个系统同\n" +
            "步是否正常", "检查同步时钟\n" +
            "设备各单元运\n" +
            "行情况"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tong_bu_she_bei, container, false);
    }
    @Override
    public String bottomTitle() {
        return "其他：";
    }
}

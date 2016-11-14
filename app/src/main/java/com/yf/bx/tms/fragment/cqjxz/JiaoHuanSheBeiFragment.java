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
public class JiaoHuanSheBeiFragment extends ZnglFragment {


    public JiaoHuanSheBeiFragment() {
        // Required empty public constructor
    }

    static final String[] TITLES = {"中继迂回路由\n" +
            "是否正常", "交换设备时钟\n" +
            "是否良好", "调度电话操作\n" +
            "台拨测是否正常", "调度电话录音\n" +
            "系统是否正常", "设备滤网清洗", "缆线标识\n" +
            "否完整", "配线架标示\n" +
            "是否完整", "设备是否与机\n" +
            "柜接地可靠连接", "是否配备防\n" +
            "静电手环", "设备是否与机\n" +
            "柜接地可靠连接", "通信电源", "两路电源切换\n" +
            "是否正常", "电源保安断路器容量是否合适", "是否与其他设备共用断路器"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jiao_huan_she_bei, container, false);
    }
    @Override
    public String bottomTitle() {
        return "其他：";
    }
    @Override
    public String[] getLines() {
        return TITLES;
    }
}

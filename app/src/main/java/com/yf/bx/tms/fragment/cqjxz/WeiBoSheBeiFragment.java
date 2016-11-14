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
public class WeiBoSheBeiFragment extends ZnglFragment {


    public WeiBoSheBeiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wei_bo_she_bei, container, false);
    }@Override
    public String bottomTitle() {
        return "备注：";
    }

    static final String[] TITLES = {"天线防水", "天线紧固", "天线罩布", "馈线防水", "馈线接地", "馈线紧固", "铁塔锈蚀", "铁塔紧固", "通信电源", "是否具备\n" +
            "两路通信电源", "两路电源切\n" +
            "换是否正常", "电源保安断路\n" +
            "器容量是否合适", "是否与其他\n" +
            "设备共用断路器", "设备接地", "设备是否与\n" +
            "机柜接地可\n" +
            "靠连接", "是否配备\n" +
            "防静电手镯", "缆线", "缆线标识\n" +
            "否完整", "配线架标示\n" +
            "是否完整"};

    @Override
    public String[] getLines() {
        return TITLES;
    }
}

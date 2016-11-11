package com.yf.bx.tms.fragment.xjyw_wwyt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.XjywWwytGwAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/11/10.
 */

public class GwFragment extends Fragment {
    private View view;
    private ListView lv;
    private String [][] strings ;
    private XjywWwytGwAdapter adapter;

    public GwFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gw,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv_xjyw_wwyt_gw);
        String [][] strings = {
                {"市供电公司信息通信分公司通信运检一班班长",
                        "省信通公司信息通信运检中心运检一室通信网设备运检",
                        "市供电公司信息通信分公司通信运检二班技术员",
                        "市供电公司信息通信分公司通信运检一班副班长",
                        "市供电公司信息通信分公司通信运检一班通信运维检修",
                        "市供电公司信息通信分公司通信运检一班安全员",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班副班长",
                        "省信通公司信息通信运检中心运检一室安全员",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班班长",
                        "省信通公司信息通信运检中心运检一室主管",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班信通运",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班技术员",
                        "省信通公司信息通信运检中心运检一室副主管",
                        "市供电公司信息通信分公司通信运检二班班长",
                        "省信通公司信息通信运检中心运检一室技术员",
                        "市供电公司信息通信分公司通信运检二班副班长",
                        "市供电公司信息通信分公司通信运检二班安全员",
                        "省信通公司信息通信运检中心运检一室通信网线路运检",
                        "省信通公司信息通信运检中心运检一室基础设施运检",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班安全员",
                        "市供电公司信息通信分公司通信运检二班通信运维检修",
                        "市供电公司信息通信分公司通信运检一班技术员"},
                {"市供电公司信息通信分公司通信运检一班安全员",
                        "市供电公司信息通信分公司通信运检二班班长",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班班长",
                        "市供电公司信息通信分公司通信运检二班安全员",
                        "省信通公司信息通信运检中心运检一室安全员",
                        "市供电公司信息通信分公司通信运检二班通信运维检修",
                        "省信通公司信息通信运检中心运检一室通信网线路运检",
                        "省信通公司信息通信运检中心运检一室主管",
                        "市供电公司信息通信分公司通信运检二班技术员",
                        "省信通公司信息通信运检中心运检一室通信网设备运检",
                        "省信通公司信息通信运检中心运检一室副主管",
                        "市供电公司信息通信分公司通信运检二班副班长",
                        "市供电公司信息通信分公司通信运检一班技术员",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班技术员",
                        "省信通公司信息通信运检中心运检一室技术员",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班副班长",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班安全员",
                        "省信通公司信息通信运检中心运检一室基础设施运检",
                        "市供电公司信息通信分公司通信运检一班通信运维检修",
                        "市供电公司信息通信分公司通信运检一班班长",
                        "县供电公司运维检修部（检修（建设）工区）信通运检班信通运检",
                        "市供电公司信息通信分公司通信运检一班副班长"}
        };
        adapter = new XjywWwytGwAdapter(getActivity(),strings);
        lv.setAdapter(adapter);
    }


}

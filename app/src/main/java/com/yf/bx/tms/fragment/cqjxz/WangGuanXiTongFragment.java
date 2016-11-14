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
public class WangGuanXiTongFragment extends ZnglFragment {

    @Override
    public String[] getLines() {
        return TITLES;
    }

    public WangGuanXiTongFragment() {
        // Required empty public constructor
    }

    static final String[] TITLES = {"网管系统应急预案\n", "网管服务器主备\n" +
            "用切换试验", "网管系统是否与\n" +
            "外部网络物理隔离", "网管系统和数据\n" +
            "库备份及恢复", "网管系统防病\n" +
            "毒软件升级", "是否安装与系统\n" +
            "自身运行无关的\n" +
            "其它软件", "是否存在违规\n" +
            "远程诊断拨入", "是否设置安全\n" +
            "检查专用工作站", "移动媒体驱动器\n" +
            "或接口是否封锁", "网管功能", "管理模块开启、\n" +
            "运行、关闭功能\n" +
            "是否正常", "电路的资料是否准确、齐全", "重要业务是否\n" +
            "配置保护", "业务主备用路由\n" +
            "是否独立", "告警门限是否设置合理", "静态安全", "检查重要传输网管设备是否采用了双机热备，是否定期进行切换试验", "是否采用 UPS 电源进行供电",
            "检网管系统安全分区方式及边界控制措施", "检查网管系统网络设备端口关闭情况", "检查网管系统应用软件安装及服务关闭情况", "检查移动存储介质接入管理情况",
            "检查网管系统防火墙部署及与其他系统连接情况", "动态安全", "检查网管系统安全管理制度建设", "检查网管系统安全防护措施执行", "检查移动网管终端安全防护措施",
            "检查网管系统远程维护情况", "检查网管系统数据备份规定及执行情况", "检查网管系统安全管理制度建设情况"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wang_guan_xi_tong, container, false);
    }

    @Override
    public String bottomTitle() {
        return "其他：";
    }
}

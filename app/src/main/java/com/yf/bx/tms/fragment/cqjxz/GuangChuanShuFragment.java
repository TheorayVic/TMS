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
public class GuangChuanShuFragment extends ZnglFragment {


    public GuangChuanShuFragment() {
        // Required empty public constructor
    }

    static final String[] TITLES = {"网管核查", "设备告警指示灯", "主控卡切换", "交叉卡切换", "支路卡1：N\n" +
            "保护切换", "光卡收发光\n" +
            "功率是否存在变化", "是否备用\n" +
            "网关配置", "DCC子网内\n" +
            "网元数是否超限", "重要业务传输\n" +
            "通道性能（15\n" +
            "分钟误码）在线测试\n", "同步时钟\n" +
            "方式检查", "端口资料检查", "特殊光放大器\n" +
            "是否具备现场\n" +
            "作用指导书", "业务", "继电保护是否\n" +
            "终端设备命名\n" +
            "及标识一致", "安控业务通道\n" +
            "与终端设备命\n" +
            "名及标识是否一致\n", "业务通道是否满足主备相互独、互不影响的要求", "缆线", "缆线标识\n" +
            "否完整", "配线架标示\n" +
            "是否完整", "设备清扫", "设备滤网清洗", "设备风扇\n" +
            "运行状况", "设备及机\n" +
            "柜除尘", "设备接地", "设备、机柜接地\n" +
            "状况是否完整", "是否配备防\n" +
            "静电手环", "设备电源", "两路电源输入\n" +
            "是否独立", "两路电源切换", "负载电流/电源\n" +
            "保安断路器容量", "保安断路器是否\n" +
            "与其他设备公用"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guang_chuan_shu, container, false);
    }

    @Override
    public String[] getLines() {
        return TITLES;
    }
}

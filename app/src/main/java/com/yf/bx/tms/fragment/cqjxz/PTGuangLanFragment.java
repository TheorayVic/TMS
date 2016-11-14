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
public class PTGuangLanFragment extends ZnglFragment {


    public PTGuangLanFragment() {
        // Required empty public constructor
    }

    public static final String[] TITLES = {"运行维护责任落实情况", "通信运行管理归口\n" +
            "单位与运行维护单\n" +
            "位之间的工作关系\n" +
            "和工作制度落实情况", "运行维护责任落实情况" + "应急预案完整性\n" +
            "、可操作性" + "专用工具和专用\n" +
            "器材是否起源" + "抢修物资储备\n" +
            "是否可用", "出入人孔标示牌", "接续人孔标示牌", "管道内光缆\n" +
            "保护措施", "光缆进线孔封堵", "人孔内光缆\n" +
            "预留长度", "有无光缆外露情\n" +
            "况，光缆引上、\n" +
            "引下保护设施\n" +
            "是否完好", "光缆路由周边安\n" +
            "全范围内有无工程\n" +
            "施工、房屋拆迁、市\n" +
            "政建设等行为", "光缆外观，光缆外护\n" +
            "层是否有损伤、变形\n" +
            "及受外力破坏", "管道井内光缆标志牌\n" +
            "有无丢失、损坏，\n" +
            "字迹是否清晰", "光缆盘留是否整齐，\n" +
            "绑扎是否牢固", "隧道内电缆托架\n" +
            "、托板是否完好", "光缆走线排列\n" +
            "是否整齐，绑扎\n" +
            "是否牢固", "管道井和隧道内\n" +
            "有无积水、 杂物和\n" +
            "易燃易爆危险物品，\n" +
            "线路周边安全范围内\n" +
            "有无工程施工、 房屋\n" +
            "拆迁、 市政建设等行为", "建筑物内光缆 是否\n" +
            "有人为操作或建筑物\n" +
            "内有施工、 装修等情况", "光缆路由图\n" +
            "是否完整"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ptguang_lan, container, false);
    }



    @Override
    public String[] getLines() {
        return TITLES;
    }
}

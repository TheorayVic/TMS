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

/**五位一体 岗位
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
                {       "机房环境",
                        "通信电源",
                        "传输设备",
                        "交换设备",
                        "配线设备",
                        "门型架光缆"},
                {       "通信站检查内容主要包括制度检查、资料检查、机房运行环境、防雷接地情况、线缆、消防设施、空调运行情况及机柜内插排等检查。" ,
                        "（1）检查电源系统接线图应上墙，与实际接线一致，电源空开标签应准确完备。\n" +
                        "（2）检查前应对万用表、钳流表、放电仪等检测仪表进行校准，宜采用同一仪表完成同一设备的检测工作，减少测量误差。\n" +
                        "（3）设备外观应完好；整流电源模块、设备风扇应运转良好；宜采用红外测温仪检查设备内部配电开关、线缆、熔丝、整流模块运行温度。\n" +
                        "（4）电源设备防雷保安器件应状态正常，空气开关、保险、熔丝容量应符合运行要求；上下级开关、交直流开关容量应匹配，防止越级跳闸。\n" +
                        "（5）220kV及以上厂站应配置双套独立通信电源。同一条线路的两套继电保护接口装置、同一系统的两套安控装置由两套独立的电源设备供电。" ,
                        "（1） 检查设备机架和板卡告警。检查设备及板卡告警灯状态，明确告警原因，关闭未使用端口，清除无关告警。\n" +
                        "（2） 切换功能检查。进行传输设备电源双路切换检查。检查主控、交叉等核心板卡的保护状态，进行主备用倒换。检查业务的工作和保护链路状态，进行SNCP切换测试。" ,
                        "（1） 检查行政、调度交换设备、录音设备及其它相关设备的运行情况及告警信息。\n" +
                        "（2） 系统专网、公网中继线应正常工作，具备迂回路由的中继局向应检查迂回路由设置状况；更新完善中继线定期测试记录。\n" +
                        "（3） 调度台调度电话应进行拨测实验，检查是否畅通。检查录音设备查询、播放录音文件功能；检查交换设备数据库、录音数据备份，每季度应不少于一次。\n" +
                        "（4） 检查系统专网中继线及公网中继线的使用状态，根据交换网络图检查中继路由设置情况。\n" +
                        "（5） 检查交换设备的时钟源设置是否合理。" ,
                        "检查配线是否合理，配线架面板前、后应采用红色标识标记保护、安稳等重要电网生产业务。" ,
                        "（1） 进一步梳理完善运行维护责任落实情况。主要包括通信部门与线路运维、物业管理、供电施工等部门之间的工作界面、工作流程、安全责任的落实情况，重点落实涉及三级及以上干线重要业务、中心站出局通信光缆运维责任。\n" +
                        "（2） 检查光缆应急抢修预案的落实情况。主要包括应急队伍、应急车辆、救急物资等准备情况，重点对光缆备品备件、专用工器具等进行检查。\n" +
                        "（3） 整理完善光缆定期巡视记录和站内进场光缆路由图。更新接头盒位置及型号，光缆型号、结构、长度、路径、芯数及使用情况等资料。\n" +
                        "（4） 加强与运检专业沟通协调，跟踪落实线路巡视工作安排，及时组织开展隐患消缺工作，做好站内进场光缆路由图的技术交底工作。"}
        };
        adapter = new XjywWwytGwAdapter(getActivity(),strings);
        lv.setAdapter(adapter);
    }


}

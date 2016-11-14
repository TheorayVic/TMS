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
public class ShuJuWangSheBeiFragment extends ZnglFragment {


    public ShuJuWangSheBeiFragment() {
        // Required empty public constructor
    }

    static final String[] TITLES = {"是否有不经过\n" +
            "防火墙的外联链路", "是否有当前\n" +
            "准确的网络\n" +
            "拓扑结构图", "是否具备信息\n" +
            "系统运行管理规程", "是否实行工作\n" +
            "票制度", "是否建立了\n" +
            "缺陷管理制度", "是否建立了\n" +
            "统计汇报制度", "是否建立了\n" +
            "运维流程并\n" +
            "按照流程进行操作", "是否进行了备份", "是否具备双电源", "是否关闭了\n" +
            "HTTP、FTP、\n" +
            "TFTP等服务", "无线网络是否\n" +
            "有合理的安全策略", "与互联网拨号连接是否审批和相应的安全策略", "检查数据网网络设备安全措施", "检查 IP 地址管理安全情况", "检查防火墙部署及配置情况",
            "检查数据备份策略情况", "是否能对本单位全部IP地址进行授权管理", "是否有IP地址的规划方案和分配策略", "是否有IP地址分配记录", "是否采用了双机备份",
            "是否进行过热切换测试", "是否进行故障恢复的测试", "备品备件是否正常工作"};

    @Override
    public String[] getLines() {
        return super.getLines();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shu_ju_wang_she_bei, container, false);
    }
    @Override
    public String bottomTitle() {
        return "其他：";
    }
    @Override
    public void convertObject2View(int position, ViewHolder holder, Object o) {
        super.convertObject2View(position, holder, o);
        holder.setText(R.id.rb_jcjg_left1,"是");
        holder.setText(R.id.rb_jcjg_right1,"否");
    }
}

package com.yf.bx.tms.fragment.cqjxz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.fragment.BaseListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZnglFragment extends BaseListFragment<Object> {


    public ZnglFragment() {
        // Required empty public constructor
    }

    static final String[] TITLES = {"运行维护责任\n" +
            "落实情况", "通信运行管理归口\n" +
            "单位与运行维护单\n" +
            "位之间的工作关系\n" +
            "和工作制度落实情况", "运行维护责任\n" +
            "落实情况", "应急预案完整性\n" +
            "、可操作性", "专用工具和\n" +
            "专用器材是否起源", "抢修物资储备\n" +
            "是否可用", "引下OPGW光缆\n" +
            "三点接地", "引下光缆\n" +
            "钢管防护", "引下光缆钢管\n" +
            "上端封堵", "引下光缆钢管\n" +
            "下端弯曲半径", "引下线夹绝缘", "接头箱（接头\n" +
            "盒）密封", "进场光缆类型", "地埋光缆地面\n" +
            "路由标识", "光缆标签标识悬挂", "电缆沟内光缆\n" +
            "隔离保护措施", "站内光缆同\n" +
            "路由情况", "机房光缆出口\n" +
            "防护措施", "进场导引光\n" +
            "缆路由图"};


    public String[] getLines() {
        return TITLES;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zngl, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList.clear();
        addLines(getLines().length, new ObjectCreator<Object>() {
            @Override
            public Object createObject(int position) {
                return new Object();
            }
        });
    }



    @Override
    public View getView(int viewType, ViewGroup parent) {
        return getActivity().getLayoutInflater
                ().inflate(R.layout.list_item_radio_button_edit, parent, false);
    }

    @Override
    public void convertObject2View(int position, ViewHolder holder, Object o) {
        holder.setText(R.id.title, getLines()[position]);
    }
}

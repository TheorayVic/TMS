package com.yf.bx.tms.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.CqjXzActivity;
import com.yf.bx.tms.view.ZengjiaJianShaoGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 春秋检业务 * Created by 123 on 2016/11/7.
 */

public class CqjywFragment extends XjywFragment {

    public CqjywFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_cqjyw,container,false);
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static final String[] TITLES = {"通讯站安全检查", "站内光缆安全检查", "ADSS光缆安全检查", "OPGW光缆安全检查",
            "普通光缆安全检查", "备用纤芯安全检查", "通信电源系统", "通信电源-蓄电池", "微波设备安全检查", "光传输设备安全检查", "交换设备安全检查",
            "电视电话会议系统", "数据网设备安全检查", "同步设备安全检查", "网关系统安全检查", "通信运行方式及重要业务通道"};
    public static List<CQJItem> list;


    @Override
    public void add(Fragment fragment) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setView(R.layout.dialog_add_cqjyw);
            Dialog dialog = builder.create();
//            WindowManager windowManager = getActivity().getWindowManager();
//            Display display = windowManager.getDefaultDisplay();
//            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
//            lp.width = (int) (display.getWidth()); //设置宽度
//            lp.height = display.getHeight();
//            dialog.getWindow().setAttributes(lp);
        Window win = dialog.getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        win.setAttributes(lp);
        dialog.show();
            ZengjiaJianShaoGridView gridView = (ZengjiaJianShaoGridView) dialog.findViewById(R.id.grid_view);
            list = new ArrayList<>();
            for (int i = 0; i < TITLES.length; i++) {
                CQJItem cqjItem = new CQJItem(0, i, TITLES[i]);
                list.add(cqjItem);
            }
            gridView.setList(list);
            dialog.findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), CqjXzActivity.class));
                }
            });

    }

    public static class CQJItem implements ZengjiaJianShaoGridView.GridItem, Cloneable {
        public String title;
        public int count;
        public int index;//作为id来标记用处

        public CQJItem() {
        }

        public CQJItem(int count, int index, String title) {
            this.count = count;
            this.index = index;
            this.title = title;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            CQJItem cqjItem = (CQJItem) super.clone();
            cqjItem.count = count;
            cqjItem.title = title;
            cqjItem.index = index;
            return cqjItem;
        }

        public CQJItem(int count, String title) {
            this.count = count;
            this.title = title;
        }

        @Override
        public String getId() {
            return String.valueOf(index);
        }

        @Override
        public int getDefaultCount() {
            return 0;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public int getMax() {
            return 10;
        }

        @Override
        public int getMin() {
            return 0;
        }
    }
}

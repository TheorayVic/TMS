package com.yf.bx.tms.fragment.cqjxz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OPGLGuangLan extends ADSSGuangLanFragment {


    public OPGLGuangLan() {
        // Required empty public constructor
    }

    public static final String[] TITLES = {"杆塔号", "档号", "是否断股", "交叉跨越物", "引下光缆及线夹", "光缆金具",
            "是否有接头盒"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opglguang_lan, container, false);
    }
    @Override
    public View getView(int viewType, ViewGroup parent) {
        return LayoutInflater.from(getActivity()).inflate(R.layout
                .list_item_adss_guang_lan_item_add, parent, false);
    }

    @Override
    public void convertObject2View(int position, ViewHolder holder, Object o) {
        if (position == 0) {
            ViewGroup viewGroup = (ViewGroup) holder.mItemView;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                TextView textView = (TextView) viewGroup.getChildAt(i);
                textView.setText(TITLES[i % viewGroup.getChildCount()]);
            }
        } else {
            ViewGroup viewGroup = (ViewGroup) holder.mItemView;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                TextView textView = (TextView) viewGroup.getChildAt(i);
                textView.setText("");
            }
        }
    }
}

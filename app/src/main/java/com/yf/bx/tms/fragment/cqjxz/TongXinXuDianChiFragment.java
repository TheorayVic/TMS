package com.yf.bx.tms.fragment.cqjxz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongXinXuDianChiFragment extends ADSSGuangLanFragment {


    public static final String[] TITLES = {"放点时长", "浮充", "15min", "1h", "2h", "3h", "4h", "5h",
            "6h", "充电", "结束"};

    public TongXinXuDianChiFragment() {
        // Required empty public constructor
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
            if (position == 1) {
                holder.setText(R.id.index, "组电压");
            } else if (position == 2) {
                holder.setText(R.id.index, "组电流");
            } else {
                holder.setText(R.id.index, (position - 2) + "");
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addLines(25, new ObjectCreator<Object>() {
            @Override
            public Object createObject(int position) {
                return null;
            }
        });
    }

    @Override
    public View getView(int viewType, ViewGroup parent) {
        return getActivity().getLayoutInflater().inflate(R.layout.list_item_text_view_11,parent,false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tong_xin_xu_dian_chi, container, false);
    }
}

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
public class BeiYongQianXinFragment extends ADSSGuangLanFragment {


    public static final String[] TITLES = {"纤芯", "全场/km", "全程损耗/dB", "平均损耗dB/km", "故障点/km", "备注"};


    public BeiYongQianXinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bei_yong_qian_xin, container, false);
    }
    @Override
    public String bottomTitle() {
        return "备注：";
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addLines(22, new ObjectCreator<Object>() {
            @Override
            public Object createObject(int position) {
                return new Object();
            }
        });
    }

    @Override
    public View getView(int viewType, ViewGroup parent) {
        return getActivity().getLayoutInflater().inflate(R.layout.list_item_text_view_6, parent, false);
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
            holder.setText(R.id.index, position + "");
        }
    }
}

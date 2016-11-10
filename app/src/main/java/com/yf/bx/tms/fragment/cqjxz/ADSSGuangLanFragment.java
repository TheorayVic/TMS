package com.yf.bx.tms.fragment.cqjxz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.fragment.BaseListFragment;

import butterknife.OnClick;

/**
 */
public class ADSSGuangLanFragment extends BaseListFragment<Object> {


    public ADSSGuangLanFragment() {
        // Required empty public constructor
    }

    public static final String[] TITLES = {"杆塔号", "档号", "挂点", "弧垂", "交叉跨越", "外护套", "光缆金具"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adssguang_lan, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addLines(3, new ObjectCreator<Object>() {//默认三行
            @Override
            public Object createObject(int position) {
                return new Object();
            }
        });
    }

    @Override
    public View getView(int viewType, ViewGroup parent) {
        return LayoutInflater.from(getActivity()).inflate(R.layout
                .list_item_adss_guang_lan_item_add, parent, false);
    }

    @OnClick(R.id.add_lines)
    public void addLines(View view) {//增加5行
        addLines(5, new ObjectCreator<Object>() {
            @Override
            public Object createObject(int position) {
                return new Object();
            }
        });
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

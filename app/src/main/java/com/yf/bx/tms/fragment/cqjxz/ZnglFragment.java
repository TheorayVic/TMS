package com.yf.bx.tms.fragment.cqjxz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.bx.tms.R;
import com.yf.bx.tms.fragment.BaseListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZnglFragment extends BaseListFragment<Object> {


    public ZnglFragment() {
        // Required empty public constructor
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
        addLines(10, new ObjectCreator<Object>() {
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

    }
}

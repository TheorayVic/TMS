package com.yf.bx.tms.fragment;

import android.app.IntentService;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.AppContext;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by 123 on 2016/11/7.
 */

public class XjywFragment extends CommonFra implements View.OnClickListener {

    private View view;
    private EditText spi_xjdw, spi_jcfzr;
    private Spinner spi_txz;
    private TextView spi_jcsj, spi_jcsj2;
    private AppContext appContext;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
    private DefaultXjywFragment defaultXjywFragment;
    private AddXjywFragment addXjywFragment;
    private FragmentManager fm;
    private List<Fragment> fragments;
    private TextView tv_add, tv_search, tv_reset;

    public XjywFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_xjyw, null);
        defaultXjywFragment = new DefaultXjywFragment();
        fm = getChildFragmentManager();
        if (fm.getFragments() != null) {
            fm.getFragments().clear();
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout_txxj, defaultXjywFragment);
        // fragmentTransaction.addToBackStack(null);
        ft.commit();
        //   ReplaceFragmentUtils.replaceF(getActivity(),defaultXjywFragment,false,R.id.framelayout_txxj);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spi_xjdw = (EditText) view.findViewById(R.id.spi_xjyw_xjdw);
        spi_txz = (Spinner) view.findViewById(R.id.spi_xjyw_txz);
        spi_jcfzr = (EditText) view.findViewById(R.id.spi_xjyw_jcfzr);
        spi_jcsj = (TextView) view.findViewById(R.id.spi_xjyw_jcsj);
        spi_jcsj2 = (TextView) view.findViewById(R.id.spi_xjyw_jcsj2);
        tv_add = (TextView) view.findViewById(R.id.xjyw_add);
        tv_search = (TextView) view.findViewById(R.id.xjyw_search);
        tv_reset = (TextView) view.findViewById(R.id.xjyw_reset);
        addXjywFragment = new AddXjywFragment();
        tv_search.setOnClickListener(this);
        tv_reset.setOnClickListener(this);
        appContext = (AppContext) getActivity().getApplicationContext();
        spi_txz.setAdapter(appContext.getAdapter_txz(getActivity()));
        //时间日期选择
        selectDate(spi_jcsj);
        selectDate(spi_jcsj2);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xjyw_search:
                break;
            case R.id.xjyw_reset:

                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.xjyw_add)
    public void add(View v) {
        fragments = fm.getFragments();
        if (fragments != null) {
            if (fragments.contains(addXjywFragment))
                fragments.remove(addXjywFragment);
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout_txxj, addXjywFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}




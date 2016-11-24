package com.yf.bx.tms.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.AppContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**巡检业务界面
 * Created by 123 on 2016/11/7.
 */

public class XjywFragment extends CommonFra implements View.OnClickListener {

    private final static String TAG = "XjywFragment";
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
    private String txz;
    public XjywFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}

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
        tv_add.setOnClickListener(this);
        appContext = (AppContext) getActivity().getApplicationContext();
        spi_txz.setAdapter(appContext.getAdapter_txz(getActivity()));
        spi_txz.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //获取下拉框选中的内容
                txz = appContext.list_txz.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //时间日期选择
        selectDate(spi_jcsj);
        selectDate(spi_jcsj2);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xjyw_search:
                defaultXjywFragment = new DefaultXjywFragment();
                add(defaultXjywFragment);
                break;
            case R.id.xjyw_reset:
                spi_xjdw.setText("");
                spi_jcfzr.setText("");
                spi_jcsj.setText("");
                spi_jcsj2.setText("");
                break;
            case R.id.xjyw_add:
                add(addXjywFragment);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void add(Fragment fragment) {
        fragments = fm.getFragments();
        if (fragments != null) {
            if (fragments.contains(fragment))
                fragments.remove(fragment);
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout_txxj, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}




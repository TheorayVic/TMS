package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.AppContext;
import com.yf.bx.tms.adapter.DefaultXjywAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2016/11/7.
 */

public class XjywFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Spinner spi_xjdw,spi_txz,spi_jcfzr;
    private TextView spi_jcsj,spi_jcsj2;
    private AppContext appContext;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
    private DefaultXjywFragment defaultXjywFragment;
    private TextView tv_add,tv_search,tv_reset;

    public XjywFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xjyw,null);
        defaultXjywFragment = new DefaultXjywFragment();
        ReplaceFragmentUtils.replaceF(getActivity(),defaultXjywFragment,false,R.id.framelayout_txxj);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spi_xjdw = (Spinner) view.findViewById(R.id.spi_xjyw_xjdw);
        spi_txz = (Spinner) view.findViewById(R.id.spi_xjyw_txz);
        spi_jcfzr = (Spinner) view.findViewById(R.id.spi_xjyw_jcfzr);
        spi_jcsj = (TextView) view.findViewById(R.id.spi_xjyw_jcsj);
        spi_jcsj2 = (TextView) view.findViewById(R.id.spi_xjyw_jcsj2);
        tv_add = (TextView) view.findViewById(R.id.xjyw_add);
        tv_search = (TextView) view.findViewById(R.id.xjyw_search);
        tv_reset = (TextView) view.findViewById(R.id.xjyw_reset);
        appContext = (AppContext) getActivity().getApplicationContext();
        ArrayAdapter<String> adapter_xjdw = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,appContext.list_xjdw);
        ArrayAdapter<String> adapter_txz = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,appContext.list_txz);
        ArrayAdapter<String> adapter_jcfzr = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,appContext.list_jcfzr);
        spi_xjdw.setAdapter(adapter_xjdw);
        spi_txz.setAdapter(adapter_txz);
        spi_jcfzr.setAdapter(adapter_jcfzr);
        //时间日期选择
        final SlideDateTimeListener jcsj_listener = new SlideDateTimeListener() {
            @Override
            public void onDateTimeSet(Date date)
            {
                // Do something with the date. This Date object contains
                // the date and time that the user has selected.
                String date2 = dateFormat.format(date);
                spi_jcsj.setText(date2);
            }

            @Override
            public void onDateTimeCancel()
            {
                // Overriding onDateTimeCancel() is optional.
            }
        };
        final SlideDateTimeListener jcsj_listener2 = new SlideDateTimeListener() {
            @Override
            public void onDateTimeSet(Date date)
            {
                // Do something with the date. This Date object contains
                // the date and time that the user has selected.
                String date2 = dateFormat.format(date);
                spi_jcsj2.setText(date2);
            }

            @Override
            public void onDateTimeCancel()
            {
                // Overriding onDateTimeCancel() is optional.
            }
        };
        spi_jcsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getActivity().getSupportFragmentManager())
                        .setListener(jcsj_listener)
                        .setInitialDate(new Date())
                        .setIs24HourTime(true)
                        .build()
                        .show();
            }
        });
        spi_jcsj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getActivity().getSupportFragmentManager())
                        .setListener(jcsj_listener2)
                        .setInitialDate(new Date())
                        .setIs24HourTime(true)
                        .build()
                        .show();
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.xjyw_add:
                break;
            case R.id.xjyw_search:
                break;
            case R.id.xjyw_reset:
                break;
        }
    }
}




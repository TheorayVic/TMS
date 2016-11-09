package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.AppContext;
import com.yf.bx.tms.adapter.FxwtAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/11/7.
 */

public class FxwtFragment extends CommonFra {

    private View view;
    private ListView lv;
    private List<String> list;
    private FxwtAdapter fxwtAdapter;
    private AppContext appContext;
    private Spinner spi_txz;
    private EditText et_xjdw,et_jcfzr;
    private TextView tv_jcsj,tv_jcsj2;


    public FxwtFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fxwt,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv_fxwt);
        et_xjdw = (EditText) view.findViewById(R.id.spi_xjyw_xjdw);
        spi_txz = (Spinner) view.findViewById(R.id.spi_xjyw_txz);
        et_jcfzr = (EditText) view.findViewById(R.id.spi_xjyw_jcfzr);
        tv_jcsj = (TextView) view.findViewById(R.id.spi_xjyw_jcsj);
        tv_jcsj2 = (TextView) view.findViewById(R.id.spi_xjyw_jcsj2);
        appContext = (AppContext) getActivity().getApplicationContext();
        spi_txz.setAdapter(appContext.getAdapter_txz(getActivity()));
        list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        fxwtAdapter = new FxwtAdapter(getActivity(),list);
        lv.setAdapter(fxwtAdapter);
    }
}

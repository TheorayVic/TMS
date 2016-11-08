package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.AppContext;

/**
 * Created by 123 on 2016/11/8.
 */

public class AddXjywFragment extends CommonFra {


    private View view;
    private EditText et_xjdw,et_jcfzr,et_gzpbh;
    private Spinner spi_txz;
    private TextView tv_jcsj,tv_xj;
    private AppContext appContext;
    public AddXjywFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xjyw_add,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_xjdw = (EditText) view.findViewById(R.id.spi_xjyw_add_xjdw);
        et_jcfzr = (EditText) view.findViewById(R.id.spi_xjyw_add_jcfzr);
        et_gzpbh = (EditText) view.findViewById(R.id.spi_xjyw_add_gzpbh);
        spi_txz = (Spinner) view.findViewById(R.id.spi_xjyw_add_txz);
        tv_jcsj = (TextView) view.findViewById(R.id.spi_xjyw_add_jcsj);
        tv_xj = (TextView) view.findViewById(R.id.tv_xjyw_add_xjsq);
        appContext = (AppContext) getActivity().getApplicationContext();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,appContext.list_txz);
        spi_txz.setAdapter(adapter);
        selectDate(tv_jcsj);
        tv_xj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = tv_xj.getText().toString();
                if ("巡检申请".equals(content)){
                    tv_xj.setText("申请中...");
                    //发送请求，申请成功后变

                    tv_xj.setText("开始巡检");
                }else if ("开始巡检".equals(content)){

                }
            }
        });
    }
}

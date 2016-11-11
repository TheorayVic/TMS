package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.GzzdAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/11/7.
 */

public class GzzdFragment extends CommonFra {

    private View view;
    private RadioButton tv_gzzd,tv_bzgf;
    private RadioGroup rg;
    private ImageButton ib_search;
    private SearchView searchView;
    private ListView lv;
    private List<String> list_gzzd,list_bzgf;
    private GzzdAdapter gzzdAdapter;
    public GzzdFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gzzd,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_gzzd = (RadioButton) view.findViewById(R.id.tv_gzzd);
        tv_bzgf = (RadioButton) view.findViewById(R.id.tv_bzgf);
        rg = (RadioGroup) view.findViewById(R.id.rg_gzzd);
        searchView = (SearchView) view.findViewById(R.id.searchview_gzzd);
        ib_search = (ImageButton) view.findViewById(R.id.ib_gzzd_search_inner);
        lv = (ListView) view.findViewById(R.id.lv_gzzd);
        list_gzzd = new ArrayList<>();
        list_bzgf = new ArrayList<>();
        list_bzgf.add("");
        list_bzgf.add("");
        list_bzgf.add("");
        list_gzzd.add("");
        list_gzzd.add("");
        list_gzzd.add("");
        list_gzzd.add("");
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.tv_gzzd:
                        gzzdAdapter = new GzzdAdapter(getActivity(),list_gzzd);
                        break;
                    case R.id.tv_bzgf:
                        gzzdAdapter = new GzzdAdapter(getActivity(),list_bzgf);
                        break;
                }
                lv.setAdapter(gzzdAdapter);
            }
        });
        tv_gzzd.setChecked(true);
    }


}

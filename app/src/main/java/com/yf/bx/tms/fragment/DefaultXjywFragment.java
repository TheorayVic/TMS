package com.yf.bx.tms.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.DefaultXjywAdapter;
import com.yf.bx.tms.utils.DividerGridItemXjyw;

import java.util.ArrayList;
import java.util.List;

/**巡检业务
 * Created by 123 on 2016/11/7.
 */

public class DefaultXjywFragment extends Fragment {

    private View view;
    private ListView lv;
    private Context context;
    private DefaultXjywAdapter defaultXjywAdapter;
    private List<List<String>> list;

    public DefaultXjywFragment(List<List<String>> list) {
        this.list = list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xjyw_default,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     //   glm = new GridLayoutManager(getActivity(),1);
        lv = (ListView) view.findViewById(R.id.lv_xjyw_default);
     //   rv.setLayoutManager(glm);
      if (list!=null){
        defaultXjywAdapter = new DefaultXjywAdapter(getActivity(),list);
        //设置Adapter  
        lv.setAdapter(defaultXjywAdapter);}
    }


}

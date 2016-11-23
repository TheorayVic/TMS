package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.WwytExpandlistviewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**信息办公中的五位一体评价
 * Created by 123 on 2016/10/26.
 */

public class WwytpjFragment extends Fragment {

    private View view;
    private ExpandableListView exlv_wwytpj;
    private List<String> list_head,list_content1,list_content2;
    private Map<Integer,List<String>> map;

    public WwytpjFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wwytpj,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        exlv_wwytpj = (ExpandableListView) view.findViewById(R.id.expandlistview_wwytpj);
        exlv_wwytpj.setGroupIndicator(null);
        list_head = new ArrayList<>();
        list_content1 =new ArrayList<>();
        list_content2 =new ArrayList<>();
        map = new HashMap<>();
        list_head.add("head实验数据1");
        list_head.add("head实验数据2");
        list_content1.add("content实验数据1");
        map.put(0,list_content1);
        list_content2.add("content实验数据2");
        map.put(1,list_content2);
        WwytExpandlistviewAdapter adapter = new WwytExpandlistviewAdapter(getActivity(),list_head,map);
        exlv_wwytpj.setAdapter(adapter);
    }
}

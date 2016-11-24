package com.yf.bx.tms.fragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
@SuppressLint("ValidFragment")
public class DefaultXjywFragment extends Fragment {

    private final static String TAG = "DefaultXjywFragment";
    private View view;
    private ListView lv;
    private Context context;
    private DefaultXjywAdapter defaultXjywAdapter;
    private XjywBroadcast xjywBro;//判断进入的是巡检业务还是春秋检业务
    private int type;
    private List<List<String>> list;
    private List<String> list1,list2,list3;

    public DefaultXjywFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册广播
        xjywBro = new XjywBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("type");
        getActivity().registerReceiver(xjywBro,intentFilter);
    }
    public class XjywBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null){
                type = intent.getIntExtra("type",-1);
                Log.i(TAG, "onReceive: type="+type);
                list.clear();
                list1.remove(6);
                list2.remove(6);
                list3.remove(6);
                switch (type){
                    case 0:
                        list1.add("巡检业务");
                        list2.add("巡检业务");
                        list3.add("巡检业务");
                        break;
                    case 1:
                        list1.add("春秋检业务");
                        list2.add("春秋检业务");
                        list3.add("春秋检业务");
                        break;
                }
                list.add(list1);
                list.add(list2);
                list.add(list3);
                defaultXjywAdapter.notifyDataSetChanged();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_xjyw_default,null);
        initData();
        lv = (ListView) view.findViewById(R.id.lv_xjyw_default);
        if (list!=null){
            defaultXjywAdapter = new DefaultXjywAdapter(getActivity(),list);
            lv.setAdapter(defaultXjywAdapter);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     //   glm = new GridLayoutManager(getActivity(),1);
    }

    private void initData(){
        list = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("1");//是否结束巡检
        list1.add("巡检业务");
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("1");//是否结束巡检
        list2.add("巡检业务");
        list3.add("1");
        list3.add("2");
        list3.add("3");
        list3.add("4");
        list3.add("5");
        list3.add("1");//是否结束巡检
        list3.add("巡检业务");
        list.add(list1);
        list.add(list2);
        list.add(list3);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(xjywBro);
    }
}

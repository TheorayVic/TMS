package com.yf.bx.tms.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GdpsAddPeopleActivity extends AutoLayoutActivity {

    private ListView lv_busy,lv_zhong,lv_xian;
    private TextView tv_confirm;
    private List<String> list_busy,list_zhong,list_xian;
    //控制三个listview只能选择一个人员
    private Map<Integer,Boolean> map_busy = new HashMap<>();

    private Map<Integer,Boolean> map_zhong = new HashMap<>();

    private Map<Integer,Boolean> map_xian = new HashMap<>();

    private BusyAdapter busyAdapter;
    private ZhongAdapter zhongAdapter;
    private XianAdapter xianAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdps_add_people);
        lv_busy = (ListView) findViewById(R.id.listview_psgd_busy);
        lv_zhong = (ListView) findViewById(R.id.listview_psgd_zhong);
        lv_xian = (ListView) findViewById(R.id.listview_psgd_xian);
        tv_confirm = (TextView) findViewById(R.id.tv_psgd_confirm);

        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result","试验数据");
                GdpsAddPeopleActivity.this.setResult(RESULT_OK,intent);
                finish();
            }
        });
        list_busy = new ArrayList<>();
        list_busy.add("测试人员1");
        list_busy.add("测试人员2");
        list_zhong= new ArrayList<>();
        list_zhong.add("测试人员1");
        list_zhong.add("测试人员2");
        list_xian = new ArrayList<>();
        list_xian.add("测试人员1");
        list_xian.add("测试人员2");
        busyAdapter = new BusyAdapter(list_busy,map_busy);
        zhongAdapter = new ZhongAdapter(list_zhong,map_zhong);
        xianAdapter = new XianAdapter(list_xian,map_xian);
        lv_busy.setAdapter(busyAdapter);
        lv_zhong.setAdapter(zhongAdapter);
        lv_xian.setAdapter(xianAdapter);

        lv_busy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //提交人员信息
                map_busy.clear();
                map_zhong.clear();
                map_xian.clear();
                map_busy.put(position,true);
                busyAdapter.notifyDataSetChanged();
                zhongAdapter.notifyDataSetChanged();
                xianAdapter.notifyDataSetChanged();
            }
        });

        lv_zhong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                map_busy.clear();
                map_zhong.clear();
                map_xian.clear();
                map_zhong.put(position,true);
                busyAdapter.notifyDataSetChanged();
                zhongAdapter.notifyDataSetChanged();
                xianAdapter.notifyDataSetChanged();
            }
        });

        lv_xian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                map_busy.clear();
                map_zhong.clear();
                map_xian.clear();
                map_xian.put(position,true);
                busyAdapter.notifyDataSetChanged();
                zhongAdapter.notifyDataSetChanged();
                xianAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }



    //忙的人员
    class BusyAdapter extends BaseAdapter{
        private List<String> list;
        private Map<Integer,Boolean> map_busy;

        public BusyAdapter(List<String> list, Map<Integer, Boolean> map_busy) {
            this.list = list;
            this.map_busy = map_busy;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           TextView tv_busy;
            if (convertView==null){
                convertView = LayoutInflater.from(GdpsAddPeopleActivity.this).inflate(R.layout.listview_addpeople_busy_item,null);
                tv_busy = (TextView) convertView.findViewById(R.id.tv_add_busy_item);
                convertView.setTag(tv_busy);
            }else {
                tv_busy = (TextView) convertView.getTag();
            }
            if ((map_busy!=null)&&map_busy.keySet().contains(position)){
            if (map_busy.get(position)){
                tv_busy.setBackgroundColor(Color.BLUE);
            }}else{
                tv_busy.setBackgroundColor(Color.TRANSPARENT);
            }
            tv_busy.setText(list.get(position));
            return convertView;
        }
    }

    //中的人员
    class ZhongAdapter extends BaseAdapter{
        private List<String> list;
        private Map<Integer,Boolean> map_zhong;

        public ZhongAdapter(List<String> list, Map<Integer, Boolean> map_zhong) {
            this.list = list;
            this.map_zhong = map_zhong;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv_zhong;
            if (convertView==null){
                convertView = LayoutInflater.from(GdpsAddPeopleActivity.this).inflate(R.layout.listview_addpeople_zhong_item,null);
                tv_zhong = (TextView) convertView.findViewById(R.id.tv_add_zhong_item);
                convertView.setTag(tv_zhong);
            }else {
                tv_zhong = (TextView) convertView.getTag();
            }
            if ((map_zhong!=null)&&map_zhong.keySet().contains(position)){
            if (map_zhong.get(position)){
                tv_zhong.setBackgroundColor(Color.BLUE);
            }}else{
                tv_zhong.setBackgroundColor(Color.TRANSPARENT);
            }
            tv_zhong.setText(list.get(position));
            return convertView;
        }
    }

    //闲的人员
    class XianAdapter extends BaseAdapter{
        private List<String> list;
        private Map<Integer,Boolean> map_xian;

        public XianAdapter(List<String> list, Map<Integer, Boolean> map_xian) {
            this.list = list;
            this.map_xian = map_xian;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv_xian;
            if (convertView==null){
                convertView = LayoutInflater.from(GdpsAddPeopleActivity.this).inflate(R.layout.listview_addpeople_xian_item,null);
                tv_xian = (TextView) convertView.findViewById(R.id.tv_add_xian_item);
                convertView.setTag(tv_xian);
            }else {
                tv_xian = (TextView) convertView.getTag();
            }
            if ((map_xian!=null)&&map_xian.keySet().contains(position)){
            if (map_xian.get(position)){
                tv_xian.setBackgroundColor(Color.BLUE);
            }}else{
                tv_xian.setBackgroundColor(Color.TRANSPARENT);
            }
            tv_xian.setText(list.get(position));
            return convertView;
        }
    }
}

package com.yf.bx.tms.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.MainAdapter;
import com.yf.bx.tms.bean.MainBean;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import static com.yf.bx.tms.R.drawable.banner_11;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener{

    private ImageView iv_banner1,iv_banner2,iv_banner3,iv_banner4;
    private boolean isChecked1,isChecked2,isChecked3,isChecked4;
    private TextView tv_notice ;
    private ListView lv_main;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_banner1 = (ImageView) findViewById(R.id.iv_main_banner1);
        iv_banner2 = (ImageView) findViewById(R.id.iv_main_banner2);
        iv_banner3 = (ImageView) findViewById(R.id.iv_main_banner3);
        iv_banner4 = (ImageView) findViewById(R.id.iv_main_banner4);
        tv_notice = (TextView) findViewById(R.id.tv_main_tip);
        lv_main = (ListView) findViewById(R.id.lv_main);
        list = new ArrayList<>();
        iv_banner1.setOnClickListener(this);
        iv_banner2.setOnClickListener(this);
        iv_banner3.setOnClickListener(this);
        iv_banner4.setOnClickListener(this);
        tv_notice.setOnClickListener(this);

        list.add("信息办公设备工单");
        list.add("光纤可视化");
        list.add("通信巡检");
        list.add("通信设备查询");
        MainAdapter mainAdapter = new MainAdapter(this,list);
        lv_main.setAdapter(mainAdapter);
        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String type = list.get(position);//.getType
                //根据类型判断跳转界面
                Intent intent = null;
                if ("信息办公设备工单".equals(type)){
                    intent = new Intent(MainActivity.this,XxbgActivity.class);}
                else if ("光纤可视化".equals(type)){
                    intent = new Intent(MainActivity.this,GqkshActivity.class);}
                else if ("通信巡检".equals(type)){
                    intent = new Intent(MainActivity.this,TxxjActivity.class);}
                else if ("通信设备查询".equals(type)){
                    intent = new Intent(MainActivity.this,TxsbcxActivity.class);}
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_main_banner1:
                if (!isChecked1){
                    isChecked1 = true;
                    iv_banner1.setImageResource(R.drawable.banner_11);
                }else {
                    Intent intent = new Intent(MainActivity.this,XxbgActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.iv_main_banner2:
                if (!isChecked2){
                    isChecked2 = true;
                    iv_banner2.setImageResource(R.drawable.banner_22);
                }else {
                    Intent intent = new Intent(MainActivity.this,GqkshActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.iv_main_banner3:
                if (!isChecked3){
                    isChecked3 = true;
                    iv_banner3.setImageResource(R.drawable.banner_33);
                }else {
                    Intent intent = new Intent(MainActivity.this,TxxjActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.iv_main_banner4:
                if (!isChecked4){
                    isChecked4 = true;
                    iv_banner4.setImageResource(R.drawable.banner_44);
                }else {
                    Intent intent = new Intent(MainActivity.this,TxsbcxActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.tv_main_tip:

                break;
        }
    }
}

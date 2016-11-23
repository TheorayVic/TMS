package com.yf.bx.tms.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.TxxjFragmentPagerAdapter;
import com.yf.bx.tms.fragment.CqjywFragment;
import com.yf.bx.tms.fragment.FxwtFragment;
import com.yf.bx.tms.fragment.GzzdFragment;
import com.yf.bx.tms.fragment.XjywFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**通信巡检界面
 * Created by 123 on 2016/10/25.
 */

public class TxxjActivity extends AutoLayoutActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{

    private final static String TAG = "TxxjActivity";
    private ImageButton ib_back;
    private TextView tv_notice,tv_top;
    private RadioGroup rg_txxj;
    private RadioButton rb_xjyw,rb_cqjyw,rb_fxwt,rb_gzzd;
    private ViewPager viewPager;
    private FragmentTransaction fragmentTransaction;
    private TxxjFragmentPagerAdapter tfpadapter;
    private FragmentManager fm;
    private List<Fragment> fragments;
    private XjywFragment xjywFragment;
    private CqjywFragment cqjywFragment;
    private FxwtFragment fxwtFragment;
    private GzzdFragment gzzdFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txxj);
        fm = getSupportFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        initView();
        initData();
        initListener();
    }

    private void initView() {
        rg_txxj = (RadioGroup) findViewById(R.id.txxj_rg);
        rb_xjyw = (RadioButton) findViewById(R.id.rb_txxj_xjyw);
        rb_cqjyw = (RadioButton) findViewById(R.id.rb_txxj_cqjyw);
        rb_fxwt = (RadioButton) findViewById(R.id.rb_txxj_fxwt);
        rb_gzzd = (RadioButton) findViewById(R.id.rb_txxj_gzzd);
        ib_back = (ImageButton) findViewById(R.id.ib_txxj_back);
        tv_notice = (TextView) findViewById(R.id.tv_txxj_notice);
        tv_top = (TextView) findViewById(R.id.tv_txxj_top);
        viewPager = (ViewPager) findViewById(R.id.viewPager_txxj);
        rb_xjyw.setChecked(true);
        tv_top.setText("通信检修");
    }

    private void initData(){
        fragments = new ArrayList<>();
        xjywFragment = new XjywFragment();
        cqjywFragment = new CqjywFragment();
        fxwtFragment = new FxwtFragment();
        gzzdFragment = new GzzdFragment();
        fragments.add(xjywFragment);
        fragments.add(cqjywFragment);
        fragments.add(fxwtFragment);
        fragments.add(gzzdFragment);
        Log.i(TAG, "initData: fragments:"+fragments.size());
        tfpadapter = new TxxjFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(tfpadapter);
    }

    private void initListener(){
        rg_txxj.setOnCheckedChangeListener(this);
        tv_notice.setOnClickListener(this);
        ib_back.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ib_txxj_back:
                finish();
                break;
            case R.id.tv_txxj_notice:

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rb_txxj_xjyw:
                tv_top.setText("通信检修");
                viewPager.setCurrentItem(0);
                Log.i(TAG, "onCheckedChanged: fagments[0]:"+fragments.get(0));
                break;
            case R.id.rb_txxj_cqjyw:
                tv_top.setText("通信检修");
                viewPager.setCurrentItem(1);
                Log.i(TAG, "onCheckedChanged: fagments[1]:"+fragments.get(1));
                break;
            case R.id.rb_txxj_fxwt:
                tv_top.setText("巡检结果核查");
                viewPager.setCurrentItem(2);
                Log.i(TAG, "onCheckedChanged: fagments[2]:"+fragments.get(2));
                break;
            case R.id.rb_txxj_gzzd:
                tv_top.setText("规章制度和标准规范");
                viewPager.setCurrentItem(3);
                Log.i(TAG, "onCheckedChanged: fagments[3]:"+fragments.get(3));
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
           //获得当前ViewPager对应的RadioButton
        RadioButton radioButton = (RadioButton) rg_txxj.getChildAt(position);
        radioButton.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

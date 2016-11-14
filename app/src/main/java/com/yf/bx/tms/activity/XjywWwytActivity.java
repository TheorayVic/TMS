package com.yf.bx.tms.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.TxxjFragmentPagerAdapter;
import com.yf.bx.tms.fragment.xjyw_wwyt.BzFragment;
import com.yf.bx.tms.fragment.xjyw_wwyt.GwFragment;
import com.yf.bx.tms.fragment.xjyw_wwyt.JxFragment;
import com.yf.bx.tms.fragment.xjyw_wwyt.LcFragment;
import com.yf.bx.tms.fragment.xjyw_wwyt.ZdFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;
//巡检业务 五位一体界面
public class XjywWwytActivity extends AutoLayoutActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener{

    private RadioGroup rg;
    private RadioButton rb1;
    private ViewPager viewPager;
    private TxxjFragmentPagerAdapter adapter;
    private List<Fragment> fragmentList;
    private BzFragment bz;
    private GwFragment gw;
    private JxFragment jx;
    private LcFragment lc;
    private ZdFragment zd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xjyw_wwyt);
        rg = (RadioGroup)findViewById(R.id.rg_xjyw_wwyt);
        rb1 = (RadioButton)findViewById(R.id.rb_ksxj_wwyt_bz);
        viewPager = (ViewPager) findViewById(R.id.viewPager_xjyw_wwyt);
        fragmentList = new ArrayList<>();
        bz = new BzFragment();
        gw = new GwFragment();
        jx = new JxFragment();
        lc = new LcFragment();
        zd = new ZdFragment();
        fragmentList.add(bz);
        fragmentList.add(gw);
        fragmentList.add(jx);
        fragmentList.add(lc);
        fragmentList.add(zd);
        adapter = new TxxjFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        rg.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
        rb1.setChecked(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
           RadioButton radioButton = (RadioButton) rg.getChildAt(position);
               radioButton.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rb_ksxj_wwyt_bz:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_ksxj_wwyt_gw:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_ksxj_wwyt_jx:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rb_ksxj_wwyt_lc:
                viewPager.setCurrentItem(3);
                break;
            case R.id.rb_ksxj_wwyt_zd:
                viewPager.setCurrentItem(4);
                break;
        }
    }
}

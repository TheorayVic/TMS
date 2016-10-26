package com.yf.bx.tms.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.XxbgFramentPagerAdapter;
import com.yf.bx.tms.fragment.AddGdtbFragment;
import com.yf.bx.tms.fragment.GdclFragment;
import com.yf.bx.tms.fragment.GdpsFragment;
import com.yf.bx.tms.fragment.GdtbFragment;
import com.yf.bx.tms.fragment.ReplaceFragmentUtils;
import com.yf.bx.tms.fragment.WwytpjFragment;
import com.yf.bx.tms.fragment.YhpjFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/10/25.
 */

public class XxbgActivity extends AutoLayoutActivity implements View.OnClickListener ,
        RadioGroup.OnCheckedChangeListener{

    private GdtbFragment gdtbFragment;
    private GdpsFragment gdpsFragment;
    private GdclFragment gdclFragment;
    private YhpjFragment yhpjFragment;
    private WwytpjFragment wwytpjFragment;

    private AddGdtbFragment addGdtbFragment;
    private ImageButton ib_back,ib_wwyt;
    private TextView tv_notice;
    private RadioGroup rg_xxbg;
    private ViewPager viewPager;
    private RadioButton rb_gdtb,rb_gdps,rb_gdcl,rb_yhpj,rb_wwytpj;
    private List<Fragment> fragments;
    private XxbgFramentPagerAdapter xxbgFramentPagerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxbg);
        initView();
        initData();
        initListener();
    }



    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager_xxbg);
        ib_back = (ImageButton) findViewById(R.id.ib_xxbg_back);
        ib_wwyt = (ImageButton) findViewById(R.id.ib_xxbg_wwyt);
        rb_gdtb = (RadioButton) findViewById(R.id.rb_xxbg_gdtb);
        rb_gdps = (RadioButton) findViewById(R.id.rb_xxbg_gdps);
        rb_gdcl = (RadioButton) findViewById(R.id.rb_xxbg_gdcl);
        rb_yhpj = (RadioButton) findViewById(R.id.rb_xxbg_yhpj);
        rb_wwytpj = (RadioButton) findViewById(R.id.rb_xxbg_wwytpj);
        rg_xxbg = (RadioGroup) findViewById(R.id.xxbg_rg);
    }

    private void initData() {
        fragments = new ArrayList<>();
        gdtbFragment = new GdtbFragment();
        gdpsFragment = new GdpsFragment();
        gdclFragment = new GdclFragment();
        yhpjFragment = new YhpjFragment();
        wwytpjFragment = new WwytpjFragment();
        addGdtbFragment = new AddGdtbFragment();
        fragments.add(gdtbFragment);
        fragments.add(gdpsFragment);
        fragments.add(gdclFragment);
        fragments.add(yhpjFragment);
        fragments.add(wwytpjFragment);
        fragments.add(addGdtbFragment);
        xxbgFramentPagerAdapter = new XxbgFramentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(xxbgFramentPagerAdapter);
    }

    private void initListener() {
        ib_back.setOnClickListener(this);
        ib_wwyt.setOnClickListener(this);
        rg_xxbg.setOnCheckedChangeListener(this);
        gdtbFragment.setOnButtonClick(new GdtbFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
              viewPager.setCurrentItem(5);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_xxbg_back:
                finish();
                break;
            case R.id.ib_xxbg_wwyt:

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_xxbg_gdtb:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.rb_xxbg_gdps:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.rb_xxbg_gdcl:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.rb_xxbg_yhpj:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.rb_xxbg_wwytpj:
                    viewPager.setCurrentItem(4);
                    break;
            }
    }
}

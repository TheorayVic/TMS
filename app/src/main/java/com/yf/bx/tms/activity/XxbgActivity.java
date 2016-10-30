package com.yf.bx.tms.activity;


import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.adapter.XxbgFramentPagerAdapter;
import com.yf.bx.tms.fragment.AddGdtbFragment;
import com.yf.bx.tms.fragment.CLGdclFragment;
import com.yf.bx.tms.fragment.GdclFragment;
import com.yf.bx.tms.fragment.GdpsFragment;
import com.yf.bx.tms.fragment.GdtbFragment;
import com.yf.bx.tms.fragment.ReplaceFragmentUtils;
import com.yf.bx.tms.fragment.WwytpjFragment;
import com.yf.bx.tms.fragment.YhpjFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.IOException;
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
    private CLGdclFragment clGdclFragment;
    private ImageButton ib_back,ib_wwyt;
    private TextView tv_notice;
    private RadioGroup rg_xxbg;
    private RadioButton rb_gdtb,rb_gdps,rb_gdcl,rb_yhpj,rb_wwytpj;
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
        gdtbFragment = new GdtbFragment();
        gdpsFragment = new GdpsFragment();
        gdclFragment = new GdclFragment();
        yhpjFragment = new YhpjFragment();
        wwytpjFragment = new WwytpjFragment();
        addGdtbFragment = new AddGdtbFragment();
        clGdclFragment = new CLGdclFragment();
    }

    private void initListener() {
        ib_back.setOnClickListener(this);
        ib_wwyt.setOnClickListener(this);
        rg_xxbg.setOnCheckedChangeListener(this);
        gdtbFragment.setOnButtonClick(new GdtbFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
                ReplaceFragmentUtils.replaceF(XxbgActivity.this,addGdtbFragment,false,R.id.framelayout_xxbg);
            }
        });

        gdclFragment.setOnButtonClick(new GdclFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
                ReplaceFragmentUtils.replaceF(XxbgActivity.this,clGdclFragment,false,R.id.framelayout_xxbg);
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
                Intent intent =new Intent(this,AddWwytActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_xxbg_gdtb:
                   ReplaceFragmentUtils.replaceF(this,gdtbFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_gdps:
                    ReplaceFragmentUtils.replaceF(this,gdpsFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_gdcl:
                    ReplaceFragmentUtils.replaceF(this,gdclFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_yhpj:
                    ReplaceFragmentUtils.replaceF(this,yhpjFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_wwytpj:
                    ReplaceFragmentUtils.replaceF(this,wwytpjFragment,false,R.id.framelayout_xxbg);
                    break;
            }

    }

    //接受工单派送中点击item的派送工单后返回的数据,并通知adapter，然后提交给服务器，
    // 再次请求数据时已经改变
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       //返回分配人员的名字
        if (requestCode==100&&resultCode==RESULT_OK){
        if (null!=data){
        String result = data.getExtras().getString("result");
        }
        }

        //请求码400 从图库中选择 ，300 拍照
        if (requestCode==300&&resultCode==RESULT_OK){
            Bundle bundle =  data.getExtras();
            if (bundle!=null){
            Bitmap bitmap = (Bitmap) bundle.get("data");}
        }else if (requestCode==400&&resultCode==RESULT_OK){
            ContentResolver picResolver = getContentResolver();
            Uri picUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(picResolver,picUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            Bundle bundle = data.getExtras();
//            bitmap =  bundle.getParcelable("data");
        }
    }
}

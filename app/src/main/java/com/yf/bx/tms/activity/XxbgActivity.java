package com.yf.bx.tms.activity;


import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
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
import com.yf.bx.tms.fragment.AddGdtbFragment;
import com.yf.bx.tms.fragment.CLGdclFragment;
import com.yf.bx.tms.fragment.EditGdtbFragment;
import com.yf.bx.tms.fragment.GdclFragment;
import com.yf.bx.tms.fragment.GdpsFragment;
import com.yf.bx.tms.fragment.GdtbFragment;
import com.yf.bx.tms.fragment.HxclFragment;
import com.yf.bx.tms.fragment.PjYhpjFragment;
import com.yf.bx.tms.fragment.ReplaceFragmentUtils;
import com.yf.bx.tms.fragment.SearchFragment;
import com.yf.bx.tms.fragment.WwytpjFragment;
import com.yf.bx.tms.fragment.YhpjFragment;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2016/10/25.
 */

public class XxbgActivity extends AutoLayoutActivity implements View.OnClickListener ,
        RadioGroup.OnCheckedChangeListener{

    private static final String TAG = "XxbgActivity";
    private GdtbFragment gdtbFragment;
    private GdpsFragment gdpsFragment;
    private GdclFragment gdclFragment;
    private YhpjFragment yhpjFragment;
    private PjYhpjFragment pjYhpjFragment;
    private WwytpjFragment wwytpjFragment;
    private AddGdtbFragment addGdtbFragment;
    private EditGdtbFragment editGdtbFragment;
    private CLGdclFragment clGdclFragment;
    private SearchFragment searchFragment;
    private HxclFragment hxclFragment;
    private ImageButton ib_back,ib_wwyt,ib_search;
    private TextView tv_notice;
    private RadioGroup rg_xxbg;
    private RadioButton rb_gdtb,rb_gdps,rb_gdcl,rb_yhpj,rb_wwytpj;
   // private XxbgFramentPagerAdapter xxbgFramentPagerAdapter;

    private String imagename;//拍照或从图库中取出，照片名字
    private boolean
            isSD = Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED);;//是否存在SD卡
   private Bundle addGdtbFragmentBundle = new Bundle();

    private FragmentTransaction fragmentTransaction;
    private List<Fragment> fragments;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxbg);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        initView();
        initData();
        initListener();
        fragments = getSupportFragmentManager().getFragments();

        //根据登录人权限判断展示页面

    }

    private void initView() {
        ib_back = (ImageButton) findViewById(R.id.ib_xxbg_back);
        ib_wwyt = (ImageButton) findViewById(R.id.ib_xxbg_wwyt);
        ib_search = (ImageButton) findViewById(R.id.ib_xxbg_search);
        rb_gdtb = (RadioButton) findViewById(R.id.rb_xxbg_gdtb);
        rb_gdps = (RadioButton) findViewById(R.id.rb_xxbg_gdps);
        rb_gdcl = (RadioButton) findViewById(R.id.rb_xxbg_gdcl);
        rb_yhpj = (RadioButton) findViewById(R.id.rb_xxbg_yhpj);
        rb_wwytpj = (RadioButton) findViewById(R.id.rb_xxbg_wwytpj);
        rg_xxbg = (RadioGroup) findViewById(R.id.xxbg_rg);
        tv_notice = (TextView) findViewById(R.id.tv_gdtb_notice);
    }

    private void initData() {
        gdtbFragment = new GdtbFragment();
        gdpsFragment = new GdpsFragment();
        gdclFragment = new GdclFragment();
        yhpjFragment = new YhpjFragment();
        wwytpjFragment = new WwytpjFragment();
        addGdtbFragment = new AddGdtbFragment();
        editGdtbFragment = new EditGdtbFragment();
        clGdclFragment = new CLGdclFragment();
        searchFragment = new SearchFragment();
        hxclFragment = new HxclFragment();
        pjYhpjFragment = new PjYhpjFragment();
    }

    private void initListener() {
        ib_back.setOnClickListener(this);
        ib_wwyt.setOnClickListener(this);
        ib_search.setOnClickListener(this);
        rg_xxbg.setOnCheckedChangeListener(this);
        gdtbFragment.setOnButtonClick(new GdtbFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
             //   ReplaceFragmentUtils.replaceF(XxbgActivity.this,addGdtbFragment,false,R.id.framelayout_xxbg);
                if (fragments!=null&&(fragments.size()==2)){
                    fragments.remove(1);
                }

                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.framelayout_xxbg, addGdtbFragment);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }

            @Override
            public void onClick2(View view) {
                if (fragments!=null&&(fragments.size()==2)){
                    fragments.remove(1);
                }
                FragmentTransaction fragmentTransaction3= getSupportFragmentManager().beginTransaction();
                fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.framelayout_xxbg, editGdtbFragment);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
            }
        });

        gdclFragment.setOnButtonClick(new GdclFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
              //  ReplaceFragmentUtils.replaceF(XxbgActivity.this,clGdclFragment,false,R.id.framelayout_xxbg);
                FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.framelayout_xxbg, clGdclFragment);
                fragmentTransaction4.addToBackStack(null);
                fragmentTransaction4.commit();
            }
        });

        addGdtbFragment.setOnReplaceListener(new AddGdtbFragment.OnReplaceListener() {
            @Override
            public void onReplace(View view) {
                if (fragments!= null&&fragments.size() > 0) {
                    fragments.clear();
                }
                FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction5.replace(R.id.framelayout_xxbg, gdtbFragment);
                fragmentTransaction5.commit();
            }

        });

        editGdtbFragment.setOnReplaceListener(new EditGdtbFragment.OnReplaceListener() {
            @Override
            public void onReplace(View view) {
                if (fragments!= null&&fragments.size() > 0) {
                    fragments.clear();
                }
                FragmentTransaction fragmentTransaction8 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction8 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction8.replace(R.id.framelayout_xxbg, gdtbFragment);
                fragmentTransaction8.commit();
            }

            @Override
            public void onReplace2(View view) {
                if (fragments!= null&&fragments.size() > 0) {
                    fragments.clear();
                }
                FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction6.replace(R.id.framelayout_xxbg, gdtbFragment);
                fragmentTransaction6.commit();}
        });

        clGdclFragment.setOnReplaceListener(new CLGdclFragment.OnReplaceListener() {
            @Override
            public void onReplace(View view) {
                if (fragments!=null&&(fragments.size()==2)){
                    fragments.remove(1);
                }
                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_xxbg, hxclFragment);
          //      fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            @Override
            public void onReplace2(View view) {
                if (fragments!= null&&fragments.size() > 0) {
                    fragments.clear();
                }
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_xxbg, gdclFragment);
                fragmentTransaction.commit();
            }
        });

        hxclFragment.setOnReplaceListener(new HxclFragment.OnReplaceListener() {
            @Override
            public void onReplace(View view) {
                if (fragments!= null&&fragments.size() > 0) {
                    fragments.clear();
                }
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_xxbg, gdclFragment);
                fragmentTransaction.commit();
            }
        });

        yhpjFragment.setOnButtonClick(new YhpjFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.replace(R.id.framelayout_xxbg, pjYhpjFragment);
                fragmentTransaction4.addToBackStack(null);
                fragmentTransaction4.commit();
            }
        });

        pjYhpjFragment.setOnButtonClick(new PjYhpjFragment.OnAddClick() {
            @Override
            public void onClick(View view) {
                if (fragments!= null&&fragments.size() > 0) {
                    fragments.clear();
                }
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_xxbg, yhpjFragment);
                fragmentTransaction.commit();
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
            case R.id.ib_xxbg_search:
                ib_wwyt.setVisibility(View.INVISIBLE);
                ReplaceFragmentUtils.replaceF(this,searchFragment,false,R.id.framelayout_xxbg);
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (fragments!= null&&fragments.size() > 0) {
            fragments.clear();
        }
            switch (checkedId){
                case R.id.rb_xxbg_gdtb:
                    ib_wwyt.setVisibility(View.INVISIBLE);
                   ReplaceFragmentUtils.replaceF(this,gdtbFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_gdps:
                    ib_wwyt.setVisibility(View.VISIBLE);
                    ReplaceFragmentUtils.replaceF(this,gdpsFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_gdcl:
                    ib_wwyt.setVisibility(View.VISIBLE);
                    ReplaceFragmentUtils.replaceF(this,gdclFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_yhpj:
                    ib_wwyt.setVisibility(View.INVISIBLE);
                    ReplaceFragmentUtils.replaceF(this,yhpjFragment,false,R.id.framelayout_xxbg);
                    break;
                case R.id.rb_xxbg_wwytpj:
                    ib_wwyt.setVisibility(View.INVISIBLE);
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
            Toast.makeText(this,"工单派送成功",Toast.LENGTH_SHORT).show();
        }
        }

        //请求码400 从图库中选择 ，300 拍照
        Bundle imgBundle = new Bundle();
     //   String filename = createMir();

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前时间，进一步转化为字符串
        Date date =new Date();
        String str=format.format(date);
        String filename = str+".jpg";
        Log.i(TAG, "onActivityResult: createMir().filename:"+filename);
        File file = new File(filename);
        if (requestCode==300&&resultCode==RESULT_OK){
            Bundle bundle =  data.getExtras();
            if (bundle!=null){
            Bitmap bitmap = (Bitmap) bundle.get("data");
                if (null!=bitmap){
                compressBmpToFile(bitmap,file);
                }
            }
        }else if (requestCode==400&&resultCode==RESULT_OK){
            ContentResolver picResolver = getContentResolver();
            Uri picUri = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(picResolver,picUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null!=bitmap){
                compressBmpToFile(bitmap,file);
                Log.i(TAG, "onActivityResult: bitmap!=null");
            }
        }

//        imgBundle.putString("bitmap",filename);
//        addGdtbFragment.setArguments(imgBundle);

        Log.i(TAG, "onActivityResult: file:"+file.toString());
        Intent intent1 =new Intent();
        intent1.setAction("addPhoto");
        intent1.putExtra("bitmap",filename);
        Log.i(TAG, "onActivityResult: filename:"+filename);
        sendBroadcast(intent1);
     }

    //图片压缩,压缩到小于100k
    public void compressBmpToFile(Bitmap bmp, File file){
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         int options =80;//个人喜欢从80开始,  
         bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
         while (baos.toByteArray().length / 1024 > 100) {
             baos.reset();
             options-= 10;
             bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
             }
         try {
             FileOutputStream fos = new FileOutputStream(file);
             fos.write(baos.toByteArray());
             fos.flush();
             fos.close();
             } catch (Exception e){
             e.printStackTrace();
             }
    }

    //创建文件夹，存储图片
    public String createMir(){
        String fileName = null;
        if (isSD){
        File sd=Environment.getExternalStorageDirectory();
         String path=sd.getPath()+"/myimage/";
         File files=new File(path);
         if(!files.exists())
         files.mkdir();
             SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前时间，进一步转化为字符串
             Date date =new Date();
             String str=format.format(date);
             fileName = path+str+".jpg";
        }
        return fileName;
    }

}

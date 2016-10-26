package com.yf.bx.tms.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

import static com.yf.bx.tms.R.drawable.banner_11;

public class MainActivity extends AutoLayoutActivity implements View.OnClickListener{

    private ImageView iv_banner1,iv_banner2,iv_banner3,iv_banner4;
    private boolean isChecked1,isChecked2,isChecked3,isChecked4; ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_banner1 = (ImageView) findViewById(R.id.iv_main_banner1);
        iv_banner2 = (ImageView) findViewById(R.id.iv_main_banner2);
        iv_banner3 = (ImageView) findViewById(R.id.iv_main_banner3);
        iv_banner4 = (ImageView) findViewById(R.id.iv_main_banner4);
        iv_banner1.setOnClickListener(this);
        iv_banner2.setOnClickListener(this);
        iv_banner3.setOnClickListener(this);
        iv_banner4.setOnClickListener(this);
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
        }
    }
}

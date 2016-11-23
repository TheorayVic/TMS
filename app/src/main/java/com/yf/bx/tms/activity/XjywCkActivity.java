package com.yf.bx.tms.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

//巡检业务 查看界面
public class XjywCkActivity extends AutoLayoutActivity implements View.OnClickListener {

    private ImageButton ib_back;
    private TextView tv_notice,tv_title;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7;
    private LinearLayout ll1,ll2,ll3,ll4,ll5,ll6,ll7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xjyw_ck);
        initView();
        Resources resources = getResources();
        initListener();
        ll2.setBackgroundColor(resources.getColor(R.color.ck_blue));
        iv2.setImageDrawable(resources.getDrawable(R.drawable.xjyw_ck_item_xjz2));
        ll3.setBackgroundColor(resources.getColor(R.color.ck_red));
        iv3.setImageDrawable(resources.getDrawable(R.drawable.xjyw_ck_item_gj2));
    }


    private void initView() {
        ib_back = (ImageButton) findViewById(R.id.ib_xjyw_ck_back);
        tv_notice = (TextView) findViewById(R.id.tv_xjyw_ck_notice);
        tv_title = (TextView) findViewById(R.id.xjyw_ck_top_title);
        iv1 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_jfhj);
        iv2 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_txdy1);
        iv3 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_txdy2);
        iv4 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_cssb);
        iv5 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_jhsb);
        iv6 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_pxsb);
        iv7 = (ImageView) findViewById(R.id.iv_xjyw_ck_item_mxjgl);
        ll1 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_jfhj);
        ll2 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_txdy1);
        ll3 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_txdy2);
        ll4 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_cssb);
        ll5 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_jhsb);
        ll6 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_pxsb);
        ll7 = (LinearLayout) findViewById(R.id.ll_xjyw_ck_item_mxjgl);
    }

    private void initListener() {
        tv_title.setOnClickListener(this);
        tv_notice.setOnClickListener(this);
        ib_back.setOnClickListener(this);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);
        ll6.setOnClickListener(this);
        ll7.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,KsxjActivity.class);
        switch (v.getId()){
            case R.id.ib_xjyw_ck_back:
                finish();
                break;
            case R.id.tv_xjyw_ck_notice:

                break;
            case R.id.xjyw_ck_top_title:
                //
                tv_title.setText("500KV大泽变");
                break;
            case R.id.ll_xjyw_ck_item_jfhj:
                intent.putExtra("ck",1);
                startActivity(intent);
                break;
            case R.id.ll_xjyw_ck_item_txdy1:
                intent.putExtra("ck",2);
                startActivity(intent);
                break;
            case R.id.ll_xjyw_ck_item_txdy2:
                intent.putExtra("ck",3);
                startActivity(intent);
                break;
            case R.id.ll_xjyw_ck_item_cssb:
                intent.putExtra("ck",4);
                startActivity(intent);
                break;
            case R.id.ll_xjyw_ck_item_jhsb:
                intent.putExtra("ck",5);
                startActivity(intent);
                break;
            case R.id.ll_xjyw_ck_item_pxsb:
                intent.putExtra("ck",6);
                startActivity(intent);
                break;
            case R.id.ll_xjyw_ck_item_mxjgl:
                intent.putExtra("ck",7);
                startActivity(intent);
                break;

        }
    }
}

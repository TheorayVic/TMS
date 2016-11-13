package com.yf.bx.tms.activity;

import android.os.Bundle;
import android.view.MotionEvent;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;
//信息办公设备工单中 的五位一体，不是五位一体评价
public class AddWwytActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wwyt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}

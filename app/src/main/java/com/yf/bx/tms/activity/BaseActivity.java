package com.yf.bx.tms.activity;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by 洋 on 2016/11/9.
 */

public class BaseActivity extends AutoLayoutActivity {
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }
}

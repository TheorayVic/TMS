package com.yf.bx.tms.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.yf.bx.tms.R;

/**
 * Created by bai on 2016/11/14.
 */

public class PhotoUtils1 extends PopupWindow{


    private ImageView iv_del,iv_edit;


    public PhotoUtils1() {
    }

    public PhotoUtils1(Context context, View menuView, View.OnClickListener onClickListener) {
        super(context);
        iv_edit = (ImageView) menuView.findViewById(R.id.picker_edit);
        iv_del = (ImageView) menuView.findViewById(R.id.picker_del);

        iv_edit.setOnClickListener(onClickListener);
        iv_del.setOnClickListener(onClickListener);

        //设置显示内容的属性
        this.setContentView(menuView);
        //设置弹出的宽和高
        this.setWidth(menuView.getLayoutParams().MATCH_PARENT);
        this.setHeight(menuView.getLayoutParams().MATCH_PARENT);
        //设置可以获得焦点
        this.setFocusable(true);
        //添加背景颜色
        //     this.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffcc")));
        //设置弹出框外围不能被点击
        this.setOutsideTouchable(true);
    }
}
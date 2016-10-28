package com.yf.bx.tms.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.yf.bx.tms.R;

/**
 * Created by 123 on 2016/10/28.
 */

public class PhotoUtils extends PopupWindow{


    private Button popupBtn_camere, popupBtn_picture, popupBtn_cancel;


        public PhotoUtils() {
        }

        public PhotoUtils(Context context, View menuView, View.OnClickListener onClickListener) {
            super(context);
            popupBtn_camere = (Button) menuView.findViewById(R.id.popup_btn_camera);
            popupBtn_picture = (Button) menuView.findViewById(R.id.popup_btn_picture);
            popupBtn_cancel = (Button) menuView.findViewById(R.id.popup_btn_cancel);

            popupBtn_camere.setOnClickListener(onClickListener);
            popupBtn_picture.setOnClickListener(onClickListener);
            popupBtn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //让PopUpWindow消失
                    dismiss();
                }
            });
            //设置显示内容的属性
            this.setContentView(menuView);
            //设置弹出的宽和高
            this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            //设置可以获得焦点
            this.setFocusable(true);
            //添加背景颜色
       //     this.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffcc")));
            //设置弹出框外围不能被点击
            this.setOutsideTouchable(true);
        }
    }


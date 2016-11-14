package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;

/**
 * Created by 123 on 2016/11/9.
 */

public class Txdy1Fragment extends KsxjCommonFra {

    private View view;
    private EditText et_yy6,et_yy9;
    private ImageButton ib5;
    public Txdy1Fragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_txdy1,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }

    private void initview() {
        rb_left1.setText("正常");
        rb_right1.setText("不正常");
        rb_left2.setText("正常");
        rb_right2.setText("不正常");
        rb_left3.setText("正常");
        rb_right3.setText("不正常");
        rb_left4.setText("正常");
        rb_right4.setText("不正常");
        tv_jcxm1.setText("防雷器件");
        tv_jcxm2.setText("交流输入投入状态");
        tv_jcxm3.setText("负载空开投入状态");
        tv_jcxm4.setText("整流模块风扇状态");
        et_yy6 = (EditText) view.findViewById(R.id.et_txdy1_yy6);
        et_yy9 = (EditText) view.findViewById(R.id.et_txdy1_yy9);
        ib5 = (ImageButton) view.findViewById(R.id.ib_txdy1_photo6);
        et_yy6.setOnTouchListener(this);
        et_yy9.setOnTouchListener(this);
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumptoPicker();
            }
        });
    }
}

package com.yf.bx.tms.fragment;

import android.content.Intent;
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

/**机房环境
 * Created by 123 on 2016/11/9.
 */

public class JfhjFragment extends KsxjCommonFra implements View.OnClickListener {

    private View view;
    private EditText et6,et7,et8;
    private ImageButton ib5,ib6,ib7,ib8;

    public JfhjFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_jhfj,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
        initListener();
    }


    private void initview() {
        rb_left1.setText("正常");
        rb_right1.setText("不正常");
        rb_left2.setText("有");
        rb_right2.setText("无");
        rb_left3.setText("有");
        rb_right3.setText("无");
        rb_left4.setText("正常");
        rb_right4.setText("不正常");
        tv_jcxm1.setText("屋顶墙壁有无漏水");
        tv_jcxm2.setText("是否存放、使用易燃、易爆物品");
        tv_jcxm3.setText("机房内有无小动物行迹");
        tv_jcxm4.setText("驱鼠器工作状态");
        et6 = (EditText) view.findViewById(R.id.et_jfhj_yy6);
        et7 = (EditText) view.findViewById(R.id.et_jfhj_yy7);
        et8 = (EditText) view.findViewById(R.id.et_jfhj_yy8);
        ib5 = (ImageButton) view.findViewById(R.id.ib_jfhj_photo5);
        ib6 = (ImageButton) view.findViewById(R.id.ib_jfhj_photo6);
        ib7 = (ImageButton) view.findViewById(R.id.ib_jfhj_photo7);
        ib8 = (ImageButton) view.findViewById(R.id.ib_jfhj_photo8);
    }

    private void initListener() {
        et6.setOnTouchListener(this);
        et7.setOnTouchListener(this);
        et8.setOnTouchListener(this);
        ib_photo1.setOnClickListener(this);
        ib_photo2.setOnClickListener(this);
        ib_photo3.setOnClickListener(this);
        ib_photo4.setOnClickListener(this);
        ib5.setOnClickListener(this);
        ib6.setOnClickListener(this);
        ib7.setOnClickListener(this);
        ib8.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_photo1:
                break;
            case R.id.ib_photo2:
                break;
            case R.id.ib_photo3:
                break;
            case R.id.ib_photo4:
                break;
            case R.id.ib_jfhj_photo5:
                break;
            case R.id.ib_jfhj_photo6:
                break;
            case R.id.ib_jfhj_photo7:
                break;
            case R.id.ib_jfhj_photo8:
                break;

        }
        jumptoPicker();
    }
}

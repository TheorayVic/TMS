package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.yf.bx.tms.R;

/**门型架光缆
 * Created by 123 on 2016/11/9.
 */

public class MxjglFragment extends KsxjCommonFra {
    private View view;
    private EditText et5;
    private ImageButton ib5;
    public MxjglFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mxjgl,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }
    private void initview() {
        rb_left1.setText("有");
        rb_right1.setText("无");
        rb_left2.setText("正常");
        rb_right2.setText("不正常");
        rb_left3.setText("正常");
        rb_right3.setText("不正常");
        rb_left4.setText("正常");
        rb_right4.setText("不正常");
        tv_jcxm1.setText("落地式接头箱（或接续盒）是否破损、锈蚀，是否密封严紧");
        tv_jcxm2.setText("检查引下光缆金具是否齐全");
        tv_jcxm3.setText("镀锌钢管上口是否密封");
        tv_jcxm4.setText("箱内或余缆架光缆捆扎摆放是否紧凑、整齐、不松弛");
        et5 = (EditText) view.findViewById(R.id.et_mxxgl_y1);
        et5.setOnTouchListener(this);
        ib5 = (ImageButton)view.findViewById(R.id.ib_mxxgl_photo1);
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumptoPicker();
            }
        });
    }
}

package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.photo_picker.PhotoPicker;

/**
 * Created by 123 on 2016/11/9.
 */

public class KsxjCommonFra extends Fragment implements View.OnTouchListener,View.OnClickListener{

    protected RadioGroup rg1,rg2,rg3,rg4;
    protected RadioButton rb_left1,rb_right1,rb_left2,rb_right2,rb_left3,rb_right3,rb_left4,rb_right4;
    protected TextView tv_jcxm1,tv_jcxm2,tv_jcxm3,tv_jcxm4;
    protected TextView tv_save,tv_cancel;
    protected EditText et1,et2,et3,et4;
    protected ImageButton ib_photo1,ib_photo2,ib_photo3,ib_photo4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ksxj_common,null);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rg1 = (RadioGroup) view.findViewById(R.id.rg_jcjg1);
        rg2 = (RadioGroup) view.findViewById(R.id.rg_jcjg2);
        rg3 = (RadioGroup) view.findViewById(R.id.rg_jcjg3);
        rg4 = (RadioGroup) view.findViewById(R.id.rg_jcjg4);
        rb_left1 = (RadioButton) view.findViewById(R.id.rb_jcjg_left1);
        rb_right1 = (RadioButton) view.findViewById(R.id.rb_jcjg_right1);
        rb_left2 = (RadioButton) view.findViewById(R.id.rb_jcjg_left2);
        rb_right2 = (RadioButton) view.findViewById(R.id.rb_jcjg_right2);
        rb_left3 = (RadioButton) view.findViewById(R.id.rb_jcjg_left3);
        rb_right3 = (RadioButton) view.findViewById(R.id.rb_jcjg_right3);
        rb_left4 = (RadioButton) view.findViewById(R.id.rb_jcjg_left4);
        rb_right4 = (RadioButton) view.findViewById(R.id.rb_jcjg_right4);
        tv_jcxm1 = (TextView) view.findViewById(R.id.tv_jcxm1);
        tv_jcxm2 = (TextView) view.findViewById(R.id.tv_jcxm2);
        tv_jcxm3 = (TextView) view.findViewById(R.id.tv_jcxm3);
        tv_jcxm4 = (TextView) view.findViewById(R.id.tv_jcxm4);
        tv_save = (TextView) view.findViewById(R.id.ksxj_save);
        tv_cancel = (TextView) view.findViewById(R.id.ksxj_cancel);
        et1 = (EditText) view.findViewById(R.id.et_yy1);
        et2 = (EditText) view.findViewById(R.id.et_yy2);
        et3 = (EditText) view.findViewById(R.id.et_yy3);
        et4 = (EditText) view.findViewById(R.id.et_yy4);
        ib_photo1 = (ImageButton) view.findViewById(R.id.ib_photo1);
        ib_photo2 = (ImageButton) view.findViewById(R.id.ib_photo2);
        ib_photo3 = (ImageButton) view.findViewById(R.id.ib_photo3);
        ib_photo4 = (ImageButton) view.findViewById(R.id.ib_photo4);

        et1.setOnTouchListener(this);
        et2.setOnTouchListener(this);
        et3.setOnTouchListener(this);
        et4.setOnTouchListener(this);
        ib_photo1.setOnClickListener(this);
        ib_photo2.setOnClickListener(this);
        ib_photo3.setOnClickListener(this);
        ib_photo4.setOnClickListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // 解决scrollView中嵌套EditText导致不能上下滑动的问题  
        v.getParent().requestDisallowInterceptTouchEvent(true);
        switch (event.getAction()&MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_UP:
                v.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return false;
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
        }
        jumptoPicker();
    }
    //跳转拍照照片界面
    public void jumptoPicker(){
        PhotoPicker.builder()
                .setPhotoCount(9)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start(getActivity(), PhotoPicker.REQUEST_CODE);
    }
}

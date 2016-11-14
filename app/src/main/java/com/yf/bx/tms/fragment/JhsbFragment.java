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

import com.yf.bx.tms.R;
import com.yf.bx.tms.photo_picker.PhotoPicker;

/**
 * Created by 123 on 2016/11/9.
 */

public class JhsbFragment extends Fragment implements View.OnTouchListener,
        View.OnClickListener{
    private View view;
    private EditText et1,et2,et3;
    private ImageButton ib1,ib2,ib3;
    public JhsbFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_jhsb,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = (EditText) view.findViewById(R.id.et_jhsb_y1);
        et2 = (EditText) view.findViewById(R.id.et_jhsb_y2);
        et3 = (EditText) view.findViewById(R.id.et_jhsb_y3);

        ib1 = (ImageButton) view.findViewById(R.id.ib_jhsb_photo1);
        ib2 = (ImageButton) view.findViewById(R.id.ib_jhsb_photo2);
        ib3 = (ImageButton) view.findViewById(R.id.ib_jhsb_photo3);
        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        et1.setOnTouchListener(this);
        et2.setOnTouchListener(this);
        et3.setOnTouchListener(this);
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
            case R.id.ib_jhsb_photo1:
                break;
            case R.id.ib_jhsb_photo2:
                break;
            case R.id.ib_jhsb_photo3:
                break;
        }
        PhotoPicker.builder()
                .setPhotoCount(9)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(false)
                .start(getActivity(), PhotoPicker.REQUEST_CODE);

    }
}

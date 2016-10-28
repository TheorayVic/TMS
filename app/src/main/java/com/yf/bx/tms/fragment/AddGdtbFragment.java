package com.yf.bx.tms.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.yf.bx.tms.R;
import com.yf.bx.tms.utils.PhotoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/10/26.
 */

public class AddGdtbFragment extends Fragment implements View.OnClickListener{

    private View view;
    private LinearLayout ll_photo,ll_save,ll_commit;
    private Spinner spinner_wtlx,spinner_jjcd;
    private List<String> list_wtlx = new ArrayList<>();
    private List<String> list_jjcd = new ArrayList<>();

    private View.OnClickListener listener;

    public AddGdtbFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gdtb_add,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ll_photo = (LinearLayout) view.findViewById(R.id.ll_gdtb_add_photo);
        ll_save = (LinearLayout) view.findViewById(R.id.ll_gdtb_add_save);
        ll_commit = (LinearLayout) view.findViewById(R.id.ll_gdtb_add_commit);
        spinner_wtlx = (Spinner) view.findViewById(R.id.tv_gdtb_add_wtlx);
        spinner_jjcd = (Spinner) view.findViewById(R.id.spinner_gdtb_add_jjcd);
        list_jjcd.add("高");
        list_jjcd.add("中");
        list_jjcd.add("低");
        list_wtlx.add("硬件问题");
        list_wtlx.add("软件问题");
        ArrayAdapter<String> adapter_jjcd = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,list_jjcd);
        ArrayAdapter<String> adapter_wtlx = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,list_wtlx);
        spinner_jjcd.setAdapter(adapter_jjcd);
        spinner_wtlx.setAdapter(adapter_wtlx);
        ll_photo.setOnClickListener(this);
        ll_save.setOnClickListener(this);
        ll_commit.setOnClickListener(this);


        listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.popup_btn_camera:
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //剪裁
//                        intent.putExtra("crop","true");//开始剪裁
//                        intent.putExtra("aspectX",2); //设置剪裁的比例
//                        intent.putExtra("aspectY",1);
//                        intent.putExtra("outputX",200); //设置剪裁后的图片大小
//                        intent.putExtra("outputY",100);
                        cameraIntent.putExtra("result-data",true);//返回数据
                        startActivityForResult(cameraIntent,300);
                        break;
                    case R.id.popup_btn_picture:
                        Intent pictureIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        pictureIntent.putExtra("result-data",true);//返回数据
                        startActivityForResult(pictureIntent,400);
                        break;
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_gdtb_add_photo:
                View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.photopopupwindow,null);
                PhotoUtils mPopupwindow = new PhotoUtils(getActivity(),popupView,listener);
                mPopupwindow.showAtLocation(view.findViewById(R.id.ll_gdtb_add_outer), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                break;
            case R.id.ll_gdtb_add_save:
                break;
            case R.id.ll_gdtb_add_commit:
                break;
        }
    };


}

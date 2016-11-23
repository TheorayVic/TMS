package com.yf.bx.tms.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;
import com.yf.bx.tms.R;
import com.yf.bx.tms.utils.PhotoUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**工单提报 编辑界面
 * Created by 123 on 2016/11/1.
 */

public class EditGdtbFragment extends Fragment implements View.OnClickListener{

    private static final String TAG ="EditGdtbFragment";
    private View view;
    private LinearLayout ll_photo,ll_save,ll_commit;
    private Spinner spinner_wtlx,spinner_jjcd;
    private List<String> list_wtlx = new ArrayList<>();
    private List<String> list_jjcd = new ArrayList<>();

    private View.OnClickListener listener;

    private TextView tv_wtfssj,tv_savePhoto;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");

    private StringBuffer imgsb = new StringBuffer();
    private PhotoBroadcastReceiver photoBroadcastReceiver;
    private OnReplaceListener onReplaceListener;

    public EditGdtbFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册广播
        photoBroadcastReceiver = new PhotoBroadcastReceiver();
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("addPhoto");
        getActivity().registerReceiver(photoBroadcastReceiver,intentFilter1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gdtb_edit,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ll_photo = (LinearLayout) view.findViewById(R.id.ll_gdtb_edit_photo);
        ll_save = (LinearLayout) view.findViewById(R.id.ll_gdtb_edit_save);
        ll_commit = (LinearLayout) view.findViewById(R.id.ll_gdtb_edit_commit);
        spinner_wtlx = (Spinner) view.findViewById(R.id.tv_gdtb_edit_wtlx);
        spinner_jjcd = (Spinner) view.findViewById(R.id.spinner_gdtb_edit_jjcd);

        tv_wtfssj = (TextView) view.findViewById(R.id.tv_gdtb_edit_wtfssj);
        tv_savePhoto = (TextView) view.findViewById(R.id.gdtb_edit_savePhoto);
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

        //时间日期选择
        final SlideDateTimeListener listener2 = new SlideDateTimeListener() {

            @Override
            public void onDateTimeSet(Date date)
            {
                // Do something with the date. This Date object contains
                // the date and time that the user has selected.
                String date2 = dateFormat.format(date);
                tv_wtfssj.setText(date2);
            }

            @Override
            public void onDateTimeCancel()
            {
                // Overriding onDateTimeCancel() is optional.
            }
        };

        tv_wtfssj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(getActivity().getSupportFragmentManager())
                        .setListener(listener2)
                        .setInitialDate(new Date())
                        .setIs24HourTime(true)
                        .build()
                        .show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_gdtb_edit_photo:
                View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.photopopupwindow,null);
                PhotoUtils mPopupwindow = new PhotoUtils(getActivity(),popupView,listener);
                mPopupwindow.showAtLocation(view.findViewById(R.id.ll_gdtb_edit_outer), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                break;
            case R.id.ll_gdtb_edit_save:

                //保存后自动返回
                if (onReplaceListener!=null){
                    onReplaceListener.onReplace(ll_save);
                }
                Toast.makeText(getActivity(),"保存成功",Toast.LENGTH_SHORT).show();

                break;
            case R.id.ll_gdtb_edit_commit:


                //提交后自动返回
                if (onReplaceListener!=null){
                    onReplaceListener.onReplace2(ll_commit);
                }
                Toast.makeText(getActivity(),"提交成功",Toast.LENGTH_SHORT).show();

                break;
        }
    };
    public OnReplaceListener getOnReplaceListener(){
        return onReplaceListener;
    }
    public void setOnReplaceListener(OnReplaceListener onReplaceListener){
        this.onReplaceListener = onReplaceListener;
    }

    public interface OnReplaceListener{
        void onReplace(View view);
        void onReplace2(View view);
    }

    //内部广播，接收XxbgActivity发过来的图片
    public class PhotoBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String filename = intent.getStringExtra("bitmap");
            if (null!=filename){
                imgsb.append(filename+";");
                Log.i(TAG, "onReceive: imgsb:"+imgsb.toString());
                tv_savePhoto.setText(imgsb.toString());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(photoBroadcastReceiver);
    }
}

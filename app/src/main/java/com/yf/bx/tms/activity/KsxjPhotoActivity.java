package com.yf.bx.tms.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;


//点击开始检测后照片跳转到此界面
public class KsxjPhotoActivity extends AutoLayoutActivity implements View.OnClickListener,
        View.OnLongClickListener{

    private LinearLayout ll;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9;
    private ImageButton ib_back;
    private Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ksxj_photo);
        initview();
        initListener();
    }

    private void initview() {
        ll = (LinearLayout) findViewById(R.id.ll_ksxj_photo);
        ib_back = (ImageButton) findViewById(R.id.ib_ksxj_photo_back);
        btn_save = (Button) findViewById(R.id.btn_ksxj_photo_save);
        iv1 = (ImageView) findViewById(R.id.ksxj_photo1);
        iv2 = (ImageView) findViewById(R.id.ksxj_photo2);
        iv3 = (ImageView) findViewById(R.id.ksxj_photo3);
        iv4 = (ImageView) findViewById(R.id.ksxj_photo4);
        iv5 = (ImageView) findViewById(R.id.ksxj_photo5);
        iv6 = (ImageView) findViewById(R.id.ksxj_photo6);
        iv7 = (ImageView) findViewById(R.id.ksxj_photo7);
        iv8 = (ImageView) findViewById(R.id.ksxj_photo8);
        iv9 = (ImageView) findViewById(R.id.ksxj_photo9);
    }

    private void initListener() {
        iv1.setOnLongClickListener(this);
        iv2.setOnLongClickListener(this);
        iv3.setOnLongClickListener(this);
        iv4.setOnLongClickListener(this);
        iv5.setOnLongClickListener(this);
        iv6.setOnLongClickListener(this);
        iv7.setOnLongClickListener(this);
        iv8.setOnLongClickListener(this);
        iv9.setOnLongClickListener(this);
        ll.setOnClickListener(this);
        ib_back.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }


    @Override
    public boolean onLongClick(View v) {
      //  Intent intent = new Intent(this,)
        switch (v.getId()){
            case R.id.ksxj_photo1:
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_ksxj_photo:
                //打开相机
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
            case R.id.ib_ksxj_photo_back:
                finish();
                break;
            case R.id.btn_ksxj_photo_save:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==300&&resultCode==RESULT_OK){
            Bundle bundle =  data.getExtras();
            if (bundle!=null){
                Bitmap bitmap = (Bitmap) bundle.get("data");
                if (null!=bitmap){

                }
            }
        }
    }
}

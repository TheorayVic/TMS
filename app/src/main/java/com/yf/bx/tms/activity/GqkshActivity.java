package com.yf.bx.tms.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

import static com.yf.bx.tms.R.id.et_gqksh_tv2;
import static com.yf.bx.tms.R.id.iv_gqksh_tv4;

/**光纤可视化模块
 * Created by 123 on 2016/10/25.
 */

public class GqkshActivity extends AutoLayoutActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gqksh);
        TextView tv1= (TextView) this.findViewById(R.id.tv_gqksh_tv1);
        TextView tv3= (TextView) this.findViewById(R.id.tv_gqksh_tv3);
        final EditText et2 = (EditText) this.findViewById(et_gqksh_tv2);
        final ImageView iv4 = (ImageView) this.findViewById(iv_gqksh_tv4);
        //扫码

        ZXingLibrary.initDisplayOpinion(this);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GqkshActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 300);
            }
        });
        //生成二维码
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textContent = et2.getText().toString();
                if (TextUtils.isEmpty(textContent)) {
                    Toast.makeText(GqkshActivity.this, "您的输入为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
               // et2.setText("");
                Bitmap mBitmap = CodeUtils.createImage(textContent, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                iv4.setImageBitmap(mBitmap);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == 300) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}

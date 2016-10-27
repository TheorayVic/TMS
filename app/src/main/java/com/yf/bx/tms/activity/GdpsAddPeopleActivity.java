package com.yf.bx.tms.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

public class GdpsAddPeopleActivity extends AutoLayoutActivity {

    private ListView lv_busy,lv_zhong,lv_xian;
    private TextView tv_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdps_add_people);
        lv_busy = (ListView) findViewById(R.id.listview_psgd_busy);
        lv_zhong = (ListView) findViewById(R.id.listview_psgd_zhong);
        lv_xian = (ListView) findViewById(R.id.listview_psgd_xian);
        tv_confirm = (TextView) findViewById(R.id.tv_psgd_confirm);

        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result","试验数据");
                GdpsAddPeopleActivity.this.setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}

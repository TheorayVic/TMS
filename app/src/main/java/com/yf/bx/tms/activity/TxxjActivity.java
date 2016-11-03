package com.yf.bx.tms.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by 123 on 2016/10/25.
 */

public class TxxjActivity extends AutoLayoutActivity {

    private Button btn_open,btn_search;
    private ListView lv_unmatched,lv_matched;

    //判断当前设备是否支持蓝牙
    private boolean isSupportBt,isOpenBt;
    private BluetoothAdapter bluetoothAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txxj);
        isSupportBt=BluetoothAdapter.getDefaultAdapter() != null ? true : false;
        if (isSupportBt){
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            //判断蓝牙是否已经开启
            isOpenBt = bluetoothAdapter.isEnabled();
            if (!isOpenBt){
                bluetoothAdapter.enable();
                
            }
        }

        btn_open = (Button) findViewById(R.id.btn_open_ble);
        btn_search = (Button) findViewById(R.id.btn_search_ble);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TxxjActivity.this.startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS));
            }
        });
    }


}

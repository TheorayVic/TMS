package com.yf.bx.tms.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener;
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**选择日期工具类 具体到分
 * Created by bai on 2016/11/16.
 */

public class SelectDateUtils {

    //选择日期
    public static void selectDate(final FragmentManager fm, final TextView view){
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
        //时间日期选择
         final SlideDateTimeListener jcsj_listener = new SlideDateTimeListener() {
            @Override
            public void onDateTimeSet(Date date)
            {
                // Do something with the date. This Date object contains
                // the date and time that the user has selected.
                String date2 = dateFormat.format(date);
                view.setText(date2);
            }

            @Override
            public void onDateTimeCancel()
            {
                // Overriding onDateTimeCancel() is optional.
            }
        };
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlideDateTimePicker.Builder(fm)
                        .setListener(jcsj_listener)
                        .setInitialDate(new Date())
                        .setIs24HourTime(true)
                        .build()
                        .show();
            }
        });
    }
}

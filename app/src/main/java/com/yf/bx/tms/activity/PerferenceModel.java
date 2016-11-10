package com.yf.bx.tms.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by 123 on 2016/10/24.
 */

public class PerferenceModel {
    public static PerferenceModel pm = null;
    protected static Context context;

    public static PerferenceModel getPM(Context context) {
        PerferenceModel.context = context.getApplicationContext()   ;
        if (pm != null) {
            return pm;
        } else {
            pm = new PerferenceModel();
        }
        return pm;

    }


    public void insertPreference(String key, String value) {
        SharedPreferences perference = null;
        int sdk = Build.VERSION.SDK_INT;
        if(sdk > Build.VERSION_CODES.GINGERBREAD_MR1){
            perference = context.getSharedPreferences("config",
                    Context.MODE_MULTI_PROCESS);
        }else{
            perference = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        perference.edit().putString(key, value).commit();
    }


    public String getValue(String key, String flag) {
        String value = null;
        SharedPreferences perference = null;
        int sdk = Build.VERSION.SDK_INT;
        if(sdk > Build.VERSION_CODES.GINGERBREAD_MR1){
            perference = context.getSharedPreferences("config",
                    Context.MODE_MULTI_PROCESS);
        }else{
            perference = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        value = perference.getString(key, flag);
        return value;
    }

    //Context.MODE_WORLD_READABLE

    public void insertPf(String key, String value) {
        SharedPreferences perference = null;
        int sdk = Build.VERSION.SDK_INT;
        if(sdk > Build.VERSION_CODES.GINGERBREAD_MR1){
            perference = context.getSharedPreferences("pf",
                    Context.MODE_WORLD_READABLE);
        }else{
            perference = context.getSharedPreferences("pf", Context.MODE_WORLD_READABLE);
        }
        perference.edit().putString(key, value).commit();
    }

    public String getPf(String pName,String key) {
        Context otherAppsContext;
        String value=null;
        try {
            otherAppsContext = context.createPackageContext(pName,
                    Context.CONTEXT_IGNORE_SECURITY);
            SharedPreferences sharedPreferences = otherAppsContext
                    .getSharedPreferences("pf", Context.MODE_WORLD_READABLE);
            value = sharedPreferences.getString(key, "");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}

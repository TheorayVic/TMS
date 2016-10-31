package com.yf.bx.tms.net;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;

import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

/**
 * Created by bai on 2016/10/31.
 */
public class YFAjaxCallBackHolder implements Callback.CommonCallback<String> {

    public static final String TAG = "YFAjaxCallBackHolder";
    private WeakReference<Context> mContext;
    private String mFunction;

    public YFAjaxCallBackHolder(Context context, String function, YFAjaxCallBack callback) {
        mContext = new WeakReference<Context>(context);
        mFunction = function;
        mYFAjaxCall = callback;
    }

    private YFAjaxCallBack mYFAjaxCall;


    @Override
    public void onSuccess(String result) {
        Log.i(TAG, result);
        try {
            JSONObject jsonObject = new JSONObject(result);
            int code = jsonObject.getInt("Code");
            if (code == 0) {
                String data = jsonObject.get("Data").toString();
                onReceiveData(data, jsonObject.getString("Msg"));
            } else {
                onReceiveError(code, jsonObject.getString("Msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            onReceiveError(-1, "服务器数据解析失败");
        }
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Log.i(TAG, "onError: "+ex.toString());
        if (ex instanceof SocketTimeoutException) {
            onReceiveError(0, "连接服务器超时，请检查您的网络连接然后重试");
        } else {
            onReceiveError(0, ex.toString());
        }
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }

    public void onReceiveData(String data, String msg) {
        mYFAjaxCall.onReceiveData(mFunction, data, msg);
    }

    public void onReceiveError(int errorCode, String msg) {
        mYFAjaxCall.onReceiveError(mFunction, errorCode, msg);
    }
}

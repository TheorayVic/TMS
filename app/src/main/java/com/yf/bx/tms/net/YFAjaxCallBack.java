package com.yf.bx.tms.net;

/**
 * Created by bai on 2016/10/31.
 */
public interface YFAjaxCallBack {
    void onReceiveData(String function, String data, String msg);

    void onReceiveError(String function, int errorCode, String msg);
}

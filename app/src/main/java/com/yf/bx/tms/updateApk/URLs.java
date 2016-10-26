package com.yf.bx.tms.updateApk;

import java.io.Serializable;

/**
 * Created by 123 on 2016/10/24.
 */

public class URLs implements Serializable {
    public final static String HOST ="127.0.0.1";
    public final static String HTTP = "http://";
    public final static String PORT = ":28080/wzdp/wzdp/app/downloadApp";//28080
    private final static String URL_SPLITTER = "/";
    private final static String URL_API_HOST = HTTP + HOST+PORT + URL_SPLITTER;
    // 获取APK版本信息  下载路径及端口号等相关信息
    public final static String UPDATE_VERSION = URL_API_HOST+"update_bzjs.xml";
}

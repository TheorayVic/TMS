package com.yf.bx.tms.activity;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.yf.bx.tms.bean.User;
import com.yf.bx.tms.utils.CyptoUtils;
import com.yf.bx.tms.utils.FileUtils;
import com.yf.bx.tms.utils.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by 123 on 2016/10/24.
 */

public class AppContext extends Application {


    public static final int NETTYPE_WIFI = 0x01;
    public static final int NETTYPE_CMWAP = 0x02;
    public static final int NETTYPE_CMNET = 0x03;
    public static final int PAGE_SIZE = 20;//默认分页大小
    private static final int CACHE_TIME = 60*60000;//缓存失效时间
    private boolean login = false;	//登录状态
    private String loginUid = "0";	//登录用户的id
    private Hashtable<String, Object> memCacheRegion = new Hashtable<String, Object>();

    public List<String> list_xjdw,list_txz,list_jcfzr;

    public boolean isOnline=true;

//	private Handler unLoginHandler = new Handler(){
//		public void handleMessage(Message msg) {
//			if(msg.what == 1){
//				UIHelper.ToastMessage(AppContext.this, getString(R.string.msg_login_error));
//				UIHelper.showLoginDialog(AppContext.this);
//			}
//		}
//	};

    @Override
    public void onCreate() {
        super.onCreate();
        //注册App异常崩溃处理器
//        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
//        init();

        list_xjdw = new ArrayList<>();
        list_jcfzr = new ArrayList<>();
        list_txz = new ArrayList<>();
        list_xjdw.add("运检中心");
        list_xjdw.add("工程中心");
        list_xjdw.add("巡检中心");
        list_txz.add("500KV大泽变");
        list_txz.add("500KV文亭变");
        list_txz.add("500KV德州变");
        list_txz.add("500KV琅邪变");
        list_jcfzr.add("菏泽公司");
        list_jcfzr.add("德州公司");
        list_jcfzr.add("青岛公司");
    }

    /**
     * 初始化
     */
//	private void init(){
//		//设置保存图片的路径
//		saveImagePath = getProperty(AppConfig.SAVE_IMAGE_PATH);
//		if(StringUtils.isEmpty(saveImagePath)){
//			setProperty(AppConfig.SAVE_IMAGE_PATH, AppConfig.DEFAULT_SAVE_IMAGE_PATH);
//			saveImagePath = AppConfig.DEFAULT_SAVE_IMAGE_PATH;
//		}
//	}



    /**
     * 检测网络是否可用
     * @return
     */
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

    /**
     * 获取当前网络类型
     * @return 0：没有网络   1：WIFI网络   2：WAP网络    3：NET网络
     */
    public int getNetworkType() {
        int netType = 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            String extraInfo = networkInfo.getExtraInfo();
            if(!StringUtils.isEmpty(extraInfo)){
                if (extraInfo.toLowerCase().equals("cmnet")) {
                    netType = NETTYPE_CMNET;
                } else {
                    netType = NETTYPE_CMWAP;
                }
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = NETTYPE_WIFI;
        }
        return netType;
    }

    /**
     * 判断当前版本是否兼容目标版本的方法
     * @param VersionCode
     * @return
     */
    public static boolean isMethodsCompat(int VersionCode) {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        return currentVersion >= VersionCode;
    }

    /**
     * 获取App安装包信息
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if(info == null) info = new PackageInfo();
        return info;
    }



    /**
     * 用户是否登录
     * @return
     */
    public boolean isLogin() {
        return login;
    }

    /**
     * 获取登录用户id
     * @return
     */
    public String getLoginUid() {
        return this.loginUid;
    }


    /**
     * 保存登录信息
     */
    public void saveLoginInfo(final User user) {
        this.loginUid = user.getUid();
        this.login = true;
        setProperties(new Properties(){{
            setProperty("user.uid", String.valueOf(user.getUid()));
            setProperty("user.name", user.getName());
            setProperty("user.face", FileUtils.getFileName(user.getFace()));//用户头像-文件名
            setProperty("user.account", user.getAccount());
            setProperty("user.pwd", CyptoUtils.encode("App",user.getPwd()));
            setProperty("user.location", user.getLocation());
//			setProperty("user.followers", String.valueOf(user.getFollowers()));
//			setProperty("user.fans", String.valueOf(user.getFans()));
//			setProperty("user.score", String.valueOf(user.getScore()));
            setProperty("user.isRememberMe", String.valueOf(user.isRememberMe()));//是否记住我的信息
        }});
    }

    /**
     * 清除登录信息
     */
    public void cleanLoginInfo() {
        this.loginUid = "0";
        this.login = false;
        removeProperty("user.uid","user.name","user.face","user.account","user.pwd",
                "user.location","user.followers","user.fans","user.score","user.isRememberMe");
    }

    /**
     * 获取登录信息
     * @return
     */
    public User getLoginInfo() {
        User lu = new User();
        //lu.setUid((getProperty("user.uid"), "0");
        lu.setName(getProperty("user.name"));
        lu.setFace(getProperty("user.face"));
        lu.setAccount(getProperty("user.account"));
        lu.setPwd(CyptoUtils.decode("oschinaApp",getProperty("user.pwd")));
        lu.setLocation(getProperty("user.location"));
//		lu.setFollowers(StringUtils.toInt(getProperty("user.followers"), 0));
//		lu.setFans(StringUtils.toInt(getProperty("user.fans"), 0));
//		lu.setScore(StringUtils.toInt(getProperty("user.score"), 0));
        lu.setRememberMe(StringUtils.toBool(getProperty("user.isRememberMe")));
        return lu;
    }

    public void setProperties(Properties ps){
        AppConfig.getAppConfig(this).set(ps);
    }

    public Properties getProperties(){
        return AppConfig.getAppConfig(this).get();
    }

    public void setProperty(String key,String value){
        AppConfig.getAppConfig(this).set(key, value);
    }

    public String getProperty(String key){
        return AppConfig.getAppConfig(this).get(key);
    }
    public void removeProperty(String...key){
        AppConfig.getAppConfig(this).remove(key);
    }




    /**
     * 判断缓存是否存在
     * @param cachefile
     * @return
     */
    private boolean isExistDataCache(String cachefile)
    {
        boolean exist = false;
        File data = getFileStreamPath(cachefile);
        if(data.exists())
            exist = true;
        return exist;
    }

    /**
     * 判断缓存是否失效
     * @param cachefile
     * @return
     */
    public boolean isCacheDataFailure(String cachefile)
    {
        boolean failure = false;
        File data = getFileStreamPath(cachefile);
        if(data.exists() && (System.currentTimeMillis() - data.lastModified()) > CACHE_TIME)
            failure = true;
        else if(!data.exists())
            failure = true;
        return failure;
    }

    /**
     * 清除app缓存
     */
    public void clearAppCache()
    {
        //清除webview缓存
//		File file = CacheManager.getCacheFileBaseDir();
//		if (file != null && file.exists() && file.isDirectory()) {
//		    for (File item : file.listFiles()) {
//		    	item.delete();
//		    }
//		    file.delete();
//		}
        deleteDatabase("webview.db");
        deleteDatabase("webview.db-shm");
        deleteDatabase("webview.db-wal");
        deleteDatabase("webviewCache.db");
        deleteDatabase("webviewCache.db-shm");
        deleteDatabase("webviewCache.db-wal");
        //清除数据缓存
        clearCacheFolder(getFilesDir(),System.currentTimeMillis());
        clearCacheFolder(getCacheDir(),System.currentTimeMillis());
        //2.2版本才有将应用缓存转移到sd卡的功能
        if(isMethodsCompat(android.os.Build.VERSION_CODES.FROYO)){
            //clearCacheFolder(MethodsCompat.getExternalCacheDir(this),System.currentTimeMillis());
        }
        //清除编辑器保存的临时内容
        Properties props = getProperties();
        for(Object key : props.keySet()) {
            String _key = key.toString();
            if(_key.startsWith("temp"))
                removeProperty(_key);
        }
    }

    /**
     * 清除缓存目录
     * @return
     */
    private int clearCacheFolder(File dir, long curTime) {
        int deletedFiles = 0;
        if (dir!= null && dir.isDirectory()) {
            try {
                for (File child:dir.listFiles()) {
                    if (child.isDirectory()) {
                        deletedFiles += clearCacheFolder(child, curTime);
                    }
                    if (child.lastModified() < curTime) {
                        if (child.delete()) {
                            deletedFiles++;
                        }
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return deletedFiles;
    }

    /**
     * 将对象保存到内存缓存中
     * @param key
     * @param value
     */
    public void setMemCache(String key, Object value) {
        memCacheRegion.put(key, value);
    }

    /**
     * 从内存缓存中获取对象
     * @param key
     * @return
     */
    public Object getMemCache(String key){
        return memCacheRegion.get(key);
    }

    /**
     * 保存磁盘缓存
     * @param key
     * @param value
     * @throws IOException
     */
    public void setDiskCache(String key, String value) throws IOException {
        FileOutputStream fos = null;
        try{
            fos = openFileOutput("cache_"+key+".data", Context.MODE_PRIVATE);
            fos.write(value.getBytes());
            fos.flush();
        }finally{
            try {
                fos.close();
            } catch (Exception e) {}
        }
    }

    /**
     * 获取磁盘缓存数据
     * @param key
     * @return
     * @throws IOException
     */
    public String getDiskCache(String key) throws IOException {
        FileInputStream fis = null;
        try{
            fis = openFileInput("cache_"+key+".data");
            byte[] datas = new byte[fis.available()];
            fis.read(datas);
            return new String(datas);
        }finally{
            try {
                fis.close();
            } catch (Exception e) {}
        }
    }

    /**
     * 保存对象
     * @param ser
     * @param file
     * @throws IOException
     */
    public boolean saveObject(Serializable ser, String file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = openFileOutput(file, MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(ser);
            oos.flush();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            try {
                oos.close();
            } catch (Exception e) {}
            try {
                fos.close();
            } catch (Exception e) {}
        }
    }

    /**
     * 读取对象
     * @param file
     * @return
     * @throws IOException
     */
    public Serializable readObject(String file){
        if(!isExistDataCache(file))
            return null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = openFileInput(file);
            ois = new ObjectInputStream(fis);
            return (Serializable)ois.readObject();
        }catch(FileNotFoundException e){
        }catch(Exception e){
            e.printStackTrace();
            //反序列化失败 - 删除缓存文件
            if(e instanceof InvalidClassException){
                File data = getFileStreamPath(file);
                data.delete();
            }
        }finally{
            try {
                ois.close();
            } catch (Exception e) {}
            try {
                fis.close();
            } catch (Exception e) {}
        }
        return null;
    }

}

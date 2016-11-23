package com.yf.bx.tms.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.updateApk.UpdateManager;
import com.zhy.autolayout.AutoLayoutActivity;


/**登录界面
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private CheckBox switch_btn;
    private String username;
    private String userpwd;
    private String userpwdMd5;
    private EditText user_text, text_pwd;
    private Activity activity;
    private AppContext appContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;
    //    appContext = (AppContext)getApplication();
        // 网络连接判断
      //  boolean isOnline = appContext.isNetworkConnected();// 网络可用true
//        if (!isOnline)
//            Toast.makeText(activity, "当前网络不可用，进入离线模式！", Toast.LENGTH_LONG)
//                    .show();

        UpdateManager.getUpdateManager().checkAppUpdate(this, false);// 检查是否更新
        user_text = (EditText) findViewById(R.id.user_text);
        user_text.setText("");//ys
        text_pwd = (EditText) findViewById(R.id.text_pwd);
        text_pwd.setText("");//ys
        switch_btn = (CheckBox) findViewById(R.id.switch_btn);
        ImageView loginBt = (ImageView) findViewById(R.id.button_login);
        String state = PerferenceModel.getPM(LoginActivity.this).getValue("state","");// 记录开关状态
        if (state != null && state.equals("rember")) {
            switch_btn.setChecked(true);
            username = PerferenceModel.getPM(LoginActivity.this).getValue(
                    "username", "lc-lijc");
            userpwd = PerferenceModel.getPM(LoginActivity.this).getValue("userpwd",
                    "1");
            user_text.setText(username);
            text_pwd.setText(userpwd);
        }
        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
            }
        });

        loginBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                activity.startActivity(intent);
//                showProgressDialog("登录中请稍后......");
//                username = user_text.getText().toString().trim();
//                userpwd = text_pwd.getText().toString().trim();
//                userpwdMd5 = Pub_method.Md5(userpwd).toLowerCase();
//                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(userpwd)) {
//                    toast(activity, "用户名、密码不能为空,请输入!");
//                    closeProgressDialog();
//                    return;
//                }
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Looper.prepare();
//                        sendLogin(username, userpwdMd5);
//                    }
//                }).start();
           }
       });
        }
//
//    private void sendLogin(String userName, String userpwdMd5) {
//        RequestAction requestAction = new RequestAction();
//        requestAction.putParam("userName", userName);
//        requestAction.putParam("userpwdMd5", userpwdMd5);
//        requestAction.isPageBeanEnable = false;
//        requestAction.serviceName = RequestParamConfig.login;
//        boolean isOnline = appContext.isNetworkConnected();
//        // 在线状态
//        if (isOnline) {
//            httpModule.executeRequest(requestAction, new UserHandler(),
//                    new ProcessResponseUser(), BaseRequest.RequestType.WEBSERVICE);
//        } else {
//            String username = PerferenceModel.getPM(LoginActivity.this).getValue(
//                    "username", "");
//            String pwd = PerferenceModel.getPM(LoginActivity.this).getValue(
//                    "userpwd", "");
//            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)) {
//                String inputUsername = user_text.getText().toString();
//                String inputPwd = text_pwd.getText().toString();
//                if (inputUsername.equals(username)
//                        && inputPwd.equals(pwd)) {
//                } else {
//                    String msg = "用户名和密码校验失败，请连接网络后重新登录！";
//                    mHandler.obtainMessage(0, msg).sendToTarget();
//                }
//            } else {
//                String msg = "首次登录或密码修改后请连接网络进行初始登录！";
//                mHandler.obtainMessage(0, msg).sendToTarget();
//            }
//        }
//    }
//
//    /**
//     * 登录成功后的处理
//     */
//    private void loginsetting(UserResponse userResponse) {
//
//        if (switch_btn.isChecked())// 检测用户名密码
//        {
//            PerferenceModel.getPM(LoginActivity.this).insertPreference("username",
//                    username);
//            PerferenceModel.getPM(LoginActivity.this).insertPreference("userpwd",
//                    userpwd);
//            PerferenceModel.getPM(LoginActivity.this).insertPreference("state",
//                    "rember");
//        } else {
//            PerferenceModel.getPM(LoginActivity.this)
//                    .insertPreference("userpwd", "");
//            PerferenceModel.getPM(LoginActivity.this).insertPreference("state", "");
//        }
//
//        PerferenceModel.getPM(LoginActivity.this).insertPreference("userpwd",
//                userpwd);
//        Intent intent = new Intent();
//        intent.putExtra("userbean", userResponse.userBean);
//        intent.setClass(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
//        LoginActivity.this.finish();
//    }
//    /**
//     * 处理网络异常等信息 *
//     */
//    private BaseHandler mHandler = new BaseHandler();
//
//    private class BaseHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (progressDialog != null && progressDialog.isShowing())
//                progressDialog.dismiss();
//            switch (msg.what) {
//                case 0:
//                    Toast.makeText(activity, msg.obj + "",
//                            Toast.LENGTH_LONG).show();
//                    break;
//                case 1:// 登录成功
//                    UserResponse userResponse = (UserResponse) msg.obj;
//                    loginsetting(userResponse);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//
//    class ProcessResponseUser implements ModuleResponseProcessor {
//        @Override
//        public void processResponse(BaseHttpModule httpModule, Object parseObj) {
//
//            if (parseObj instanceof StatusEntity) {
//                StatusEntity staty = (StatusEntity) parseObj;
//                String result = staty.result;
//                String message = staty.message;
//                if ("0".equals(result) && !TextUtils.isEmpty(message)) {
//                    mHandler.obtainMessage(0, message).sendToTarget();
//                }
//            } else if (parseObj instanceof UserResponse) {//
//                mHandler.obtainMessage(1, parseObj).sendToTarget();
//            }
//        }
//    }
//
//    public void toast(Activity activity, String msg) {
//        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
//    }

}
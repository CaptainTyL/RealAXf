package com.example.administrator.realaxf.ui.Base.login;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Home.Bean.LoginBean;
import com.example.administrator.realaxf.ui.Base.Home.Bean.LoginDataBean;
import com.example.administrator.realaxf.ui.Base.Home.HomeActivity;
import com.example.administrator.realaxf.ui.Base.Util.CountDownUtil;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements TextWatcher {
    //手机号和验证码的输入框
    private EditText edLoginPhone, edLoginCode;
    //头部布局的控件
    private TextView tvHead;
    //登录按钮
    private CardView cardLogin;
    //声明手机号，验证码
    String phoneNumber, codeNumber;
    //获取输入框中的验证码
    String etCodeNumber;
    //点击获取验证码
    private TextView tvLoginCode;
    //验证码数据的实体类
    LoginDataBean loginDataBean = new LoginDataBean();
    //登陆后请求到的个人信息的实体类
    LoginBean loginBean = new LoginBean();
    //异步消息
    Message msg;
    //声明加载框
    ProgressDialog progressDialog;
    //异步
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    codeNumber = loginDataBean.getData().getVerification() + "";
                    edLoginCode.setText(codeNumber);
                    break;
                case 2:
                    if (loginBean.getData() != null) {
                        SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                        editor.putString("userName", loginBean.getData().getUserName());
                        editor.putString("userIcon", loginBean.getData().getUserIcon());
                        editor.putString("userId", loginBean.getData().getUserId());
                        editor.apply();
                        dismissProgressDialog();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        dismissProgressDialog();
                        Toast.makeText(LoginActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tvHead = findViewById(R.id.tv_head);
        tvHead.setText("登录");
        edLoginPhone = findViewById(R.id.ed_login_phone);
        edLoginCode = findViewById(R.id.ed_login_code);
        cardLogin = findViewById(R.id.card_login);
        tvLoginCode = findViewById(R.id.tv_login_code);
        edLoginPhone.addTextChangedListener(this);
        edLoginCode.addTextChangedListener(this);

    }


    //重写EditText监听的三个方法
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(final Editable s) {
        //获得手机号，进行发送验证码
        phoneNumber = edLoginPhone.getText().toString();
        if ((phoneNumber.length() == 11) && isMobileNO(phoneNumber)) {
            cardLogin.setCardBackgroundColor(getResources().getColor(R.color.main_color));
            tvLoginCode.setTextColor(getResources().getColor(R.color.color_3));
            //发送请求获取验证码
            onClickTvLoginCode();
            onlickLogin();
        } else {
            cardLogin.setCardBackgroundColor(getResources().getColor(R.color.color_login));
            tvLoginCode.setTextColor(getResources().getColor(R.color.color_6));
        }
    }

    /**
     * 通过接口进行网络请求
     * 1.使用okhttp发送网络请求，请求得到json数据
     * 2.将json数据进行解析，储存在实体类中
     * 3.必须进行异步处理数据
     * 4.将异步处理得到的数据进行调用
     */
    //1.发送网络请求，获取验证码的json数据
    private void sendGetCodeHttpRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建okHttp实例
                    OkHttpClient client = new OkHttpClient();
                    //针对post请求需要创建requestBody传递参数
                    RequestBody requestBody = new FormBody.Builder()
                            .add("username", phoneNumber).build();
                    //创建Request对象，用于发送一条http(post)请求
                    Request request = new Request.Builder()
                            .url("http://questionnaire.dzqcedu.com:81/Shop/noteverify")
                            .post(requestBody)
                            .build();
                    //发送请求 返回数据储存在Response
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Log.e("请求状态", responseData);
                    JXJsonData(responseData);
                    sendNotification();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //2.使用Gson解析json数据
    private void JXJsonData(String jsonData) {
        Gson gson = new Gson();
        loginDataBean = gson.fromJson(jsonData, LoginDataBean.class);
        //使用异步消息处理,获得到数据
        msg = new Message();
        msg.what = 1;
        handler.sendMessage(msg);

    }

    //获取验证码点击事件发送请求来获取验证码
    private void onClickTvLoginCode() {
        tvLoginCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownUtil(tvLoginCode).
                        setCountDownMillis(60_000L)
                        .setCountDownColor(R.color.color_3, R.color.color_9)
                        .start();
                sendGetCodeHttpRequest();
            }
        });
    }

    //发送网络请求获取登录数据
    private void sendHttpGetLoginData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建okhttp实例
                    OkHttpClient client = new OkHttpClient();
                    //针对post请求需要创建requestBody传递参数
                    RequestBody requestBody = new FormBody.Builder()
                            .add("username", phoneNumber)
                            .add("verification", codeNumber).build();
                    //发送一条post请求
                    Request request = new Request.Builder()
                            .url("http://questionnaire.dzqcedu.com:81/Shop/login")
                            .post(requestBody)
                            .build();
                    //请求完毕 返回得到的json数据储存在Response
                    Response response = client.newCall(request).execute();
                    String loginDataJson = response.body().string();
                    Log.e("错误情况下", loginDataJson);
                    JXLoginData(loginDataJson);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //解析得到的json数据
    private void JXLoginData(String jsonData) {
        Gson gson = new Gson();
        loginBean = gson.fromJson(jsonData, LoginBean.class);
        msg = new Message();
        msg.what = 2;
        handler.sendMessage(msg);
    }

    //点击登录发送请求
    private void onlickLogin() {
        cardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCodeNumber = edLoginCode.getText().toString();
                if (etCodeNumber.equals(codeNumber)) {
                    sendHttpGetLoginData();
                    showProgressDiaLog(LoginActivity.this,"加载中...");
                } else {
                    Toast.makeText(LoginActivity.this, "验证码有误", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //手机号的正则表达式
    public static boolean isMobileNO(String mobileNums) {
        /**
         * 判断字符串是否符合手机号码格式
         * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
         * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
         * 电信号段: 133,149,153,170,173,177,180,181,189
         * @param str
         * @return 待检测的字符串
         */
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);

    }

    //发送通知
    private void sendNotification() {
        NotificationManager nm = ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE));
        Notification.Builder builder = new Notification.Builder(LoginActivity.this);
        builder.setSmallIcon(R.drawable.tuixiuzhigongfeiyong);//设置图标
        builder.setTicker("您收到一条新通知");
        builder.setContentTitle("爱鲜蜂");
        builder.setContentText("验证码:" + codeNumber);//消息内容
        builder.setWhen(System.currentTimeMillis());//发送时间
        builder.setDefaults(Notification.DEFAULT_ALL);//设置通知声音
        Notification notification = builder.build();
        nm.notify(1, notification);
    }

    //实现网络请求时加载框
    //1.显示加载框
    private void showProgressDiaLog(Context context, String text) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.setMessage(text);    //设置内容
        progressDialog.setCancelable(false);//点击屏幕和按返回键都不能取消加载框
        progressDialog.show();

    }

    //隐藏加载框
    public Boolean dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
                return true;//取消成功
            }
        }
        return false;//已经取消过了，不需要取消
    }

}

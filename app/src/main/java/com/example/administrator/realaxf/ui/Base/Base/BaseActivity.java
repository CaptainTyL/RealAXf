package com.example.administrator.realaxf.ui.Base.Base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    @SuppressLint("RestrictedApi")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder=ButterKnife.bind(this);
        init();
    }


    /**
     * 初始化的抽象方法
     */
    public  abstract  void init();
    /**
     *获取布局的方法
     *
     */
    public abstract int getLayoutId();
    /**
     * 跳转界面
     */
    public void startActivity(Class<?> targetActivity){
        Intent intent=new Intent(this,targetActivity);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注解，释放资源
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
    public void setFinsh(View v){
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

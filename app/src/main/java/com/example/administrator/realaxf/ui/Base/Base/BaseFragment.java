package com.example.administrator.realaxf.ui.Base.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private View view;
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
       view=inflater.inflate(getLayoutId(),null);
       unbinder=ButterKnife.bind(this,view);
        init();
       return view;
    }
    //初始化抽象方法
    public abstract void init();

    //获取布局的抽象方法
    public abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }

}

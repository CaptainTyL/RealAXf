package com.example.administrator.realaxf.ui.Base.Home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.realaxf.R;

import com.example.administrator.realaxf.ui.Base.Base.BaseActivity;
import com.example.administrator.realaxf.ui.Base.Home.Fragment.ClassifyFragment;
import com.example.administrator.realaxf.ui.Base.Home.Fragment.MineFragment;
import com.example.administrator.realaxf.ui.Base.Home.Fragment.ShopCarFragment;
import com.example.administrator.realaxf.ui.Base.Home.Fragment.ShouyeFragment;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeActivity extends BaseActivity {
    //按钮改变大小
    private Animation animation;
    //按钮
    @BindView(R.id.re_shouye)
    RelativeLayout reShouye;
    @BindView(R.id.re_classify)
    RelativeLayout reClassify;
    @BindView(R.id.re_car)
    RelativeLayout reCar;
    @BindView(R.id.re_mine)
    RelativeLayout reMine;
    //按钮图片
    @BindView(R.id.img_shouye)
    ImageView imgShouye;
    @BindView(R.id.img_classify)
    ImageView imgClassify;
    @BindView(R.id.img_shopCar)
    ImageView imgShopCar;
    @BindView(R.id.img_mine)
    ImageView imgMine;
    //找到按钮的汉字
    @BindView(R.id.tv_home_shouye)
    TextView tvHomeShouye;
    @BindView(R.id.tv_home_fenlei)
    TextView tvHomeFenlei;
    @BindView(R.id.tv_home_car)
    TextView tvHomeCar;
    @BindView(R.id.tv_home_mine)
    TextView tvHomeMine;

    //声明碎片
    private ShouyeFragment shouyeFragment;
    private ClassifyFragment classifyFragment;
    private ShopCarFragment shopCarFragment;
    private MineFragment mineFragment;
    //设置碎片的位置
    public static final String POSITION = "position";
    public static final int HOME_FRAGMENT = 0;
    public static final int CLASSIFY_FRAGMENT = 1;
    public static final int CAR_FRAGMENT = 2;
    public static final int MINE_FRAGMENT = 3;
    private int position;
    //声明承载碎片的布局
    private FrameLayout homeFrame;
    //声明碎片管理
    private FragmentManager fragmentManager;

    @Override
    public void init() {

        homeFrame = findViewById(R.id.home_frame);
        fragmentManager = getSupportFragmentManager();
        showFragment(0);






    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //屏幕旋转时记录位置
        outState.putInt(POSITION, position);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //屏幕恢复时取出位置
        showFragment(savedInstanceState.getInt(POSITION));
        super.onRestoreInstanceState(savedInstanceState);
    }

    //改变下面按钮图标大小的方法
    private void setAnimation(ImageView imageView) {
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        imageView.startAnimation(animation);

    }

    ////点击事件
    @OnClick({R.id.re_shouye, R.id.re_classify, R.id.re_car, R.id.re_mine})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.re_shouye:
                setAnimation(imgShouye);
                setImgChange(R.drawable.icon_gaibianshouyetubiao, R.drawable.ziyuan, R.drawable.gouwuche, R.drawable.wode);
                setTextColor(tvHomeShouye, tvHomeFenlei, tvHomeCar, tvHomeMine);
                showFragment(HOME_FRAGMENT);
                break;
            case R.id.re_classify:
                setAnimation(imgClassify);
                setImgChange(R.drawable.shouye, R.drawable.icom_haibianfengleitubiao, R.drawable.gouwuche, R.drawable.wode);
                setTextColor(tvHomeFenlei, tvHomeShouye, tvHomeCar, tvHomeMine);
                showFragment(CLASSIFY_FRAGMENT);
                break;
            case R.id.re_car:
                setAnimation(imgShopCar);
                setImgChange(R.drawable.shouye, R.drawable.ziyuan, R.drawable.icon_gaibiangouwuchetubiao, R.drawable.wode);
                setTextColor(tvHomeCar, tvHomeShouye, tvHomeFenlei, tvHomeMine);
                showFragment(CAR_FRAGMENT);
                break;
            case R.id.re_mine:
                setAnimation(imgMine);
                setImgChange(R.drawable.shouye, R.drawable.ziyuan, R.drawable.gouwuche, R.drawable.icon_gaibianwode);
                setTextColor(tvHomeMine, tvHomeFenlei, tvHomeCar, tvHomeShouye);
                showFragment(MINE_FRAGMENT);
                break;
        }
    }

    //
//    //跳转碎片
    private void showFragment(int index) {
        FragmentTransaction ft = fragmentManager.beginTransaction();//开启事务
        //隐藏被创建出来的碎片实例
        hideFragment(ft);

        position = index;
        switch (index) {
            /**
             * 如果Fragment为空，就新建一个实例
             * 如果不为空，就将它从栈中显示出来
             */
            case HOME_FRAGMENT:
                if (shouyeFragment == null) {
                    shouyeFragment = new ShouyeFragment();
                    ft.add(R.id.home_frame, shouyeFragment);
                } else {
                    ft.show(shouyeFragment);
                }
                break;
            case CLASSIFY_FRAGMENT:
                if (classifyFragment == null) {
                    classifyFragment = new ClassifyFragment();
                    ft.add(R.id.home_frame, classifyFragment);
                } else {
                    ft.show(classifyFragment);
                }
                break;
            case CAR_FRAGMENT:
                if (shopCarFragment == null) {
                    shopCarFragment = new ShopCarFragment();
                    ft.add(R.id.home_frame, shopCarFragment);
                } else {
                    ft.show(shopCarFragment);
                }
                break;
            case MINE_FRAGMENT:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    ft.add(R.id.home_frame, mineFragment);
                } else {
                    ft.show(mineFragment);
                }
                break;
        }
        ft.commit();

    }

    //隐藏碎片
    private void hideFragment(FragmentTransaction ft) {
        //如果不为空，就先隐藏起来
        if (shouyeFragment != null) {
            ft.hide(shouyeFragment);
        }
        if (classifyFragment != null) {
            ft.hide(classifyFragment);
        }
        if (shopCarFragment != null) {
            ft.hide(shopCarFragment);
        }
        if (mineFragment != null) {
            ft.hide(mineFragment);
        }
    }

    //切换碎片时设置字体颜色
    private void setTextColor(TextView view1, TextView view2, TextView view3, TextView view4) {
        view1.setTextColor(getResources().getColor(R.color.main_color));
        view2.setTextColor(getResources().getColor(R.color.color_3));
        view3.setTextColor(getResources().getColor(R.color.color_3));
        view4.setTextColor(getResources().getColor(R.color.color_3));
    }

    //设置图片改变方法
    private void setImgChange(int img1, int img2, int img3, int img4) {
        imgShouye.setImageResource(img1);
        imgClassify.setImageResource(img2);
        imgShopCar.setImageResource(img3);
        imgMine.setImageResource(img4);
    }

}

package com.example.administrator.realaxf.ui.Base.Home.adress;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Base.BaseActivity;
import com.example.administrator.realaxf.ui.Base.Home.Fragment.ShouyeFragment;
import com.github.library.listener.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AdressActivty extends BaseActivity {
    //声明RecycleView控件
    @BindView(R.id.re_address_cityList)
    RecyclerView reAddressCityList;
    //声明返回按钮
    @BindView(R.id.img_adress_back)
    ImageView imgAdressBack;
    //找到定位布局
    @BindView(R.id.lin_adress_location)
    LinearLayout linAdressLocation;
    //数据
    List<CityBean> cityList = new ArrayList<CityBean>();
    CityBean cityBean;
    //适配器
    AdressAdpater adressAdpater;

    @Override
    public void init() {
        //设置数据
        setCity();
        //实现父类的方法 点击返回回到上一个活动
        setFinsh(imgAdressBack);
        //列表布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reAddressCityList.setLayoutManager(layoutManager);
        adressAdpater = new AdressAdpater(this, cityList, R.layout.item_citylist);
        reAddressCityList.setAdapter(adressAdpater);
        //列表点击事件，点击回传值
        adressAdpater.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("cityName", cityList.get(position).getCityName());
                setResult(1, intent);
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_adress;
    }

    /**
     * 添加数据到实体类
     */
    private void setCity() {
        for (int i = 0; i < 10; i++) {
            cityBean = new CityBean();
            cityBean.setCityName("郑州职业技术学院" + (i + 1) + "号楼");
            cityList.add(cityBean);
        }
    }

    @OnClick({R.id.lin_adress_location})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_adress_location:

                break;
        }
    }

}

package com.example.administrator.realaxf.ui.Base.Home.search;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Base.BaseActivity;
import com.github.library.listener.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SearchActivity extends BaseActivity {
    //得到EditText设置内容
    @BindView(R.id.et_search_sousuo)
    EditText etSearchSousuo;
    //找到返回按钮
    @BindView(R.id.search_img_back)
    ImageView searchImgBack;
    //RecycleView控件
    @BindView(R.id.recycl_search_shopList)
    RecyclerView recyclSearchShopList;
    //数据 实体类
    List<ShopListBean> shopList = new ArrayList<ShopListBean>();
    ShopListBean shopListBean;
    //适配器
    ShopAdpater shopAdpater;

    @Override
    public void init() {
        setFinsh(searchImgBack);
        setShopList();
        //设置布局管理
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclSearchShopList.setLayoutManager(layoutManager);
        shopAdpater=new ShopAdpater(this,shopList,R.layout.item_search);
        recyclSearchShopList.setAdapter(shopAdpater);
        shopAdpater.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                etSearchSousuo.setText(shopList.get(position).getShopName());
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    //设置数据到实体类
    private void setShopList() {
        for (int i = 0; i < 6; i++) {
            shopListBean = new ShopListBean();
            shopListBean.setShopName("橘子" + i);
            shopList.add(shopListBean);
        }
    }
}

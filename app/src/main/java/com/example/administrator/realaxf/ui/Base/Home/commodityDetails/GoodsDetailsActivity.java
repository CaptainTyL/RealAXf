package com.example.administrator.realaxf.ui.Base.Home.commodityDetails;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class GoodsDetailsActivity extends BaseActivity {
    @BindView(R.id.img_goodsDetails_back)
    ImageView imgGoodsDetailsBack;
    @BindView(R.id.tv_goodsDetail_title)
    TextView tvGoodsDetailTitle;
    @BindView(R.id.img_xiangqing_shopImg)
    ImageView imgXiangqingShopImg;
    @BindView(R.id.tv_big_shopName)
    TextView tvBigShopName;
    @BindView(R.id.tv_VipPrice)
    TextView tvVipPrice;
    @BindView(R.id.tv_nolmarprice)
    TextView tvNolmarprice;
    @BindView(R.id.tv_goods_shopname)
    TextView tv_goods_shopname;
    @BindView(R.id.rela_goodsDetails_shopCar)
    RelativeLayout relaGoodsDetailsShopCar;

    @Override
    public void init() {
        setFinsh(imgGoodsDetailsBack);
        Intent intent = getIntent();
        String shopName = intent.getStringExtra("shopName");
        String shopImag = intent.getStringExtra("shopImage");
        String shopVip = intent.getStringExtra("shopVip");
        String shopNormal = intent.getStringExtra("shopNormal");
        tvGoodsDetailTitle.setText(shopName);
        Glide.with(this).load(shopImag).into(imgXiangqingShopImg);
        tvBigShopName.setText(shopName);
        tvVipPrice.setText("￥" + shopVip);
        tvNolmarprice.setText("￥" + shopNormal);
        tv_goods_shopname.setText(shopName);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goodsdetails;
    }

    //跳转页面到购物车碎片
    @OnClick(R.id.rela_goodsDetails_shopCar)
    void onClick(View view) {
        switch (view.getId()){
            case R.id.rela_goodsDetails_shopCar:

                break;
        }
    }
}

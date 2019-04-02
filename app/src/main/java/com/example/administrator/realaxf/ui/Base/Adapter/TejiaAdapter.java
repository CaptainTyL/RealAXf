package com.example.administrator.realaxf.ui.Base.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Home.Bean.AddShopCarBean;
import com.example.administrator.realaxf.ui.Base.Home.Bean.TejiaShopListBean;
import com.example.administrator.realaxf.ui.Base.okhttputils.OkHttpHelper;
import com.example.administrator.realaxf.ui.Base.okhttputils.SpotsCallBack;
import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;
import com.squareup.okhttp.Response;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TejiaAdapter extends BaseRecyclerAdapter<TejiaShopListBean.DataBean> {
    private OkHttpHelper okHttpHelper=OkHttpHelper.getInstance();

    public TejiaAdapter(Context context, List<TejiaShopListBean.DataBean> data) {
        super(context, data, R.layout.item_tejia);
    }

    @Override
    protected void convert(BaseViewHolder helper, final TejiaShopListBean.DataBean item) {
        Glide.with(mContext).load(item.getGoodssmallurl()).into((ImageView) helper.getView(R.id.item_tejia_image));
        helper.setText(R.id.tv_tejia_name,item.getGoodsname());
        helper.setText(R.id.text_tejia_vipprice,item.getGoodsvipprice());
        helper.setOnClickListener(R.id.item_img_shopcar, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShopListToCar(item.getGoodsid());
            }
        });
    }
    //向购物车中添加商品
    private void addShopListToCar(String commodityId){
        SharedPreferences sp=mContext.getSharedPreferences("Data",Context.MODE_PRIVATE);
        String userId=sp.getString("userId","1");
        String url="http://questionnaire.dzqcedu.com:81/Shop/addcart";
        Map<String,String> map=new HashMap<>();
        map.put("userId",userId);
        map.put("commodityId",commodityId);
        okHttpHelper.post(url, map, new SpotsCallBack<AddShopCarBean>(mContext,true) {
            @Override
            public void onSuccess(Response response, AddShopCarBean o) throws ParseException {
                Toast.makeText(mContext, "添加购物车成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Response response, int code, Exception e) {

            }
        });
    }
}

package com.example.administrator.realaxf.ui.Base.Home.GoodsOrder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.realaxf.R;
import com.example.administrator.realaxf.ui.Base.Base.BaseActivity;
import com.example.administrator.realaxf.ui.Base.okhttputils.OkHttpHelper;
import com.example.administrator.realaxf.ui.Base.okhttputils.SpotsCallBack;
import com.squareup.okhttp.Response;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class GoodsOrderActivity extends BaseActivity {
    //得到返回键
    @BindView(R.id.img_goodsorder_back)
    ImageView imgGoodsorderBack;
    //得到总价
    @BindView(R.id.tv_goodsOrder_orderTotalPrice)
    TextView tvGoodsOrderOrderTotalPrice;
    @BindView(R.id.tv_goodsOrder_endTotalOrderPrice)
    TextView tvGoodsOrderEndTotalOrderPrice;
    //得到总件数
    @BindView(R.id.tv_goodsOrder_TotalCount)
    TextView tvGoodsOrderTotalCount;
    //okHttp
    OkHttpHelper okHttpHelper=OkHttpHelper.getInstance();
    //json数据
    String jsonStr;

    //得到RecycleView列表
    @BindView(R.id.recycl_shoporder_okList)
    RecyclerView recyclShoporderOkList;
    //数据
    List<GoodsOrderDataBean.DataBean>list=new ArrayList<>();
    //适配器
    GoodsOrderAdpater goodsOrderAdpater;
    //总件数
    int TotalCount=0;
    @Override
    public void init() {
        setFinsh(imgGoodsorderBack);
        //得到选中商品传过来的json数据
        Intent intent=getIntent();
        jsonStr= intent.getStringExtra("jsonStr");
        //设置布局
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclShoporderOkList.setLayoutManager(linearLayoutManager);
        getGoodsOrderList();


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_goodsorder;
    }
    //请求购买的商品订单数据
    private void getGoodsOrderList(){
        String url="http://questionnaire.dzqcedu.com:81/Shop/confirmorder";
        SharedPreferences sp = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String userId = sp.getString("userId", "1");
        Map <String ,String> map=new HashMap();
        map.put("userId",userId);
        map.put("json",jsonStr);
        okHttpHelper.post(url, map, new SpotsCallBack<GoodsOrderDataBean>(GoodsOrderActivity.this,true) {
            @Override
            public void onSuccess(Response response, GoodsOrderDataBean goodsOrderDataBean) throws ParseException {
                    if (goodsOrderDataBean.getData()!=null){
                        list.addAll(goodsOrderDataBean.getData());
                        goodsOrderAdpater=new GoodsOrderAdpater(GoodsOrderActivity.this,list);
                        recyclShoporderOkList.setAdapter(goodsOrderAdpater);
                        tvGoodsOrderOrderTotalPrice.setText("￥"+goodsOrderDataBean.getTotalprice());
                        tvGoodsOrderEndTotalOrderPrice.setText("￥"+goodsOrderDataBean.getTotalprice());
                        countGoods();
                        tvGoodsOrderTotalCount.setText(TotalCount+"件");
                    }
            }

            @Override
            public void onError(Response response, int code, Exception e) {
            }
        });
    }
    //计算件数
    private void countGoods(){

        for (int i=0;i<list.size();i++){
            int count= Integer.parseInt(list.get(i).getGoodsNumber());
            TotalCount=TotalCount+count;
        }
    }
}
